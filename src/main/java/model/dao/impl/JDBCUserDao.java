package model.dao.impl;

import ua.training.model.dao.StudentDao;
import ua.training.model.dao.mapper.StudentMapper;
import ua.training.model.dao.mapper.TeacherMapper;
import ua.training.model.entity.Student;
import ua.training.model.entity.Teacher;

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
    public User createUser(User entity) {

    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        Map<Integer, User> users = new HashMap<>();


        final String query = "select * from user";
        try (Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery(query);

            UserMapper userMapper = new userMapper();
            while (rs.next()) {
                User user = userMapper
                        .extractFromResultSet(rs);
                user = userMapper
                        .makeUnique(users, user);
                user.findAll().add(user);
            }
            return new ArrayList<>(students.values());
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }



    @Override
    public void updateUser(User entity) {

    }

    @Override
    public void deleteUser(int id) {

    }

    @Override
    public void close()  {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
