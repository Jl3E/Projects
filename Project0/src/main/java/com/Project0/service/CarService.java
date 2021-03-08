package com.Project0.service;

import com.Project0.db.GenericDao;
import com.Project0.model.User;

public class CarService {

    private String[] carArray = new String[5];
    private String[][] carOffersArray = new String[5][10]; //the first dimension should be the car name in a column, and each row offers for said cars.
    private static int currentIndex = 0;
    private static int currentCarIndex = -1;
    GenericDao<String, Integer> si;
    private User u;

    public CarService(){};
    public CarService(User u) {
        this.u = u;
    }
    public CarService(GenericDao<String, Integer> si) {
        this.si = si;
    }

    public boolean doesCarNameExist(String carName){

//        if(si.getById(carName) != null){
//            //User u = si.getById(username);
//            return true;
//        }

        for (int i=0; i < carArray.length; i++){
            if(carArray[i].equals(carName)){
                return true;
            }
        }
        return false;
    }

    public void addCar(String carName){
        si.save(carName);

        if(currentIndex < carArray.length){
            carArray[currentIndex]=carName;
            currentIndex++;

        }else{
            System.out.println("error out of room.");// could made a bubble sort to make a new array double the size
        }

    }

    public String removeCar(String carName){

        return "the car name after purchase";
    }

    public void carOffer(String carName, User u, String offer){
            if(currentCarIndex > -1) {
                for (int i = 0; i < currentIndex; i++) {
                    if (carArray[i].equals(carName)) {
                        carOffersArray[i][currentCarIndex] = offer+" "+ u.getUsername();
                        currentCarIndex++;
                    }
                }
            }

    }
    public void carAcceptance(){

    }

    public void showCar(){

        for(String str: carArray){
            if(str != null)
            System.out.println(str);

        }
    }

}
