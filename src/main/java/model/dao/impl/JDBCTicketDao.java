package model.dao.impl;

import model.dao.DaoException;
import model.dao.TicketDao;
import model.entity.Ticket;

import java.sql.Connection;
import java.util.List;

public class JDBCTicketDao implements TicketDao {
    private Connection connection;

    public JDBCTicketDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Ticket findById(long id) throws DaoException {
        return null;
    }

    @Override
    public List<Ticket> findByUserId(int userId) throws DaoException {
        return null;
    }

    @Override
    public List<Ticket> findByShowtimeId(int showtimeId) throws DaoException {
        return null;
    }

    @Override
    public List<Ticket> findAll() throws DaoException {
        return null;
    }

    @Override
    public Ticket createTicket(Ticket ticket) throws DaoException {
        return null;
    }

    @Override
    public Ticket updateTicket(Ticket ticket) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteTicket(Ticket ticket) throws DaoException {
        return false;
    }
}
