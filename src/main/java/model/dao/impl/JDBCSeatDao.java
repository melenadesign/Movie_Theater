package model.dao.impl;

import model.dao.DaoException;
import model.dao.SeatDao;
import model.entity.Seat;

import java.sql.Connection;
import java.util.List;

public class JDBCSeatDao implements SeatDao {
    private Connection connection;

    public JDBCSeatDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Seat findById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<Seat> findAll() throws DaoException {
        return null;
    }

    @Override
    public Seat createSeat(Seat seat) throws DaoException {
        return null;
    }

    @Override
    public Seat updateSeat(Seat seat) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteSeat(Seat seat) throws DaoException {
        return false;
    }
}
