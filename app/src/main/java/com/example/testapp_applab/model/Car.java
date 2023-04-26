package com.example.testapp_applab.model;

public class Car {
    private String make;
    private int year;

    public Car() {
    }

    public Car(String carName, int carYear) {
    }

    public void setCar_name(String car_name, int car_year) {
        this.make = car_name;
        this.year = car_year;
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

    @Override
    public String toString(){
        return "Car(" +
                "year: " + year +
                ", make= '" + make + '\'' +
                '}';
    }
}
