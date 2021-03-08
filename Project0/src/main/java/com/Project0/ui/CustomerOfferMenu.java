package com.Project0.ui;

import com.Project0.model.User;
import com.Project0.service.CarService;

import java.util.Scanner;

public class CustomerOfferMenu {

    private User u;

    public void showMenu(Scanner scan, CarService cs){

        boolean go = true;
        int index = 0;
        cs.showCar();
        System.out.println("Welcome " + u.getUsername() + " would you like to submit an offer?y/n");
        do {
            if(index > 0) {
                cs.showCar();
                System.out.println("Would you like to submit another offer?y/n");
            }
            index++;
            String ans = scan.nextLine();
            if (ans.equals("y")) {
                System.out.println("Please enter a car from our list.");
                String carName = scan.nextLine();
                System.out.println("Please enter your offer.");
                String offer = scan.nextLine();
                new CarService(u).carOffer(carName, u, offer);
            } else if (ans.equals("n")) {
                go = false;
            }
        }while(go);

    }

    public CustomerOfferMenu(User u) {
        this.u = u;
    }
}
