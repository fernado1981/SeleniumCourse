package DataProviderTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SalesforceTest {

    @DataProvider(name="personas")
    public Object[][] crearPersonas(){
        return new Object[][]{
                {"Juan",new Integer(36)},
                {"María",new Integer(38)},
        };
    }


    @Test(dataProvider = "personas")
    public void nombresEdad(String nombre, int edad){
        System.out.println(nombre+ " "+edad);

    }


}
