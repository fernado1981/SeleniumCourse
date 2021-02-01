package Factory;


import test.FacebookTest.FacebookLoginTest;
import org.testng.annotations.Factory;
import test.FacebookTest.FacebookRegisterTest;

public class FacebookFactoryTest {

    @Factory
    public Object[] factoryTest2(){
        return new Object[]{
                new FacebookLoginTest(),
                new FacebookRegisterTest(),
        };
    }
}