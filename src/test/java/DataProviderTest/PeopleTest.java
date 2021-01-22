package DataProviderTest;

import org.testng.annotations.Test;

public class PeopleTest {

    @Test(dataProvider = "people", dataProviderClass = DataProviderPeopleTest.class)
    public void nombresEdad(String nombre,String apellido, int edad){
        System.out.println(nombre+ " "+apellido+" "+edad);
    }
}
