package com.example.testapp_applab.model;

public class Employee {
    private String firstName;
    private int age;
    private String mail;

    public Employee(String firstName, int age, String mail) {
        this.firstName = firstName;
        this.age = age;
        this.mail = mail;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }
}
