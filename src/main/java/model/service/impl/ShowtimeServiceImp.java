package model.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import model.dao.*;
import model.dao.dto.ShowtimeInfo;
import model.dao.impl.ConnectionPool;
import model.entity.Seat;
import model.entity.Showtime;
import model.entity.Ticket;
import model.service.ServiceException;
import model.service.ShowtimeService;
import model.service.ShowtimeSlotBusyException;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ShowtimeServiceImp implements ShowtimeService {
    private static Logger log = Logger.getLogger(ShowtimeServiceImp.class);
    private DaoFactory factory = DaoFactory.getInstance();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Showtime getShowtimeById(int id) throws ServiceException {
        try (Connection connection = ConnectionPool.getInstance().getConnection()){
            ShowtimeDao showtimeDao = factory.createShowtimeDao();

            return showtimeDao.findById(id);
        } catch (DaoException | SQLException e) {
            log.error("Could not get showtime by id=" + id, e);
            throw new ServiceException("Could not get showtime by id=" + id, e);
        }
    }

    @Override
    public List<Showtime> getActiveShowtimesByDate(Date date) throws ServiceException {
        try (Connection connection = ConnectionPool.getInstance().getConnection()){
            ShowtimeDao showtimeDao = factory.createShowtimeDao();

            return showtimeDao.findByDate(date).stream()
                    .filter(showtime -> Showtime.Show_Status.ACTIVE.equals(showtime.getShowStatus()))
                    .sorted(Comparator.comparing(Showtime::getStartTime))
                    .collect(Collectors.toList());
        } catch (DaoException | SQLException e) {
            log.error("Could not get active showtimes by date=" + date, e);
            throw new ServiceException("Could not get active showtimes by date=" + date, e);
        }
    }

    @Override
    public String getShowtimeInfoJson(int showtimeId) throws ServiceException {
        try {
            return objectMapper.writeValueAsString(getShowtimeInfo(showtimeId));
        } catch (JsonProcessingException e) {
            log.error("Could not processing Showtime info", e);
            throw new ServiceException("Could not processing Showtime info", e);
        }
    }

    private ShowtimeInfo getShowtimeInfo(int showtimeId) throws ServiceException {
        try (Connection connection = ConnectionPool.getInstance().getConnection()){
            ShowtimeDao showtimeDao = factory.createShowtimeDao();
            TicketDao ticketDao = factory.createTicketDao();

            Showtime showtime = showtimeDao.findById(showtimeId);
            List<Ticket> tickets = ticketDao.findByShowtimeId(showtimeId);

            if (showtime == null){
                log.info("Could not get showtime by id=" + showtimeId);
                throw new ServiceException("Could not get showtime by id=" + showtimeId);
            }

            return setupShowtimeInfo(showtime, tickets);
        } catch (DaoException | SQLException e) {
            log.error("Could not get showtime info by id=" + showtimeId, e);
            throw new ServiceException("Could not get showtime info by id=" + showtimeId, e);
        }
    }

    private ShowtimeInfo setupShowtimeInfo(Showtime Showtime, List<Ticket> tickets){
        ShowtimeInfo info = new ShowtimeInfo();

        info.setShowtimeId(Showtime.getShowtimeId());
        info.setName(Showtime.getMovie().getMovieTitle());
//        info.setGenre(Showtime.getFilm().getGenre());
//        info.setDirector(Showtime.getFilm().getDirector());
        info.setDescription(Showtime.getMovie().getDescription());
//        info.setDuration(Showtime.getMovie().getMovieLength());
        info.setPrice(Showtime.getPrice());
        info.setDate(Showtime.getDate().toString());
        info.setTime(Showtime.getStartTime().toString());
        info.setFreeSeatsId(tickets.stream()
                .filter(ticket -> Ticket.Status.ACTIVE.equals(ticket.getStatus()))
                .mapToLong(ticket -> ticket.getSeat().getSeatId())
                .toArray());

        return info;
    }
    
    @Override
    public void cancelShowtime(int showtimeId) throws ServiceException {
//        if (showtimeId == null){
//            log.error("showtimeId is null");
//            throw new ServiceException("showtimeId is null");
//        }

        try (Connection connection = ConnectionPool.getInstance().getConnection()){
            connection.setAutoCommit(false);

            try {
                CancelShowtime(showtimeId, connection);
                CancelTickets(showtimeId, connection);
            }catch (DaoException e){
                connection.rollback();
                log.error("Could not cancel Showtime by showtimeId" + showtimeId, e);
                throw new ServiceException("Could not cancel Showtime by showtimeId" + showtimeId, e);
            }

            connection.commit();
        } catch (SQLException | DaoException e) {
            log.error("Could not cancel Showtime by showtimeId" + showtimeId, e);
            throw new ServiceException("Could not cancel Showtime by showtimeId" + showtimeId, e);
        }
    }


    private void CancelShowtime(int showtimeId, Connection connection) throws DaoException, SQLException, ServiceException {
        ShowtimeDao showtimeDao = factory.createShowtimeDao();
        Showtime showtime = showtimeDao.findById(showtimeId);

        if(showtime == null
                || Showtime.Show_Status.CANCELED.equals(showtime.getShowStatus())){
            connection.rollback();
            log.info("Showtime already Cancel or not exist, showtimeId=" + showtimeId);
            throw new ServiceException("SShowtime already Cancel or not exist, showtimeId=" + showtimeId);
        }

        showtime.setShowStatus(Showtime.Show_Status.CANCELED);
        showtimeDao.updateShowtime(showtime);
    }

    private void CancelTickets(int showtimeId, Connection connection) throws DaoException {
        TicketDao ticketDao = factory.createTicketDao();
        List<Ticket> tickets = ticketDao.findByShowtimeId(showtimeId);
        for(Ticket ticket: tickets){
            ticket.setStatus(Ticket.Status.INACTIVE);

            ticketDao.updateTicket(ticket);
        }
    }

    @Override
    public Showtime addShowtime(Showtime showtime) throws ServiceException, ShowtimeSlotBusyException {
        try (Connection connection = ConnectionPool.getInstance().getConnection()){
           connection.setAutoCommit(false);

            try {
                showtime = createShowtime(showtime, connection);
            } catch (ShowtimeSlotBusyException e) {
                e.printStackTrace();
            }

            connection.commit();
        } catch (SQLException | DaoException e) {
            log.error("Could not create showtime" + showtime, e);
            throw new ServiceException("Could not create showtime" + showtime, e);
        }

        return showtime;
    }

    private Showtime createShowtime(Showtime showtime, Connection connection) throws ServiceException, SQLException, ShowtimeSlotBusyException {
        ShowtimeDao showtimeDao = factory.createShowtimeDao();

        if(isTimeOfShowtimeFree(showtime, connection)){
            try{
                showtime.setShowStatus(Showtime.Show_Status.ACTIVE);
                showtime = showtimeDao.createShowtimes(showtime);
                createTickets(showtime, connection);
            } catch (DaoException e){
                connection.rollback();
                log.error("Could not create showtime" + showtime, e);
                throw new ServiceException("Could not create showtime" + showtime, e);
            }
        } else {
            connection.rollback();
            throw new ShowtimeSlotBusyException("This timeslot is busy" + showtime);
        }
        return showtime;
    }

    private boolean isTimeOfShowtimeFree(Showtime showtime, Connection connection) throws ServiceException, SQLException {
        ShowtimeDao showtimeDao = factory.createShowtimeDao();

        List<Showtime> showtimes;

        try {
            showtimes = showtimeDao.findByDate(showtime.getDate());
        } catch (DaoException e) {
            connection.rollback();
            log.error("Could not get showtimes by date" + showtime.getDate(), e);
            throw new ServiceException("Could not get showtimes by date" + showtime.getDate(), e);
        }

        return isShowtimeCrossShowtimes(showtime, showtimes);
    }

    private boolean isShowtimeCrossShowtimes(Showtime showtime, List<Showtime> showtimes){
        Timestamp showtimeBegin = getShowtimeBegin(showtime);
        Timestamp showtimeEnd = getShowtimeEnd(showtime);

        Timestamp nextShowtimeBegin = getShowtimeBegin(getNextShowtime(showtimeBegin, showtimes));
        Timestamp previousShowtimeEnd = getShowtimeEnd(getPreviousShowtime(showtimeEnd, showtimes));

        boolean isCrossPreviousShowtime = previousShowtimeEnd != null && showtimeBegin.before(previousShowtimeEnd);
        boolean isCrossNextShowtime = nextShowtimeBegin != null && nextShowtimeBegin.before(showtimeEnd);

        return !(isCrossPreviousShowtime | isCrossNextShowtime);
    }

    private Timestamp getShowtimeBegin(Showtime showtime){
        return showtime == null ? null : new Timestamp(showtime.getStartTime().getTime() + showtime.getDate().getTime());
    }

    private Timestamp getShowtimeEnd(Showtime showtime){
        return showtime == null ? null : new Timestamp(showtime.getStartTime().getTime()
                + showtime.getDate().getTime()
                + showtime.getMovie().getMovieLength() * 60 * 1000);
    }

    private Showtime getNextShowtime(Timestamp beginOfCurrentShowtime, List<Showtime> showtimes){
        return showtimes.stream()
                .filter(s -> s.getShowStatus().equals(Showtime.Show_Status.ACTIVE))
                .filter(s -> new Timestamp(s.getStartTime().getTime() + s.getDate().getTime()).after(beginOfCurrentShowtime))
                .min(Comparator.comparing(Showtime::getStartTime))
                .orElse(null);
    }

    private Showtime getPreviousShowtime(Timestamp beginOfCurrentShowtime, List<Showtime> showtimes){
        return showtimes.stream()
                .filter(s -> s.getShowStatus().equals(Showtime.Show_Status.ACTIVE))
                .filter(s -> new Timestamp(s.getStartTime().getTime() + s.getDate().getTime()).before(beginOfCurrentShowtime))
                .max(Comparator.comparing(Showtime::getStartTime))
                .orElse(null);
    }

    private void createTickets(Showtime showtime, Connection connection) throws DaoException {
        SeatDao seatDao = factory.createSeatDao();
        TicketDao ticketDao = factory.createTicketDao();

        List<Seat> seats = seatDao.findAll();

        for (Seat Seat: seats){
            Ticket ticket = createTicket(showtime, Seat);

            ticketDao.createTicket(ticket);
        }
    }

    private Ticket createTicket(Showtime showtime, Seat Seat){
        return new Ticket.Builder()
                .setStatus(Ticket.Status.ACTIVE)
                .setSeat(Seat)
                .setShowtime(showtime)
                .setUser(null)
                .build();
    }    
}