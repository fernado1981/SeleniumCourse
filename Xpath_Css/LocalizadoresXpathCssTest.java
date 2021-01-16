package Xpath_Css;

import WebObjectPage.SpotifyFormulario;
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
        reg.accept_cookies();
        //formulario
        reg.email_name("pepe@pepe.com");
        reg.confirm_email_name("pepe@pepe.com");

        reg.password_send_key("pepito");
        reg.display_name("pepin");

        //formulario SpotifyFormulario
        reg.select_item_value_day("css_selector","31");
        reg.select_item_value_month("css_selector","Febrero");
        reg.select_item_value_year("css_selector","1981");
        reg.gender_sex();

        //aceptar terminos
        reg.accept_terms();

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
        reg.email_placeholder("pepe@pepe.com");
        reg.confirm_email_placeholder("pepe@pepe.com");
        reg.password_placeholder("pepito");
        reg.displayname_placeholder("pepin");

        //formulario SpotifyFormulario
        reg.select_item_value_day("css_selector","31");
        reg.select_item_value_year("css_selector","1981");

        //radio and check de formulario
        reg.gender_sex();

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
        reg.email_css_selector("pepe@pepe.com");
        reg.confirm_email_css_selector("pepe@pepe.com");
        reg.password_css_selector("pepito");
        reg.display_name_css_selector("pepin");

        //formulario SpotifyFormulario
        reg.select_item_value_day("css_selector","31");
        reg.select_item_value_month("css_selector","Febrero");
        reg.select_item_value_year("css_selector","1981");
        reg.gender_sex();

        //radio and check de formulario
        reg.accept_terms();

    }

    @AfterMethod
    public void cerrarDriver(){
        test.driver_close(driver);
    }
}
