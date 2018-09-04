package model.service;


import model.entity.User;



public interface UserService {
    /**
     * Return user if exist
     * and correct email/password,
     * null otherwise
     * @param email user email
     * @param password user password
     * @return user
     * @throws ServiceException
     */
    User login(String email, String password) throws ServiceException;

    /**
     * Validate and create user
     * @param name user name
     * @param email user email
     * @param password user password
     * @return created user
     * @throws ServiceException
     */
    User addNewUser(String name, String email, String password) throws ServiceException;
}
