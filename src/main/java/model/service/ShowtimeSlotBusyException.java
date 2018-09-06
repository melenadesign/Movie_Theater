package model.service;

public class ShowtimeSlotBusyException extends Throwable {
    public ShowtimeSlotBusyException() { };
    public ShowtimeSlotBusyException(String message){
        super(message);
    }
    public ShowtimeSlotBusyException(String message, Throwable cause){
        super(message, cause);
    }
}
