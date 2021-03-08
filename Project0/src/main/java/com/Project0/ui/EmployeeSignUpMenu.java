package com.Project0.ui;

import com.Project0.db.JDBCFactory;
import com.Project0.model.User;
import com.Project0.service.UserService;

import java.util.Scanner;

public class EmployeeSignUpMenu {

    public void showMenu(Scanner scan){

        UserService us = new UserService(JDBCFactory.daoFactory(User.class));
        System.out.println("====Welcome the Dealership Employee Login====");
        String username = "";
        // hey something is wrong
        do{
            System.out.println("provide username");
            username = scan.nextLine();
//            //Should I not have this to prevent to much information to be displayed? then whats the point of asking for a username again?
//            if(us.doesEmployeeUsernameExist(username)){
//                System.out.println("User already exists.");
//            }
        } while(us.doesCustomerUsernameExist(username));
        System.out.println("provide password");
        // TODO: check phone number
        String password = scan.nextLine();
        System.out.println("provide email");
        String email = scan.nextLine();
        System.out.println(us.makeEmployee(username, password, email) ?
                "successfully made "+username :
                "cancelled registration");
    }
}
