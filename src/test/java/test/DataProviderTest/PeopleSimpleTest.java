package test.DataProviderTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PeopleSimpleTest {

    @DataProvider(name="personas")
    public Object[][] Personas(){
        return new Object[][]{
                {"Fernando",new Integer(39)},
                {"Diego", new Integer(28)},
        };
    }

    @Test(dataProvider = "personas")
    public void nombresEdad(String nombre,int edad){
        System.out.println(nombre+ " "+edad);

    }

}
