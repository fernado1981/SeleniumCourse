package factory;

import clase2.FacebookTest;
import org.testng.annotations.Factory;

public class FactoryTest2 {

    @Factory
    public Object[] factoryTest2(){
        return new Object[]{
                new FacebookTest(),
        };
    }
}