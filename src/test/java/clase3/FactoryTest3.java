package clase3;


import org.testng.annotations.Factory;

public class FactoryTest3 {

    @Factory
    public Object[] factoryTest3(){
        return new Object[]{
                new testSalesforce(),
                new testngSpotify(),
        };
    }
}