package com.Project0.ui;

import com.Project0.db.JDBCFactory;
import com.Project0.db.OfferJDBC;
import com.Project0.model.Car;
import com.Project0.model.User;
import com.Project0.service.CarService;
import com.Project0.service.UserService;

import java.util.Scanner;

public class EmployeeCarMenu {

    public void showMenu(Scanner scan){

        CarService cs = new CarService(JDBCFactory.daoFactory(Car.class));
        UserService us = new UserService(JDBCFactory.daoFactory(User.class));
        OfferJDBC od = new OfferJDBC();

        System.out.println("1. Add a car\n2. Remove a car\n3. Submit an offer\n4. Decline an offer\n5. View all offers\n6. Get all payments\n7. Exit");
        String ans = scan.nextLine();

        switch(ans){
            case "1":
                System.out.println("Enter the name of the car.");
                String carName = scan.nextLine();
                while(carName.length() == 0 || cs.doesCarNameExist(carName)){
                    System.out.println("Entry can't be empty, or a previous car.");
                    System.out.println("Enter the name of the car.");
                    carName = scan.nextLine();
                }
                cs.addCar(carName);
                showMenu(scan);
                break;
            case "2":
                cs.showCar();
                try{
                    System.out.println("Enter car id");
                    String idCar = scan.nextLine();
                    int intIdCar = Integer.parseInt(idCar);
                    cs.removeCar(intIdCar);
                }catch (NumberFormatException ex) {
                    System.out.println("You have to enter an integer.");
                }
                showMenu(scan);
                break;
            case "3":
                System.out.println("Enter the car name.");
                String carName2 = scan.nextLine();
                while(!cs.doesCarNameExist(carName2)){
                    System.out.println("That car is not on the list.");
                    System.out.println("Enter the car name.");
                    carName2 = scan.nextLine();
                }
                System.out.println("Enter username");
                String customerName = scan.nextLine();
                while(!us.doesCustomerUsernameExist(customerName)){
                    System.out.println("That name is not on the list.");
                    System.out.println("Enter username");
                    customerName = scan.nextLine();
                }
                try {
                    System.out.println("Enter offer id.");
                    String id = scan.nextLine();
                    od.submitOffer(Integer.valueOf(id), carName2,customerName);
                }catch (NumberFormatException ex) {
                    System.out.println("You have to enter an integer.");
                }
                showMenu(scan);
                break;
            case "4":
                System.out.println("Enter username");
                String name = scan.nextLine();
                while(!us.doesCustomerUsernameExist(name)){
                    System.out.println("That name is not on the list.");
                    System.out.println("Enter username");
                    name = scan.nextLine();
                }
                try {
                    System.out.println("Enter offer id");
                    String offerId = scan.nextLine();
                    od.declineOffer(name, Integer.valueOf(offerId));
                }catch (NumberFormatException ex) {
                    System.out.println("You have to enter an integer.");
                }
                showMenu(scan);
                break;

            case "5":
                System.out.println("Offer Id\tUsername\t\t\tPrice\t\t\tCar Name\n");
                od.getAllOffers();
                showMenu(scan);
                break;

            case "6":
                System.out.println("Username\t\tPayment Due\t\tCar Name\n");
                od.getAllUsersAcceptedOffers();
                showMenu(scan);
                break;
            case "7":
                System.out.println("Logged out.");
                break;

            default:
                System.out.println("You entered incorrectly.");
                showMenu(scan);
        }

    }
}
