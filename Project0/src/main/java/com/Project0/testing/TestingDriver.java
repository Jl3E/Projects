package com.Project0.testing;

import com.Project0.model.User;
import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.enterprise.util.HashMap;
import com.enterprise.util.TestDiscovery;
import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;

public class TestingDriver {

    public static void main(String[] args) throws EnterpriseNoAppropriateConstructorFoundException {
        HashMap resultmap = null;

        try {
            resultmap = (new TestDiscovery()).runAndStoreTestInformation();
        } catch (Exception var3) {
            var3.printStackTrace();
        }

        System.out.println(resultmap);
    }
}
