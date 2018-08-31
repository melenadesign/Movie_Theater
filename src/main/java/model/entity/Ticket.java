package model.entity;

import java.math.BigDecimal;

public class Ticket {
    private Long ticketId;
    private Showtime showtime;
    private Seat seat;
    private Status status;
    private User user;

    public Ticket(Long ticketId, Showtime showtime, Seat seat, Status status, User user) {
        this.ticketId = ticketId;
        this.showtime = showtime;
        this.seat = seat;
        this.status = status;
        this.user = user;
    }
    //todo builder may be

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public enum Status{
    ACTIVE, INACTIVE, BOUGHT
}



}