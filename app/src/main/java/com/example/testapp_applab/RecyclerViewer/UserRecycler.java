package com.example.testapp_applab.RecyclerViewer;

public class UserRecycler {
    private String userName;
    private String email;
    private String age;

    public UserRecycler() {
    }

    public UserRecycler(String userName, String email, String age) {
        this.userName = userName;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getAge() {
        return age;
    }
}
