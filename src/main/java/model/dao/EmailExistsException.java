package model.dao;

public class EmailExistsException extends DaoException {
    public EmailExistsException() {    };
    public EmailExistsException(String message){
        super(message);
    }
    public EmailExistsException(String message, Throwable cause){
        super(message, cause);
    }
}
