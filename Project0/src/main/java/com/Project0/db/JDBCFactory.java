package com.Project0.db;

import com.Project0.model.User;

/**
 * Factory design pattern.
 *      If you have common data types (similar inheritance trees),
 *          You can designate the parent as the return type and
 *          take parameters to determine which object should be
 *          returned to the caller.
 */
public class JDBCFactory {

    public static GenericDao daoFactory(Class c){
        switch (c.getName()){
            case "com.Project0.model.User":
                return UserJDBC.getInstance();
            case "com.Project0.model.Car":
                return CarJDBC.getInstance();
            default:
                throw new IllegalArgumentException("The class provided does not have a corresponding dao object");
        }
    }
}
