package com.example.testapp_applab.model;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CarList {

    private List<Car> carList = new ArrayList<Car>();

    public CarList() {
    }

    public CarList(ArrayList<Car> carList) {
        this.carList = carList;
    }

    public void add(Car car){
        carList.add(car);
    }

    public List<Car> getCarList(){
        return carList;
    }

    @NonNull
    @Override
    public String toString() {
        return "CarList{" +
                "carList=" + carList +
                '}';
    }

    public void setCarList(List<Car> carList){
        this.carList = carList;
    }
}
