package model.service;


import model.entity.Showtime;

import java.sql.Date;
import java.util.List;

public interface ShowtimeService {
    /**
     * Find and return Showtime by id
     * @param id
     * @return Showtime
     * @throws ServiceException
     */
    Showtime getShowtimeById(int id) throws ServiceException;

    /**
     * Find all Showtimes by date
     * @param date
     * @return list of Showtimes
     * @throws ServiceException
     */
    List<Showtime> getActiveShowtimesByDate(Date date) throws ServiceException;

    /**
     * Find Showtime by id
     * and prepare information
     * about Showtime
     * @param ShowtimeId
     * @return JSON String
     * @throws ServiceException
     */
    String getShowtimeInfoJson(int ShowtimeId) throws ServiceException;

    /**
     * Find Showtime.
     * If Showtime exist
     * and is active cancel it
     * Showtime and tickets of Showtime
     * @param showtimeId
     * @throws ServiceException
     */
    void cancelShowtime(int showtimeId) throws ServiceException;

    /**
     * Create Showtime
     * @param Showtime
     * @return Created Showtime
     * @throws ServiceException
     */
    Showtime addShowtime(Showtime Showtime) throws ServiceException, ShowtimeSlotBusyException;
}