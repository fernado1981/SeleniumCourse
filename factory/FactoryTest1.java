package factory;

import clase1.PrimerTest;
import org.testng.annotations.Factory;

public class FactoryTest1 {

    @Factory
    public Object[] factoryTest1(){
        return new Object[]{
                new PrimerTest(),
        };
    }
}
