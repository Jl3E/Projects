package com.Project0.ui;

import com.Project0.db.JDBCFactory;
import com.Project0.model.UserType;
import com.Project0.service.UserService;
import com.Project0.model.User;

import java.util.Scanner;

public class LoginMenu {
    public void showMenu(Scanner scan){

        System.out.println("username: ");
        String username = scan.nextLine();
        System.out.println("password: ");
        String password = scan.nextLine();
        User u = new UserService(JDBCFactory.daoFactory(User.class)).findCustomerByUsername(username);
        if (u == null || !u.getPassword().equals(password)) {
            System.out.println("login failed");
        } else if(u.getUserType().equals(UserType.EMPLOYEE)){
            System.out.println("Welcome to the Dealership employee staff.");
            EmployeeCarMenu mm = new EmployeeCarMenu();// this will be replaced with EmployeeCarMenu
            mm.showMenu(scan);
        } else{
            System.out.println("congratulations, search the numbers models of cars in stock!");
            CustomerCarMenu mm = new CustomerCarMenu(u);
            mm.showMenu(scan);
        }

    }
}
