package model.dao.impl;

import model.dao.*;
import model.entity.Ticket;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class JDBCTicketDao implements TicketDao {
    private static Logger log = Logger.getLogger(JDBCTicketDao.class);
    private static ResourceBundle QUERIES = ResourceBundle.getBundle("Queries");
    private Connection connection;


    private static final String TICKET_ID = "ticketId";
    private static final String TICKET_USER_ID = "userId";
    private static final String TICKET_SHOWTIME_ID = "showtime_id";
    private static final String TICKET_SEAT_ID = "seat_id";
    private static final String TICKET_STATUS = "status";


    public JDBCTicketDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Ticket findById(long id) throws DaoException {
        List<Ticket> tickets;
        try(PreparedStatement statement = connection.prepareStatement(QUERIES.getString("ticket.select.by.id"))) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            tickets = handleResultSet(resultSet);
        } catch (SQLException | DaoException e) {
            log.error("Could not get ticket by id=" + id, e);
            throw  new DaoException("Could not get ticket by id=" + id, e);
        }

        if (tickets.isEmpty()){
            return null;
        }

        return tickets.get(0);
        
    }

    @Override
    public List<Ticket> findByUserId(int userId) throws DaoException {
        List<Ticket> tickets;

        try(PreparedStatement statement = connection.prepareStatement(QUERIES.getString("ticket.select.by.user.id"))) {
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            tickets = handleResultSet(resultSet);
        } catch (SQLException | DaoException e) {
            log.error("Could not get ticket by user id=" + userId, e);
            throw  new DaoException("Could not get ticket by user id=" + userId, e);
        }

        return tickets;
    }

    @Override
    public List<Ticket> findByShowtimeId(int showtimeId) throws DaoException {
        return null;
    }

    @Override
    public List<Ticket> findAll() throws DaoException {
        return null;
    }
    
    private List<Ticket> handleResultSet(ResultSet resultSet) throws DaoException {
        List<Ticket> tickets = new ArrayList<>();

        try(Connection connection = ConnectionPool.getInstance().getConnection();) {

            UserDao userDao = DaoFactory.getInstance().createUserDao();

            ShowtimeDao showtimeDao = DaoFactory.getInstance().createShowtimeDao();

            SeatDao seatDao = DaoFactory.getInstance().createSeatDao();

            while (resultSet.next()){
                Ticket ticket = new Ticket.Builder()
                        .setTicketId(resultSet.getLong(TICKET_ID))
                        .setUser(userDao.findById(resultSet.getInt(TICKET_USER_ID)))
                        .setShowtime(showtimeDao.findById(resultSet.getInt(TICKET_SHOWTIME_ID)))
                        .setSeat(seatDao.findById(resultSet.getInt(TICKET_SEAT_ID)))
                        .setStatus(Ticket.Status.valueOf(resultSet.getString(TICKET_STATUS).toUpperCase()))
                        .build();

                tickets.add(ticket);
            }
        } catch (SQLException e) {
            log.error("Could not parse result set", e);
            throw new DaoException("Could not parse result set", e);
        }

        return tickets;
    }

    @Override
    public Ticket createTicket(Ticket ticket) throws DaoException {
        try(PreparedStatement statement = connection.prepareStatement(QUERIES.getString("ticket.create"), Statement.RETURN_GENERATED_KEYS)){
            statementForCreate(statement, ticket);

            statement.executeUpdate();

            long autoPK;

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                autoPK = resultSet.getLong(1);
                ticket = findById(autoPK);
            } else {
                throw new DaoException();
            }

        } catch (SQLException | DaoException e) {
            log.error("Couldnot create ticket " + ticket, e);
            throw new DaoException("Couldnot create ticket " + ticket, e);
        }

        return ticket;
    }

    private void statementForCreate(PreparedStatement statement, Ticket ticket) throws DaoException {
        try{
            if(ticket.getUser() != null){
                statement.setLong(1, ticket.getUser().getUserId());
            } else {
                statement.setString(1, null);
            }
            statement.setInt(2, ticket.getShowtime().getShowtimeId());
            statement.setInt(3, ticket.getSeat().getSeatId());
            statement.setString(4, ticket.getStatus().toString());

        } catch (SQLException e) {
            log.error("Could not set prepared statement", e);
            throw new DaoException("Could not set prepared statement", e);
        }
    }
    
    
    @Override
    public Ticket updateTicket(Ticket ticket) throws DaoException {
        try(PreparedStatement statement = connection.prepareStatement(QUERIES.getString("ticket.update"))){
            preparedStatementForUpdate(statement, ticket);

            statement.executeUpdate();

            ticket = findById(ticket.getTicketId());
        } catch (SQLException | DaoException e) {
            log.error("Could not update ticket " + ticket, e);
            throw new DaoException("Could not update ticket " + ticket, e);
        }

        return ticket;
    }
    
    private void preparedStatementForUpdate(PreparedStatement statement, Ticket ticket) throws DaoException {
        try{
            if(ticket.getUser() != null){
                statement.setInt(1, ticket.getUser().getUserId());
            } else {
                statement.setString(1, null);
            }
            statement.setInt(2, ticket.getShowtime().getShowtimeId());
            statement.setInt(3, ticket.getSeat().getSeatId());
            statement.setString(4, ticket.getStatus().toString());
            statement.setLong(5, ticket.getTicketId());
        } catch (SQLException e) {
            log.error("Could not set prepared statement", e);
            throw new DaoException("Could not set prepared statement", e);
        }
    }
    @Override
    public boolean deleteTicket(Ticket ticket) throws DaoException {
        throw new UnsupportedOperationException();
    }
}
