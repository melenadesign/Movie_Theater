package model.dao;

import model.entity.User;

import java.util.List;

public interface UserDao {

    /**
     * Find user by id
     * @param id
     * @throws DaoException
     */
    User findById(int id) throws DaoException;

    /**
     * Find user by name
     * @param name
     * @throws DaoException
     */

    User findByName(String name) throws DaoException;
    /**
     * Find user by email
     * @param email
     * @return user, else null
     * @throws DaoException
     */
    User findByEmail(String email) throws DaoException;

    /**
     * Find all users
     * @return list of all users
     * @throws DaoException
     */
    List<User> findAll() throws DaoException;

    /**
     * Create new user
     * @param user
     * @return new user
     * @throws DaoException
     */
    User createUser(User user) throws DaoException;

    /**
     * Edit user
     * @param user
     * @return edited user
     * @throws DaoException
     */
    User updateUser(User user) throws DaoException;

    /**
     * Delete user
     * Returns true if user was deleted
     * @param user
     * @return is deleted
     * @throws DaoException
     */
    boolean deleteUser(User user) throws DaoException;


}
