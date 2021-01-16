package factory;

import clase3.TestSalesForce;
import clase3.TestSpotify;
import org.testng.annotations.Factory;

public class FactoryTest3 {

    @Factory
    public Object[] factoryTest3(){
        return new Object[]{
                new TestSalesForce(),
                new TestSpotify(),
        };
    }
}