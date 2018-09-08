package model.dao.impl;

import model.dao.DaoException;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    public static final String URL = "jdbc:mysql://localhost:3306/movie_theater";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "root";
    private static DataSource dataSource;
    private static volatile ConnectionPool instance;
    private static final Logger log = Logger.getLogger(ConnectionPool.class);

    public static DataSource getDataSource(){

        if (dataSource == null){
            synchronized (ConnectionPool.class) {
                if (dataSource == null) {
                    BasicDataSource ds = new BasicDataSource();
                    ds.setUrl(URL);
                    ds.setUsername(DB_USER);
                    ds.setPassword(DB_PASS);
//                    ds.setMinIdle(5);
                    ds.setMaxIdle(10);
                    ds.setMaxOpenPreparedStatements(60);
                    dataSource = ds;
                }
            }
        }
        return dataSource;

    }

    public static ConnectionPool getInstance(){
        ConnectionPool localInstance = instance;
        if(localInstance == null){
            synchronized (ConnectionPool.class){
                localInstance = instance;
                if(localInstance == null){
                    localInstance = instance = new ConnectionPool();
                }
            }
        }
        return localInstance;
    }

    public synchronized Connection getConnection() throws DaoException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            log.error("Cannot get connection", e);
            throw new DaoException("Cannot get connection", e);
        }
    }
}
