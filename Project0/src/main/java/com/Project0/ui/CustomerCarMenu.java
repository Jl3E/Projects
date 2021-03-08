package com.Project0.ui;

import com.Project0.db.JDBCFactory;
import com.Project0.model.Car;
import com.Project0.model.User;
import com.Project0.service.CarService;

import java.util.Scanner;

public class CustomerCarMenu {

    private User u;


    public void showMenu(Scanner scan) {

        CarService cs = new CarService(JDBCFactory.daoFactory(Car.class));
        CustomerOfferMenu om = new CustomerOfferMenu(u);
        System.out.println("1. Search for a car");
        System.out.println("2. exit");
        switch (scan.nextLine()){
            case "1":
                //TODO: get rid of these .addcars's after its connected to db
                cs.addCar("honda");
                cs.addCar("toyota");// if this showMenu is shown in console more than once it will fill the carlist menu.... should put in main method for testing
                cs.addCar("ford");
                om.showMenu(scan, cs);
                System.out.println("You have been logged out.");
                break;
            case "2":
                System.out.println("You have been logged out.");
                break;
            default:
                showMenu(scan);
                return;
        }

    }

    public CustomerCarMenu(User u) {
        this.u = u;
    }
}