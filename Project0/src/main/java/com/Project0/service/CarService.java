package com.Project0.service;

import com.Project0.db.CarsOwnedJDBC;
import com.Project0.db.GenericDao;
import com.Project0.db.OfferJDBC;
import com.Project0.model.User;

public class CarService {

//    private String[] carArray = new String[5];
//    private String[][] carOffersArray = new String[5][10];
    private static int currentIndex = 0;
    private static int currentCarIndex = -1;
    OfferJDBC oi = new OfferJDBC();
    CarsOwnedJDBC co = new CarsOwnedJDBC();
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
        return co.doesCarExist(carName);
    }

    public void addCar(String carName){
        si.save(carName);
    }

    public void showCarsOwned(User u){

        co.showOwnedCars(u.getUsername());
    }

    public void removeCar(int id){

        si.remove(id);
    }

    public void carOffer(String carName, User u, String offer){
            oi.saveOffer(u, offer, carName);
    }
    public void carAcceptance(){

    }

    public void showCar(){
        si.getAll();

    }

}
