package model.dao.impl;

import model.dao.DaoException;
import model.dao.UserDao;
import model.entity.User;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUserDao implements UserDao {
    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public User findById(int id) throws DaoException {
        return null;
    }

    @Override
    public User findByEmail(String email) throws DaoException {
        return null;
    }

    @Override
    public List<User> findAll() throws DaoException {
        return null;
    }

    @Override
    public User createUser(User user) throws DaoException {
        return null;
    }

    @Override
    public User updateUser(User user) throws DaoException {
        return null;
    }

    @Override
    public boolean deleteUser(User user) throws DaoException {
        return false;
    }
}
