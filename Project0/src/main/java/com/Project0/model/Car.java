package com.Project0.model;

public class Car {//TODO: DELETE THIS CLASS IF YOU DON'T IMPLEMENT IT WITH THE JDCBFACTORY

    private String carName;
    private int carId;

    public Car(String carName, int carId) {
        this.carName = carName;
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId++;
    }
}