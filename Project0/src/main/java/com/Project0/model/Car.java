package com.Project0.model;

public class Car {

    private String carName;
    private int carId;

    public Car(int carId, String carName) {
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

    @Override
    public String toString() {
        return "Car{" +
                "carName='" + carName + '\'' +
                ", carId=" + carId +
                '}';
    }
}
