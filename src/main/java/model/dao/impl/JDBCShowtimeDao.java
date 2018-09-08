package model.dao.impl;

import model.dao.DaoException;
import model.dao.ShowtimeDao;
import model.entity.Showtime;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class JDBCShowtimeDao implements ShowtimeDao {
    private Connection connection;
    public JDBCShowtimeDao(Connection connection)  { this.connection = connection; }

    @Override
    public Showtime findById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<Showtime> findByDate(Date date) throws DaoException {
        return null;
    }

    @Override
    public List<Showtime> findAll() throws DaoException {
        return null;
    }

    @Override
    public Showtime createShowtimes(Showtime showtime) throws DaoException {
        return null;
    }

    @Override
    public Showtime updateShowtime(Showtime showtime) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteShowtime(Showtime showtime) throws DaoException {
        return false;
    }
}
