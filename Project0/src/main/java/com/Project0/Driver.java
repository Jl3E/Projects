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
        //TODO: fix EmployeeLoginMenu to be an option took it out with the login options, i dont need to set the
        // usertype from the login menu because I won't have that information before they type info in.
        // so login goes to a specific menu depending on the values from login

        boolean continueLoop = true;
        String ans = "";
        do {
            System.out.println("sign up, login or exit?");
            String answer = scan.nextLine();
            if(answer.equalsIgnoreCase("exit")){
                continueLoop = false;
            } else if(answer.equalsIgnoreCase("sign up")) {
                System.out.println("To create customer login enter 1, to create employee login enter 2.");
                ans = scan.nextLine();
                if(ans.equals("1")) {
                    mm.showMenu(scan);
                }
                else if(ans.equals("2")){
                    ll.showMenu(scan);
                }
                //TODO: get rid of ans method and the enter 1 or 2 needs to be remade
            } else if(answer.equalsIgnoreCase("login" )) {
                lm.showMenu(scan);
            }
        } while(continueLoop);
    }
}
