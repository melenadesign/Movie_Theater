package model.entity;

import java.util.Date;

public class User {
    private int userId;
    private String password;
    private String email;
    private String phone;
    private String userName;
    private boolean isAdmin;
    private ROLE role;

    public User(int userId, String password, String email, String phone, String userName, boolean isAdmin, ROLE role) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.userName = userName;
        this.isAdmin = isAdmin;
        this.role = role;
    }
    //todo builder may be, isAdmin to db/method impl
    public enum ROLE {
        USER, ADMIN, GUEST
    }




    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }


}
