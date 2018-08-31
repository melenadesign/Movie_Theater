package model.entity;

import java.math.BigDecimal;

public class Ticket {
    private Long ticketId;
    private Showtime showtime;
    private Seat seat;
    private Status status;
<<<<<<< HEAD
    private User user;

    public Ticket(Long ticketId, Showtime showtime, Seat seat, Status status, User user) {
=======
    private BigDecimal price;
    private User user;

    public Ticket(Long ticketId, Showtime showtime, Seat seat, Status status, BigDecimal price, User user) {
>>>>>>> e917ae97c38a952990409d57a27eb88f8c567a44
        this.ticketId = ticketId;
        this.showtime = showtime;
        this.seat = seat;
        this.status = status;
<<<<<<< HEAD
=======
        this.price = price;
>>>>>>> e917ae97c38a952990409d57a27eb88f8c567a44
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

<<<<<<< HEAD
=======
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

>>>>>>> e917ae97c38a952990409d57a27eb88f8c567a44
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