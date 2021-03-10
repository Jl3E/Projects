package com.Project0.ui;

import com.Project0.db.JDBCFactory;
import com.Project0.db.OfferJDBC;
import com.Project0.model.Car;
import com.Project0.model.User;
import com.Project0.service.CarService;
import com.enterprise.annotations.TestClass;

import java.util.Scanner;

public class CustomerCarMenu {

    private User u;

    public void showMenu(Scanner scan) {

        OfferJDBC oj = new OfferJDBC();
        CarService cs = new CarService(JDBCFactory.daoFactory(Car.class));
        CustomerOfferMenu om = new CustomerOfferMenu(u);
        System.out.println("1. Search for a car\n2. View your car(s)\n3. View remains payments on a car\n4. Exit");
        switch (scan.nextLine()){
            case "1":
                cs.showCar();
                System.out.println("hit enter to continue");
                String go = scan.nextLine();
                om.showMenu(scan, cs);
                System.out.println("You have been logged out.");
                break;
            case "2":
                cs.showCarsOwned(u);
                showMenu(scan);
                break;
            case "3":
                System.out.println("Enter carname from your owned car(s)");
                String carname = scan.nextLine();
                float payments = oj.getUserAcceptedOffers(u,carname);
                System.out.println("You have "+payments+" payments left");
                showMenu(scan);
                break;
            case "4":
                System.out.println("Logged out.\n");
                return;
            default:
                showMenu(scan);
                return;
        }

    }

    public CustomerCarMenu(User u) {
        this.u = u;
    }
}