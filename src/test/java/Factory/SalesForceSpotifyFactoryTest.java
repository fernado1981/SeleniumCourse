package Factory;

import test.SalesForceTest.SalesForceTest;
import test.SpotifyTest.SpotifyTest;
import org.testng.annotations.Factory;

public class SalesForceSpotifyFactoryTest {

    @Factory
    public Object[] factoryTest3(){
        return new Object[]{
                new SalesForceTest(),
                new SpotifyTest(),
        };
    }
}