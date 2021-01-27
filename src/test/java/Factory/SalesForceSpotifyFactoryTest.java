package Factory;

import SalesForce_Spotify.SalesForceTest;
import SalesForce_Spotify.SpotifyTest;
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