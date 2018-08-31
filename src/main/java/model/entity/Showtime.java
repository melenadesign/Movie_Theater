package model.entity;

<<<<<<< HEAD
import java.math.BigDecimal;
=======
>>>>>>> e917ae97c38a952990409d57a27eb88f8c567a44
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Showtime {
    private int showtimeId;
    private LocalDate date;
    private LocalDateTime startTime;
    private Movie movie;
<<<<<<< HEAD
    private BigDecimal price;
    private Show_Status showStatus;

    public Showtime(int showtimeId, LocalDate date, LocalDateTime startTime, Movie movie, BigDecimal price, Show_Status showStatus) {
=======
    private Show_Status showStatus;

    public Showtime(int showtimeId, LocalDate date, LocalDateTime startTime, Movie movie, Show_Status showStatus) {
>>>>>>> e917ae97c38a952990409d57a27eb88f8c567a44
        this.showtimeId = showtimeId;
        this.date = date;
        this.startTime = startTime;
        this.movie = movie;
<<<<<<< HEAD
        this.price = price;
=======
>>>>>>> e917ae97c38a952990409d57a27eb88f8c567a44
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

<<<<<<< HEAD
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

=======
>>>>>>> e917ae97c38a952990409d57a27eb88f8c567a44
}
