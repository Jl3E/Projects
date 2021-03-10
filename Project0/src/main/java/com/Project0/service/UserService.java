package com.Project0.service;

import com.Project0.model.User;
import com.Project0.db.GenericDao;
import com.Project0.model.UserType;
import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;

public class UserService {

    private static User[] employees = new User[5];
    private static User[] customers = new User[10];
    GenericDao<User, String> uj;

    private static int currentCustomerIndex = -1;
    private static int currentEmployeeIndex = -1;

    public UserService(){}
    public UserService(GenericDao<User, String> uj) {
        this.uj = uj;
    }

    public boolean doesCustomerUsernameExist(String username){
        return findCustomerByUsername(username) != null;
    }

    public User findCustomerByUsername(String username){
        if(uj.getById(username) != null){
            return uj.getById(username);
        }
        if(currentCustomerIndex > -1) {
            for (int i = 0; i <= currentCustomerIndex; i++) {
                if (customers[i].getUsername().equals(username)) {
                    return customers[i];
                }
            }
        }
        return null;
    }

    public boolean makeCustomer(String username, String password, String email){
        if(!doesCustomerUsernameExist(username)){
            if((currentCustomerIndex + 1) < employees.length){
                if(customers[currentCustomerIndex +1] == null){
                    customers[++currentCustomerIndex] = new User(username, password, email);
                    uj.save(new User(username, password, email, UserType.CUSTOMER));
                    return true;
                }
            }
        } else {
            System.out.println("Customer user already exists");
        }
        return false;
    }

    public boolean doesEmployeeUsernameExist(String username){
        return findEmployeeByUsername(username) != null;
    }

    public User findEmployeeByUsername(String username){
        if(currentEmployeeIndex > -1) {
            for (int i = 0; i <= currentEmployeeIndex; i++) {
                if (employees[i].getUsername().equals(username)) {
                    return employees[i];
                }
            }
        }
        return null;
    }

    public boolean makeEmployee(String username, String password, String email){
        if(!doesEmployeeUsernameExist(username)){
            if((currentEmployeeIndex + 1) < customers.length){
                if(employees[currentEmployeeIndex +1] == null){
                    employees[++currentEmployeeIndex] = new User(username, password, email);
                    uj.save(new User(username, password, email, UserType.EMPLOYEE));
                    return true;
                }
            }
        } else {
            System.out.println("Employee user already exists");
        }
        return false;
    }

}
