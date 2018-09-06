package model.dao.impl;

import model.dao.DaoException;
import model.dao.EmailExistsException;
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
//    private static final String USER_PHONE = "phone";
    private static final String USER_ROLE = "isAdmin";



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
    public User findByName(String userName) throws DaoException {
        List<User> usersByName;

        try(PreparedStatement statement = connection.prepareStatement(QUERIES.getString("user.select.by.email"))) {
            statement.setString(1, userName);
            ResultSet resultSet = statement.executeQuery();
            usersByName = handleResultSet(resultSet);
        } catch (SQLException | DaoException e) {
            log.error("Could not get user by login=" + userName, e);
            throw  new DaoException("Could not get user by login=" + userName, e);
        }

        if (usersByName.isEmpty()){
            return null;
        }

        return usersByName.get(0);
    }

    @Override
    public User findByEmail(String email) throws DaoException {
        List<User> usersByEmail;

        try(PreparedStatement statement = connection.prepareStatement(QUERIES.getString("user.select.by.email"))) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            usersByEmail = handleResultSet(resultSet);
        } catch (SQLException | DaoException e) {
            log.error("Could not get user by email=" + email, e);
            throw  new DaoException("Could not get user by email=" + email, e);
        }

        if (usersByEmail.isEmpty()){
            return null;
        }

        return usersByEmail.get(0);

    }

    @Override
    public List<User> findAll() throws DaoException {
        List<User> users;

        try(PreparedStatement statement = connection.prepareStatement(QUERIES.getString("user.select.all"))) {
            ResultSet resultSet = statement.executeQuery();
            users = handleResultSet(resultSet);
        } catch (SQLException | DaoException e) {
            log.error("Could not get the list of all users", e);
            throw  new DaoException("Could not get the list of all users", e);
        }

        return users;
    }

    @Override
    public User createUser(User user) throws DaoException {
        try(PreparedStatement statement = connection.prepareStatement(QUERIES.getString("user.create"), Statement.RETURN_GENERATED_KEYS)){
            statementForCreate(statement, user);

            statement.executeUpdate();

            int autoPK;

            ResultSet resultSet = statement.getGeneratedKeys();

            if (resultSet.next()) {
                autoPK = resultSet.getInt(1);
                user = findById(autoPK);
            } else {
                throw new DaoException();
            }

        } catch (SQLIntegrityConstraintViolationException e) {
            log.error("This email is already in use " + user, e);
            throw new EmailExistsException("This email is already in use " + user, e);
        } catch (SQLException | DaoException e) {
            log.error("Could not create user " + user, e);
            throw new DaoException("Could not create user " + user, e);
        }

        return user;
    }

    private void statementForCreate(PreparedStatement statement, User user) throws DaoException {
        try{
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setBoolean(4, user.getIsAdmin());
        } catch (SQLException e) {
            log.error("Could not set prepared statement", e);
            throw new DaoException("Could not set prepared statement", e);
        }
    }

    @Override
    public User updateUser(User user) throws DaoException {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean deleteUser(User user) throws DaoException {
        throw new UnsupportedOperationException();
    }
    private List<User> handleResultSet(ResultSet resultSet) throws DaoException {
        List<User> users = new ArrayList<>();

        try {
            while (resultSet.next()){
                User user = new User.Builder()
                        .setUserId(resultSet.getInt(USER_ID))
                        .setUserName(resultSet.getString(USER_NAME))
                        .setEmail(resultSet.getString(USER_EMAIL))
                        .setPassword(resultSet.getString(USER_PASSWORD))
                        .setIsAdmin(resultSet.getBoolean(USER_ROLE))
                        .build();

                users.add(user);
            }
        } catch (SQLException e) {
            log.error("Could not read result set", e);
            throw new DaoException("Could not read result set", e);
        }

        return users;
    }
}

