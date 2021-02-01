package Factory;

import test.SalesForceTest.SalesForceTest;
import org.testng.annotations.Factory;

public class SalesForceFactoryTest {

    @Factory
    public Object[] factoryTest3(){
        return new Object[]{
                new SalesForceTest(),
        };
    }
}