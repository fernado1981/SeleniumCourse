package Factory;


import org.testng.annotations.Factory;
import test.ExamTest.Netflix;

public class NetflixFactoryTest {

    @Factory
    public Object[] factoryTest2(){
        return new Object[]{
                new Netflix(),
                new Netflix(),
        };
    }
}