package ua.tania.ann.model.dao;


import ua.tania.ann.model.dao.impl.DAOFactoryImpl;

import java.sql.Connection;

/**
 * Created by Таня on 17.08.2018.
 */
public abstract class DAOFactory {
    private static DAOFactory daoFactory;

    public MovieDao createMovieDao(Connection connection);
    public SeatDao createSeatDao(Connection connection);
    public ShowtimeDao createShowtimeDao(Connection connection);
    public TicketDao createTicketDao(Connection connection);
    public UserDao createUserDao(Connection connection);

    public static DaoFactory getInstance(){
        if( daoFactory == null ){
            synchronized (DaoFactory.class){
                if(daoFactory==null){
                    DaoFactory temp = new JDBCDaoFactory();
                    daoFactory = temp;
                }
            }
        }
        return daoFactory;
    }
}
