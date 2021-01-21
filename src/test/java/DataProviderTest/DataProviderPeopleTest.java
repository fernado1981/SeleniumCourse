package DataProviderTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPeopleTest {

    @DataProvider(name="people")
    public Object[][] DataPersonas(){
        return new Object[][]{
                {"Fernando","Manriqe",new Integer(39)},
                {"Diego","Manrique", new Integer(28)},
        };
    }

    @Test(dataProvider = "people")
    public void nombresEdad(String nombre,String apellido, int edad){
        System.out.println(nombre+ " "+apellido+" "+edad);
    }
}
