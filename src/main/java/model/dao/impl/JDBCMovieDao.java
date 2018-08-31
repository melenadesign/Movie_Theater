package model.dao.impl;

import model.dao.DaoException;
import model.dao.MovieDao;
import model.entity.Movie;

import java.sql.Connection;
import java.util.List;

public class JDBCMovieDao implements MovieDao {

    private Connection connection;

    public JDBCMovieDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Movie findById(int id) throws DaoException {
        return null;
    }

    @Override
    public List<Movie> findAll() throws DaoException {
        return null;
    }

    @Override
    public Movie createMovie(Movie movie) throws DaoException {
        return null;
    }

    @Override
    public Movie updateMovie(Movie movie) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteMovie(Movie movie) throws DaoException {
        return false;
    }
}
