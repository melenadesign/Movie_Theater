package model.entity;

public class Movie {
    private int movieId;
    private String movieTitle;
    private String description;
    private int movieLength;
    private String posterUrl;
    private String trailerUrl;
//    private Rating movieRating;
//
//    public enum Rating {
//        BAD(1), BORING(2), NORMAL(3), GOOD(4), EXCELENT(5);
//
//
//    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getMovieLength() {
        return movieLength;
    }

    public void setMovieLength(int movieLength) {
        this.movieLength = movieLength;
    }

    public String getPosterUrl() {
        return posterUrl;
    }

    public void setPosterUrl(String posterUrl) {
        this.posterUrl = posterUrl;
    }

    public String getTrailerUrl() {
        return trailerUrl;
    }

    public void setTrailerUrl(String trailerUrl) {
        this.trailerUrl = trailerUrl;
    }

//    public Rating getRating() {
//        return movieRating;
//    }
//
//    public void setRating(Rating movieRating) {
//        this.movieRating = movieRating;
//    }

}
