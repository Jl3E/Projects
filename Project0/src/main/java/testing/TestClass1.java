package testing;

import com.Project0.model.User;
import com.Project0.service.UserService;
import com.enterprise.annotations.TestClass;
import com.enterprise.annotations.TestMethod;

@TestClass
public class TestClass1 {

    public TestClass1(){}

    User u = new User();

    @TestMethod(expected = "joey")
    public String testGetUsername(){

        try{
            u.setUsername("joey");

            String test = u.getUsername();

            return test;
        } catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }



}

