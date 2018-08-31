package model.dao.impl;

import model.dao.DaoException;
import model.dao.UserDao;
import model.entity.User;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.*;

public class JDBCUserDao implements UserDao {
    private static Logger log = Logger.getLogger(JDBCUserDao.class);
    private static ResourceBundle QUERIES = ResourceBundle.getBundle("Queries");
    private Connection connection;

    private static final String USER_ID = "user_id";
    private static final String USER_NAME = "username";
    private static final String USER_EMAIL = "email";
    private static final String USER_PASSWORD = "password";
    private static final String USER_PHONE = "phone";
    private static final String USER_ROLE = "role";



    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }


    @Override
    public User findById(int id) throws DaoException {
        List<User> users;

        try(PreparedStatement statement = connection.prepareStatement(QUERIES.getString("user.select.by.id"))) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            users = handleResultSet(resultSet);
        } catch (SQLException | DaoException e) {
            log.error("Could not get user by id=" + id, e);
            throw  new DaoException("Could not get user by id=" + id, e);
        }

        if (users.isEmpty()){
            return null;
        }

        return users.get(0);
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
    private List<User> handleResultSet(ResultSet resultSet) throws DaoException {
        List<User> users = new ArrayList<>();

        try {
            while (resultSet.next()){
                User user = new User(USER_ID, USER_PASSWORD, USER_EMAIL, USER_NAME, USER_PHONE, USER_ROLE);

                users.add(user);
            }
        } catch (SQLException e) {
            log.error("Could not read result set", e);
            throw new DaoException("Could not read result set", e);
        }

        return users;
    }


    USER_ID = "user_id";
private static final String USER_NAME = "username";
private static final String USER_EMAIL = "email";
private static final String USER_PASSWORD = "password";
private static final String USER_PHONE = "phone";
private static final String USER_ROLE = "role";