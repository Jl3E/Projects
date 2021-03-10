package com.Project0.ui;

import com.Project0.db.JDBCFactory;
import com.Project0.model.User;
import com.Project0.service.UserService;

import java.util.Scanner;

public class CustomerSignUpMenu {

    public void showMenu(Scanner scan){

        UserService us = new UserService(JDBCFactory.daoFactory(User.class));
        System.out.println("====Welcome to the Dealership====");
        String username = "";
        do{
            System.out.println("provide username");
            username = scan.nextLine();
            if(us.doesCustomerUsernameExist(username)){
                System.out.println("Customer already exists.");
            }
        } while(us.doesCustomerUsernameExist(username));
        System.out.println("provide password");
        String password = scan.nextLine();
        System.out.println("provide email");
        String email = scan.nextLine();
        System.out.println(us.makeCustomer(username, password, email) ?
                "successfully made "+username :
                "cancelled registration");
    }

}
