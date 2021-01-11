package clase2;

import org.testng.annotations.Factory;

public class FactoryTest2 {

    @Factory
    public Object[] factoryTest1(){
        return new Object[]{
                new SegundoTest(),
        };
    }
}