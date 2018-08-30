package model.dao;

import model.entity.Movie;

import java.util.List;

public interface MovieDao {

    /**
     * Find movie by id
     * @param id
     * @throws DaoException
     */
    Movie findById(int id) throws DaoException;

    /**
     * Find all movies
     * @return list of all movies
     * @throws DaoException
     */
    List<Movie> findAll() throws DaoException;

    /**
     * Create movie
     * @param movie
     * @return Created movie
     * @throws DaoException
     */
    Movie createMovie(Movie movie) throws DaoException;

    /**
     * Edit movie
     * @param movie
     * @return Edited movie
     * @throws DaoException
     */
    Movie updateMovie(Movie movie) throws DaoException;

    /**
     * Delete movie
     * Return true if movie was deleted
     * @param movie
     * @return movie is deleted
     * @throws DaoException
     */
    boolean deleteMovie(Movie movie) throws DaoException;
}
