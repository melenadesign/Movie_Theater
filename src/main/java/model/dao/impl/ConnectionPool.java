package model.dao.impl;

import org.apache.commons.dbcp.BasicDataSource;

import javax.sql.DataSource;

public class ConnectionPoolHolder {
    public static final String URL = "jdbc:mysql://localhost:3306/movie_theater";
    public static final String DB_USER = "root";
    public static final String DB_PASS = "root";
    private static volatile DataSource dataSource;
    public static DataSource getDataSource(){

        if (dataSource == null){
            synchronized (ConnectionPoolHolder.class) {
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


}
