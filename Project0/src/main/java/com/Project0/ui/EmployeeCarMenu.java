package com.Project0.ui;

import com.Project0.db.JDBCFactory;
import com.Project0.model.Car;
import com.Project0.model.User;
import com.Project0.service.CarService;
import com.Project0.service.UserService;

import java.util.Scanner;

public class EmployeeCarMenu {

    public void showMenu(Scanner scan){

        CarService cs = new CarService(JDBCFactory.daoFactory(Car.class));

        System.out.println("Add a car to the lot? y/n");
        String ans = scan.nextLine();
        switch(ans){
            case "y":
                System.out.println("Enter the name of the car.");
                String carName = scan.nextLine();
                cs.addCar(carName);
                showMenu(scan);
                break;
            case "n":
                break;

            default:
                System.out.println("You entered incorrectly.");
                showMenu(scan);
        }

    }
}
