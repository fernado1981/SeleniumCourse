package clase14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderEjemplo1 {


    WebDriver driver;
    @Test(dataProvider = "datos", dataProviderClass = DataProviderGenerator.class)
    public void testPersonas(String nombre, int edad){
        System.out.println("Nombre: " + nombre + " edad: " + edad);
    }

    @Test(dataProvider = "datosPersonales", dataProviderClass = DataProviderGenerator.class)
    public void registro(String nombre, String apellido, int edad, String ciudad, String pais, String email, Boolean validInfo){

        if (validInfo == true){
            System.out.print("La informacion es valida!!!  ");
            System.out.println("Nombre" + nombre + " "+ apellido + ". Edad:  " + edad + ". Email " + email);
        } else {
            System.out.print("La informacion es INVALIDA!!!!!  ");
            System.out.println("Nombre" + nombre + " "+ apellido + ". Edad:  " + edad + ". Email " + email);

        }
    }
}
