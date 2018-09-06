package model.service.impl;

import model.dao.DaoException;
import model.dao.DaoFactory;
import model.dao.TicketDao;
import model.dao.impl.ConnectionPool;
import model.entity.Ticket;
import model.entity.User;
import model.service.ServiceException;
import model.service.TicketService;
import org.apache.log4j.Logger;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TicketServiceImp implements TicketService {
    private static Logger log = Logger.getLogger(TicketServiceImp.class);
    DaoFactory factory = DaoFactory.getInstance();

    @Override
    public List<Ticket> getTicketsByUserId(int userId) throws ServiceException {
        try (Connection connection = ConnectionPool.getInstance().getConnection()){

            TicketDao ticketDao = factory.createTicketDao();


            return  ticketDao.findByUserId(userId).stream()
                    .sorted(Comparator.comparing(Ticket::getTicketId).reversed())
                    .collect(Collectors.toList());
        } catch (DaoException | SQLException e) {
            log.error("Could not get tickets by userId=" + userId, e);
            throw new ServiceException("Could not get tickets by userId=" + userId, e);
        }
    }

    @Override
    public List<Ticket> getTicketsByShowtimeId(int showtimeId) throws ServiceException {
        try (Connection connection = ConnectionPool.getInstance().getConnection()){
            TicketDao ticketDao = factory.createTicketDao();

            return ticketDao.findByShowtimeId(showtimeId).stream()
                    .sorted(Comparator.comparing(Ticket::getTicketId))
                    .collect(Collectors.toList());
        } catch (DaoException | SQLException e) {
            log.error("Could not get tickets by showtimeId=" + showtimeId, e);
            throw new ServiceException("Could not get tickets by showtimeId=" + showtimeId, e);
        }
    }

    @Override
    public List<Ticket> buyTickets(User user, List<Long> ticketsId) throws ServiceException {
        List<Ticket> tickets = new ArrayList<>();

        if(user==null){
            throw new ServiceException("Could not get user");
        }

        try (Connection connection = ConnectionPool.getInstance().getConnection()){

            connection.setAutoCommit(false);

            for(Long ticketId: ticketsId){
                tickets.add(buyTicket(ticketId, user, connection));
            }

            connection.commit();
        } catch (DaoException | SQLException e) {
            log.error("Could not update tickets", e);
            throw new ServiceException("Could not update tickets", e);
        }

        return tickets;
    }

    private Ticket buyTicket(Long ticketId, User user, Connection connection) throws DaoException, ServiceException, SQLException {
        TicketDao ticketDao = factory.createTicketDao();
        Ticket ticket = ticketDao.findById(ticketId);

        if (ticket != null && ticket.getStatus().equals(Ticket.Status.ACTIVE)){
            ticket.setStatus(Ticket.Status.BOUGHT);
            ticket.setUser(user);
            return ticketDao.updateTicket(ticket);
        } else {
            connection.rollback();
            throw new ServiceException("Ticket is already bought");
        }
    }
}