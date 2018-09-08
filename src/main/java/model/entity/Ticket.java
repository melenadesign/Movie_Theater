package model.entity;

import java.math.BigDecimal;

public class Ticket {
    private Long ticketId;
    private Showtime showtime;
    private Seat seat;
    private Status status;
    private User user;

//    public Ticket(Long ticketId, Showtime showtime, Seat seat, Status status, User user) {
//
//        this.ticketId = ticketId;
//        this.showtime = showtime;
//        this.seat = seat;
//        this.status = status;
//        this.user = user;
//    }
    //todo override

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


    public static class Builder {
        private Ticket ticket;

        public Builder(){
            ticket = new Ticket();
        }

        public Builder setTicketId(Long id){
            ticket.setTicketId(id);
            return this;
        }

        public Builder setUser(User user){
            ticket.setUser(user);
            return this;
        }

        public Builder setShowtime(Showtime showtime){
            ticket.setShowtime(showtime);
            return this;
        }

        public Builder setSeat(Seat seat){
            ticket.setSeat(seat);
            return this;
        }

        public Builder setStatus(Status status){
            ticket.setStatus(status);
            return this;
        }

        public Ticket build(){
            return ticket;
        }
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + ticketId +
                ", user=" + user +
                ", showtime=" + showtime +
                ", seat=" + seat +
                ", status=" + status +
                '}';
    }
}