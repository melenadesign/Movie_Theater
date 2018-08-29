package model.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Showtime {
    private int showtimeId;
    private LocalDate date;
    private LocalDateTime startTime;
    private Movie movie;
    private SHOW_STATUS showStatus;

    public enum SHOW_STATUS {
        ACTIVE, CANCELED
    }

    public SHOW_STATUS getShowStatus() {
        return showStatus;
    }

    public void setShowStatus(SHOW_STATUS showStatus) {
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

}
