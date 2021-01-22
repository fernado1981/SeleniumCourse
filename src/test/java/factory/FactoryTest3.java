package factory;

import clase3.SalesForceTest;
import clase3.SpotifyTest;
import org.testng.annotations.Factory;

public class FactoryTest3 {

    @Factory
    public Object[] factoryTest3(){
        return new Object[]{
                new SalesForceTest(),
                new SpotifyTest(),
        };
    }
}