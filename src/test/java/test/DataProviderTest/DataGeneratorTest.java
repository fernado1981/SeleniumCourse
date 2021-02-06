package test.DataProviderTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataGeneratorTest {

    @DataProvider(name="paises")
    public Object[][] DataProviderEjemplo(){
        return new Object[][]{
                {"España","Madrid"},
                {"Francia","París"},
        };
    }

    @DataProvider(name="personas")
    public Object[][] DataPersonas(){
        return new Object[][]{
                {"Fernando","Manriqe",new Integer(39)},
                {"Diego","Manrique", new Integer(28)},
        };
    }

    @Test(dataProvider = "paises")
    public void nombrePaisCapital(String Pais, String Capital){
        System.out.println(Pais+ " "+Capital);

    }

    @Test(dataProvider = "personas")
    public void nombresEdad(String nombre, String apellido, int edad){
        System.out.println(nombre+ " "+apellido+" "+edad);

    }

}
