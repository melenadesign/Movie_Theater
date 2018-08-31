package model.dao;

public class DaoException extends Exception {

    public DaoException(){};

    public DaoException(String message){
        super(message);
    }

    public DaoException(String message, Throwable t){
        super(message, t);
    }
}
