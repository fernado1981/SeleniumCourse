package factory;

import Xpath_Css.LocalizadoresXpathCssTest;
import org.testng.annotations.Factory;

public class FactoryTestXpathCss {

    @Factory
    public Object[] factoryTest4(){
        return new Object[]{
                new LocalizadoresXpathCssTest(),
        };
    }
}