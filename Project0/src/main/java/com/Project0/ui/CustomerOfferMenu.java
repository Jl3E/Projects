package com.Project0.ui;

import com.Project0.model.User;
import com.Project0.service.CarService;

import java.util.Scanner;

public class CustomerOfferMenu {

    private User u;
    private int index = 0;

    public void showMenu(Scanner scan, CarService cs){
        CustomerCarMenu ccm = new CustomerCarMenu(u);

        if (index > 0) {
            System.out.println("Welcome to the dealership" + u.getUsername() + "!");
            index++;
        }
        System.out.println("1. View cars on lot\n2. Submit an offer\n3. Previous Menu\n4. Exit");
        String ans = scan.nextLine();
        switch(ans){
            case "1":
                cs.showCar();
                System.out.println("hit enter to continue");
                String go = scan.nextLine();
                showMenu(scan, cs);
                break;
            case "2":
                System.out.println("Enter a car from our list.");
                String carName = scan.nextLine();
                while(!cs.doesCarNameExist(carName)){
                    System.out.println("Enter a car from our list.");
                    carName = scan.nextLine();
                }
                System.out.println("Enter your offer.");
                String offer = scan.nextLine();
                cs.carOffer(carName,u,offer);
                showMenu(scan, cs);
                break;
            case "3":
                ccm.showMenu(scan);
                break;
            case "4":
                return;
            default:
                System.out.println("Error, enter 1,2,3 or 4.");
                showMenu(scan, cs);
        }
    }

    public CustomerOfferMenu(User u) {
        this.u = u;
    }
}
