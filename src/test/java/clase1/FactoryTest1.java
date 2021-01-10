package clase1;

import org.testng.annotations.Factory;

public class FactoryTest1 {

    @Factory
    public Object[] factoryTest1(){
        return new Object[]{
                new PrimerTest(),
        };
    }
}
