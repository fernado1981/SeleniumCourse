package Factory;

import Facebook.FacebookTest;
import org.testng.annotations.Factory;

public class FacebookFactoryTest {

    @Factory
    public Object[] factoryTest2(){
        return new Object[]{
                new Facebook.FacebookTest(),
        };
    }
}