package factory;

import clase3.TestSalesforce;
import clase3.TestngSpotify;
import org.testng.annotations.Factory;

public class FactoryTest3 {

    @Factory
    public Object[] factoryTest3(){
        return new Object[]{
                new TestSalesforce(),
                new TestngSpotify(),
        };
    }
}