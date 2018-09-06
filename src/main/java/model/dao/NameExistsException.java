package model.dao;

public class NameExistsException extends DaoException {
    public NameExistsException() {    };
    public NameExistsException(String message){
        super(message);
    }
    public NameExistsException(String message, Throwable cause){
        super(message, cause);
    }
}
