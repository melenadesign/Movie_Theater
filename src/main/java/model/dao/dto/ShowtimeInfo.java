package model.dao.dto;

import java.math.BigDecimal;
import java.util.Arrays;

public class ShowtimeInfo {

    private int showtimeId;

    private String name;
//    private String genre;
//    private String director;
<<<<<<< HEAD
//    private String actor;
=======
>>>>>>> 198bc890ea27f0968c6d42ff167fd3303cbc388f
    private String description;
//    private Integer duration;

    private String date;
    private String time;
    private BigDecimal price;

<<<<<<< HEAD
    private long[] freeSeatsId;
=======
    private long[] freePlacesId;
>>>>>>> 198bc890ea27f0968c6d42ff167fd3303cbc388f

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

    public long[] getFreeSeatsId() {
<<<<<<< HEAD
        return freeSeatsId;
    }

    public void setFreeSeatsId(long[] freeSeatsId) {
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
=======
        return freePlacesId;
    }

    public void setFreeSeatsId(long[] freePlacesId) {
        this.freePlacesId = freePlacesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShowtimeInfo info = (ShowtimeInfo) o;

//        if (showtimeId != null ? !showtimeId.equals(info.showtimeId) : info.showtimeId != null) return false;
        if (name != null ? !name.equals(info.name) : info.name != null) return false;
//        if (genre != null ? !genre.equals(info.genre) : info.genre != null) return false;
//        if (director != null ? !director.equals(info.director) : info.director != null) return false;
        if (description != null ? !description.equals(info.description) : info.description != null) return false;
//        if (duration != null ? !duration.equals(info.duration) : info.duration != null) return false;
        if (date != null ? !date.equals(info.date) : info.date != null) return false;
        if (time != null ? !time.equals(info.time) : info.time != null) return false;
        if (price != null ? !price.equals(info.price) : info.price != null) return false;
        return Arrays.equals(freePlacesId, info.freePlacesId);
>>>>>>> 198bc890ea27f0968c6d42ff167fd3303cbc388f
    }

//todo hashcode tostring
}
