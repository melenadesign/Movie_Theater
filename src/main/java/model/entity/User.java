package model.entity;

import java.util.Date;

public class User {
    private int userId;
    private String password;
    private String email;
//    private String phone;
    private String userName;
    private boolean isAdmin;
//    private ROLE role;
//    public User() {
//
//    }
//    public User(int userId, String password, String email, String phone, String userName, Boolean isAdmin) {
//        this.userId = userId;
//        this.password = password;
//        this.email = email;
//        this.phone = phone;
//        this.userName = userName;
//        this.isAdmin = isAdmin;
////        this.role = role;
//    }
    //todo hashCodem equals override
//    public enum ROLE {
//        USER, ADMIN, GUEST
//    }




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

//    public String getPhone() {
//        return phone;
//    }
//
//    public void setPhone(String phone) {
//        this.phone = phone;
//    }

    public String getUsername() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean getIsAdmin() { return isAdmin; }

    public void setIsAdmin(boolean isAdmin) { this.isAdmin = isAdmin; }

//    public ROLE getRole(ROLE role ) {
//        return role;
//    }
//    public void setRole(ROLE role ) {
//        this.role = role;
//    }

    public static class Builder{

        private User user;

        public Builder(){
            user = new User();
        }

        public Builder setUserId(int userId){
            user.setUserId(userId);
            return this;
        }

        public Builder setUserName(String name){
            user.setUserName(name);
            return this;
        }

        public Builder setEmail(String email){
            user.setEmail(email);
            return this;
        }

//        public Builder setPhone(String phone){
//            user.setPhone(phone);
//            return this;
//        }

        public Builder setPassword(String password){
            user.setPassword(password);
            return this;
        }

        public Builder setIsAdmin(Boolean isAdmin){
            user.setIsAdmin(isAdmin);
            return this;
        }

        public User build(){
            return user;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + userId +
                ", name='" + userName + '\'' +
                ", email='" + email + '\'' +
//                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", is admin=" + isAdmin +
                '}';
    }

    @Override
    public Object clone(){
        return new Builder()
                .setUserId(userId)
                .setUserName(userName)
                .setEmail(email)
//                .setPhone(phone)
                .setPassword(password)
                .setIsAdmin(isAdmin)
                .build();
    }

}
