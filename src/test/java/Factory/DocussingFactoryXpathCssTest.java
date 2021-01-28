package Factory;

import Docussign_Xpath_Css.DocusignTest;
import org.testng.annotations.Factory;

public class DocussingFactoryXpathCssTest {

    @Factory
    public Object[] factoryTest4(){
        return new Object[]{
                new DocusignTest(),
        };
    }
}