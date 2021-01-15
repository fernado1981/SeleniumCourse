package Xpath_Css;

import WebObject.SpotifyFormulario;
import hook.ComplementDriver;
import hook.Utilities;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class LocalizadoresXpathCssTest {

    WebDriver driver;
    ComplementDriver test = new ComplementDriver();

    @Before
    public WebDriver getDriver(String URL){
        driver = test.Driver(URL, "chrome");
        return driver;
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void completeDocusignRegistrationForm(){
        driver = getDriver("https://go.docusign.com/o/trial/");
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//button[@class='optanon-allow-all accept-cookies-button']");

        //formulario
        util.send_keys_xpath("//input[@name='first_name']", "pepe");
        util.send_keys_xpath("//input[@name='last_name']", "pepe");
        util.send_keys_xpath("//input[@name='email']", "pepe@pepe.com");
        util.send_keys_xpath("//input[@name='phone']", "654897237");
        util.send_keys_xpath("//input[@name='title']", "fontanero");
        util.send_keys_xpath("//select[@name='ds_industry']", "//option[@value='Other']");

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void defaultxPath(){
        driver = getDriver("https://go.docusign.com/o/trial/");
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//button[@class='optanon-allow-all accept-cookies-button']");

        //formulario
        util.send_keys_xpath("//*[@id='dsFormLabel_First_Name']/input","pepe");
        util.send_keys_xpath("//*[@id='dsFormLabel_First_Name']/input","pepe");
        util.send_keys_xpath("//*[@id='dsFormLabel_Email']/input","pepe@pepe.com");
        util.send_keys_xpath("//*[@id='dsFormLabel_Phone']/input","654897237");
        util.send_keys_xpath("//*[@id='dsFormLabel_Job_Title']/input","fontanero");
        util.click_element_xpath("//*[@id='dsFormLabel_Industry']/select/option[21]");

    }

    @Test(priority = 2,groups = {"failTests"})
    public void spotifyByNameTest(){
        driver = getDriver("https://www.spotify.com/uy/signup/");
        SpotifyFormulario reg = new SpotifyFormulario(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//*[contains(text(),'Aceptar Cookies')]");

        //formulario
        util.send_keys_name("email","pepe@pepe.com");
        util.send_keys_name("confirm","pepe@pepe.com");
        util.send_keys_name("password", "pepito");
        util.send_keys_name("displayname","pepin");

        //formulario SpotifyFormulario
        reg.select_item_value_day("css_selector","input[id='day']","31");
        reg.select_item_value_month("css_selector","select[id='month']","Febrero");
        reg.select_item_value_year("css_selector","input[id='year']","1981");

        //radio and check de formulario
        util.click_element_xpath("//*[contains(text(),'Hombre')]");

        util.click_element_xpath("//*[contains(text(),'Compartir mis datos de')]");

    }

    @Test(priority = 3,groups = {"failTests"})
    public void spotifyByPlaceHolder(){
        driver = getDriver("https://www.spotify.com/uy/signup/");
        SpotifyFormulario reg = new SpotifyFormulario(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//*[contains(text(),'Aceptar Cookies')]");

        //formulario
        util.send_keys_xpath("//input[@placeholder='Introduce tu correo electrónico.']", "pepe@pepe.com");
        util.send_keys_xpath("//input[@placeholder='Vuelve a introducir tu correo electrónico.']","pepe@pepe.com");
        util.send_keys_xpath("//input[@placeholder='Crea una contraseña.']","pepito");
        util.send_keys_xpath("//input[@placeholder='Introduce un nombre de perfil.']", "pepin");

        //formulario SpotifyFormulario
        reg.select_item_value_day("css_selector","input[id='day']","31");
        reg.select_item_value_year("css_selector","input[id='year']","1981");

        //radio and check de formulario
        util.click_element_xpath("//*[contains(text(),'Hombre')]");

    }

    @Test(priority = 4,groups = {"failTests"})
    public void spotifyByName(){
        driver = getDriver("https://www.spotify.com/uy/signup/");
        SpotifyFormulario reg =new SpotifyFormulario(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//*[contains(text(),'Aceptar Cookies')]");

        //formulario
        util.send_keys_css_selector("input[id='email']", "pepe@pepe.com");
        util.send_keys_css_selector("input[id='confirm']", "pepe@pepe.com");
        util.send_keys_css_selector("input[id='password']", "pepito");
        util.send_keys_css_selector("input[id='displayname']", "pepin");

        //formulario SpotifyFormulario
        reg.select_item_value_day("css_selector","input[id='day']","31");
        reg.select_item_value_month("css_selector","select[id='month']","Febrero");
        reg.select_item_value_year("css_selector","input[id='year']","1981");

        //radio and check de formulario
        util.click_element_xpath("//*[contains(text(),'Hombre')]");

        util.click_element_xpath("//*[contains(text(),'Compartir mis datos de')]");


    }

    @AfterMethod
    public void cerrarDriver(){
        test.driver_close(driver);
    }
}
