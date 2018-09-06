package model.service;

import model.entity.Ticket;
import model.entity.User;

import java.util.List;

public interface TicketService {
    /**
     * Find all tickets by user id
     * @param userId
     * @return list of tickets
     * @throws ServiceException
     */
    List<Ticket> getTicketsByUserId(int userId) throws ServiceException;

    /**
     * Find all tickets by showtimeId
     * @param showtimeId
     * @return list of tickets
     * @throws ServiceException
     */
    List<Ticket> getTicketsByShowtimeId(int showtimeId) throws ServiceException;

    /**
     * Find and buy tickets
     * for user
     * @param user
     * @param ticketId
     * @return list of bought tickets
     * @throws ServiceException
     */
    List<Ticket> buyTickets(User user, List<Long> ticketId) throws ServiceException;
}
