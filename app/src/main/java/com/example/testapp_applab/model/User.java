package com.example.testapp_applab.model;

public class User {

    private String userName;
    private String userPassword;
    private String phoneNo;
    private String email;

    private String authorisatie;

    public User(){

    }

    public User(String userName, String userPassword, String phoneNo, String email){

        this.userName = userName;
        this.userPassword = userPassword;
        this.phoneNo = phoneNo;
        this.email = email;
        this.authorisatie = "Geen";

    }

    public String getUserName() {
        return userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public String getAuthorisatie() {
        return authorisatie;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", authorisatie='" + authorisatie + '\'' +
                '}';
    }



}
