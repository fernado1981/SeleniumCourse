package Factory;

import org.testng.annotations.Factory;
import test.SpotifyTest.SpotifyTest;

public class SpotifyFactoryTest {

        @Factory
        public Object[] factoryTest3(){
            return new Object[]{
                    new SpotifyTest(),
            };
        }
    }
