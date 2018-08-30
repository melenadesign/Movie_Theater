package model.dao;

import model.entity.Showtime;

import java.time.LocalDate;
import java.util.List;

public interface ShowtimeDao {

    /**
     * Find showtime by id
     * @param id
     * @return showtime
     * @throws DaoException
     */
    Showtime findById(int id) throws DaoException;

    /**
     * Find all showtimes by date
     * @param date
     * @return list of all showtimes
     * @throws DaoException
     */
    List<Showtime> findByDate(LocalDate date) throws DaoException;

    /**
     * Find all showtimes
     * @return list of showtimes
     * @throws DaoException
     */
    List<Showtime> findAll() throws DaoException;

    /**
     * Create showtime
     * @param showtime
     * @return Created showtime
     * @throws DaoException
     */
    Showtime createShowtimes(Showtime showtime) throws DaoException;

    /**
     * Edit showtime
     * @param showtime
     * @return Edited showtime
     * @throws DaoException
     */
    Showtime updateShowtime(Showtime showtime) throws DaoException;

    /**
     * Delete showtime
     * Return true if showtime was deleted
     * @param showtime
     * @return showtime is deleted
     * @throws DaoException
     */
    boolean deleteShowtime(Showtime showtime) throws DaoException;
}
