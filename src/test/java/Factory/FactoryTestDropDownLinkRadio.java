package Factory;

import Facebook_dropdow_link_radio.FacebookTest;
import org.testng.annotations.Factory;

public class FactoryTestDropDownLinkRadio {

    @Factory
    public Object[] factoryTest4(){
        return new Object[]{
                new FacebookTest(),
        };
    }
}