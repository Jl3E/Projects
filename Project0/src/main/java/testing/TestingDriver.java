package testing;

import com.enterprise.EnterpriseNoAppropriateConstructorFoundException;
import com.enterprise.util.HashMap;
import com.enterprise.util.TestDiscovery;

public class TestingDriver {

    public static void main(String[] args) throws EnterpriseNoAppropriateConstructorFoundException {
        HashMap resultmap = null;

        try {
            resultmap = (new TestDiscovery()).runAndStoreTestInformation();
        } catch (Exception var3) {
            var3.printStackTrace();
        }
        TestClass1 tc1 = new TestClass1();


        System.out.println(resultmap);
    }
}
