package com.example.testapp_applab.model;


public class UserPrefs {
    private String userID;
    private User user;

    public UserPrefs(String userID, String email, String password) {
        this.userID = userID;
        this.user = new User("", email, password, "");
    }

    public String getUserID(){
        return userID;
    }

    public String getEmail(){
        return user.getEmail();
    }

    public String getPassword(){
        return user.getUserPassword();
    }
}
