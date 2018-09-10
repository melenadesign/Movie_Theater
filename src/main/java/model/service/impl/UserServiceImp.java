package model.service.impl;

import model.dao.*;
import model.dao.impl.ConnectionPool;
import model.dao.impl.JDBCDaoFactory;
import model.entity.User;
import model.service.ServiceException;
import model.service.UserService;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserServiceImp implements UserService {
    private static Logger log = Logger.getLogger(UserServiceImp.class);

    private static final String NAME_REGEX = "[0-9a-zA-Z]{4,16}";

    private static final String EMAIL_REGEX = "^[_A-Za-z0-9-]*@[A-Za-z0-9-]+([A-Za-z0-9]+)*([A-Za-z]{2,})$";
    private static final String PASS_REGEX = "[0-9a-zA-Z]{4,16}";
    User user;
    DaoFactory factory = DaoFactory.getInstance();
    @Override
    public User login(String name, String password) throws ServiceException {

        try (Connection connection = ConnectionPool.getInstance().getConnection()){

            UserDao userDao = factory.createUserDao();
            user = userDao.findByName(name);
        } catch (DaoException | SQLException e) {
            log.error("Could not find user by name=" + name, e);
            throw new ServiceException("Could not find user by name=" + name, e);
        }

        return user == null ? null : user.getPassword().equals(password) ? user : null;
    }

    @Override
    public User addNewUser(String name, String email, String password) throws ServiceException {
        if (!isUserValid(name, email, password)){
            throw new ServiceException("Input data validation failed due to regex pattern ");
        }

        try (Connection connection = ConnectionPool.getInstance().getConnection()){
            UserDao userDao = factory.createUserDao();

            return userDao.createUser(buildUser(name, email, password));
        } catch (NameExistsException e){
            throw new ServiceException("You are trying to add user with email that already exists" + email, e);
        } catch (DaoException | SQLException e) {
            log.error("Could not create new user", e);
            throw new ServiceException("Could not create new user", e);
        }
    }


    private boolean isUserValid(String name, String email, String password){
        return (Pattern.matches(NAME_REGEX, name)
                && Pattern.matches(EMAIL_REGEX, email)
                && Pattern.matches(PASS_REGEX, password));
    }


    private User buildUser(String name, String email, String password) {

        return new User.Builder()
                .setUserName(name)
                .setEmail(email)
                .setPassword(password)
                .setIsAdmin(false)
                .build();

    }
}
