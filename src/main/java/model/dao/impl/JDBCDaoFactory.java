package model.dao.impl;

import model.dao.*;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDaoFactory extends DaoFactory {

    private DataSource dataSource = ConnectionPool.getDataSource();

    @Override
    public UserDao createUserDao() {
        return new JDBCUserDao(getConnection());
    }
    @Override
    public TicketDao createTicketDao() {
        return new JDBCTicketDao(getConnection());
    }
    @Override
    public ShowtimeDao createShowtimeDao() {
        return new JDBCShowtimeDao(getConnection());
    }
    @Override
    public MovieDao createMovieDao() {
        return new JDBCMovieDao(getConnection());
    }
    @Override
    public SeatDao createSeatDao() {
        return new JDBCSeatDao(getConnection());
    }
    private Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
