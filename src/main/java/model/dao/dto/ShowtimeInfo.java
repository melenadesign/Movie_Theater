package model.dao.dto;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShowtimeInfo {

    private int showtimeId;

    private String name;
//    private String genre;
//    private String director;
//    private String actor;

    private String description;
//    private Integer duration;

    private String date;
    private String time;
    private BigDecimal price;
    private int[] freeSeatsId;

    public int getShowtimeId() {
        return showtimeId;
    }

    public void setShowtimeId(int showtimeId) {
        this.showtimeId = showtimeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getGenre() {
//        return genre;
//    }

//    public void setGenre(String genre) {
//        this.genre = genre;
//    }
//
//    public String getDirector() {
//        return director;
//    }

//    public void setDirector(String director) {
//        this.director = director;
//    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

//    public Integer getDuration() {
//        return duration;
//    }
//
//    public void setDuration(Integer duration) {
//        this.duration = duration;
//    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int[] getFreeSeatsId() {

        return freeSeatsId;
    }

    public void setFreeSeatsId(int[] freeSeatsId) {
        this.freeSeatsId = freeSeatsId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        ShowtimeInfo showtimeInfo = (ShowtimeInfo) obj;


        if (name != null ? !name.equals(showtimeInfo.name) : showtimeInfo.name != null) return false;
        if (description != null ? !description.equals(showtimeInfo.description) : showtimeInfo.description != null) return false;
        if (date != null ? !date.equals(showtimeInfo.date) : showtimeInfo.date != null) return false;
        if (time != null ? !time.equals(showtimeInfo.time) : showtimeInfo.time != null) return false;
        if (price != null ? !price.equals(showtimeInfo.price) : showtimeInfo.price != null) return false;
        return Arrays.equals(freeSeatsId, showtimeInfo.freeSeatsId);

    }



//todo hashcode tostring
}
