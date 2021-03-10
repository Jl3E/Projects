package com.Project0;

import com.Project0.db.JDBCFactory;
import com.Project0.model.User;
import com.Project0.service.CarService;
import com.Project0.ui.CustomerSignUpMenu;
import com.Project0.ui.LoginMenu;
import com.Project0.ui.EmployeeSignUpMenu;
import com.Project0.service.UserService;

import java.util.Scanner;

public class Driver {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        EmployeeSignUpMenu ll = new EmployeeSignUpMenu();
        CustomerSignUpMenu mm = new CustomerSignUpMenu();//currently used to create customers
        LoginMenu lm = new LoginMenu();//menu for customer to see

        boolean continueLoop = true;
        String ans = "";
        do {
            System.out.println("1)sign up, 2)login or 3)exit?");
            String answer = scan.nextLine();
            switch(answer){
                case "1":
                    System.out.println("1)To create customer login\n2)To create employee login");
                    ans = scan.nextLine();
                    if(ans.equals("1")) {
                        mm.showMenu(scan);
                    }
                    else if(ans.equals("2")){
                        ll.showMenu(scan);
                    }
                    break;
                case "2":
                    lm.showMenu(scan);
                    break;
                case "3":
                    continueLoop = false;
                    break;
                default:
                    System.out.println("Please enter 1, 2, or 3.");
                    break;
            }
        } while(continueLoop);
    }
}
