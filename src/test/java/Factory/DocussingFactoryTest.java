package Factory;

import test.DocussignTest.DocusignTest;
import org.testng.annotations.Factory;

public class DocussingFactoryTest {

    @Factory
    public Object[] factoryTest4(){
        return new Object[]{
                new DocusignTest(),
        };
    }
}