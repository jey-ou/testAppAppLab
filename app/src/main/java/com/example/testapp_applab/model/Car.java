package com.example.testapp_applab.model;

import androidx.annotation.NonNull;

public class Car {
    private String make;
    private int year;

    public Car(String make, int year) {
        this.make = make;
        this.year = year;
    }

    public Car() {
    }

    public void setCar_name(String make, int year) {
        this.make = make;
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @NonNull
    @Override
    public String toString(){
        return "Car(" +
                "year: " + year +
                ", make= '" + make + '\'' +
                '}';
    }
}
