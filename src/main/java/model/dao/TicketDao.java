package dao;

import java.util.List;

public interface TicketDao {

    /**
     * Find ticket by id
     * @param id
     * @throws DaoException
     */
    Ticket findById(long id) throws DaoException;

    /**
     * Find all tickets by user id
     * @param id
     * @return list of tickets for user
     * @throws DaoException
     */
    List<Ticket> findByUserId(int userId) throws DaoException;

    /**
     * Find all tickets by showtimeId
     * @param showtimeId
     * @return list of tickets
     * @throws DaoException
     */
    List<Ticket> findByShowtimeId(int showtimeId) throws DaoException;

    /**
     * Find all tickets
     * @return list of all tickets
     * @throws DaoException
     */
    List<Ticket> findAll() throws DaoException;

    /**
     * Create ticket
     * @param ticket
     * @return Created ticket
     * @throws DaoException
     */
    Ticket createTicket(Ticket ticket) throws DaoException;

    /**
     * Edit ticket
     * @param ticket
     * @return Edited ticket
     * @throws DaoException
     */
    Ticket updateTicket(Ticket ticket) throws DaoException;

    /**
     * Delete ticket
     * Return true if ticket was deleted
     * @param ticket
     * @return is deleted
     * @throws DaoException
     */
    boolean deleteTicket(Ticket ticket) throws DaoException;
}
