package model.dao;

import model.dao.impl.JDBCDaoFactory;
import model.entity.Seat;
import model.entity.Showtime;

import java.sql.Connection;

public abstract class DaoFactory {
    private static DaoFactory daoFactory;

    public abstract UserDao createUserDao();
    public abstract MovieDao createMovieDao();
    public abstract TicketDao createTicketDao();
    public abstract ShowtimeDao createShowtimeDao();
    public abstract SeatDao createSeatDao();

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