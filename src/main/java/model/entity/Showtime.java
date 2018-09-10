package model.entity;


import java.math.BigDecimal;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Showtime {
    private int showtimeId;
//    private LocalDate date;
//    private LocalDateTime startTime;
    private Date date;
    private Time startTime;
    private Movie movie;

    private BigDecimal price;
    private Show_Status showStatus;

//    public Showtime(int showtimeId, Date date, Time startTime, Movie movie, BigDecimal price, Show_Status showStatus) {
//
//        this.showtimeId = showtimeId;
//        this.date = date;
//        this.startTime = startTime;
//        this.movie = movie;
//        this.price = price;
//        this.showStatus = showStatus;
//    }
    //todo builder may be override

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
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




public class Builder{

    private Showtime showtime;

    public Builder(){
         showtime = new Showtime();
    }

    public Builder setShowtimeId(int id){
        showtime.setShowtimeId(id);
        return this;
    }

    public Builder setMovie(Movie movie){
        showtime.setMovie(movie);
        return this;
    }

    public Builder setStartTime(Time start){
        showtime.setStartTime(start);
        return this;
    }

    public Builder setPrice(BigDecimal price){
        showtime.setPrice(price);
        return this;
    }

    public Builder setDate(java.sql.Date date){
        showtime.setDate(date);
        return this;
    }

    public Builder setShowStatus(Showtime.Show_Status status){
        showtime.setShowStatus(status);
        return this;
    }

    public Showtime build(){
        return showtime;
    }
}
}