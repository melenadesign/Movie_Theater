package model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Showtime {
    private int showtimeId;
    private LocalDate date;
    private LocalDateTime startTime;
    private Movie movie;
    private BigDecimal price;
    private Show_Status showStatus;

    public Showtime(int showtimeId, LocalDate date, LocalDateTime startTime, Movie movie, BigDecimal price, Show_Status showStatus) {
        this.showtimeId = showtimeId;
        this.date = date;
        this.startTime = startTime;
        this.movie = movie;
        this.price = price;
        this.showStatus = showStatus;
    }
    //todo builder may be

    public enum Show_Status {
        ACTIVE, CANCELED
    }

    public Show_Status getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(Show_Status showStatus) {
        this.showStatus = showStatus;
    }

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
