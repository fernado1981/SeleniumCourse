package factory;

import dropdow_link_radio.DropDownLinkRadioTest;
import org.testng.annotations.Factory;

public class FactoryTestDropDownLinkRadio {

    @Factory
    public Object[] factoryTest4(){
        return new Object[]{
                new DropDownLinkRadioTest(),
        };
    }
}