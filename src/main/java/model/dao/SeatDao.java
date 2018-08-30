package model.dao;

import model.dao.DaoException;
import model.entity.Seat;

import java.util.List;

public interface SeatDao {

    /**
     * Find the seat by id
     * @param id
     * @throws DaoException
     */
    Seat findById(int id) throws DaoException;

    /**
     * Find all seats
     * @return list of seats
     * @throws DaoException
     */
    List<Seat> findAll() throws DaoException;

    /**
     * Create seat
     * @param seat
     * @return Created seat
     * @throws DaoException
     */
    Seat createSeat(Seat seat) throws DaoException;

    /**
     * Edit seat
     * @param seat
     * @return Edited seat
     * @throws DaoException
     */
    Seat updateSeat(Seat seat) throws DaoException;

    /**
     * Delete seat
     * Return true if the seat was deleted
     * @param seat
     * @return seat is deleted
     * @throws DaoException
     */
    boolean deleteSeat(Seat seat) throws DaoException;
}
