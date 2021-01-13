package clase3;

import hook.complement_driver;
import hook.utilities;
import org.junit.Before;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;


public class testngSpotify {

    WebDriver driver;
    complement_driver test = new complement_driver();

    @Test(groups = {"sucessTests","failTests"})

    @Before
    public WebDriver getDriver(String URL){
        driver = test.Driver(URL, "chrome");
        return driver;
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void verifySpotifyTitle(){
        WebDriver driver = getDriver("https://www.spotify.com");
        utilities util = new utilities(driver);
        util.maximize_window();
        util.get_title("Escuchar lo es todo - Spotify");

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void verifySignupUrl() throws InterruptedException {
        WebDriver driver = getDriver("https://www.spotify.com");
        utilities util = new utilities(driver);
        util.maximize_window();
        util.click_element_xpath("//*[contains(text(), 'Aceptar Cookies')]");
        util.click_element_xpath("//a[normalize-space()='Registrarse']");
        util.get_current_url("https://www.spotify.com/es/signup/");

    }

    @Test(priority = 2, enabled = false, groups = {"failTests"})
    public void invalidEmailTest( ){
        WebDriver driver = getDriver("https://www.spotify.com");
        utilities util = new utilities(driver);
        util.maximize_window();

        util.click_element_xpath("//*[contains(text(), 'Aceptar Cookies')]");
        util.click_element_xpath("//a[normalize-space()='Registrarse']");
        util.send_keys_name("email","test.com");
        util.send_keys_id("confirm","test.com");

        util.get_text_xpath_email_error("//*[contains(text(),'Este correo electrónico no es válido.')]", "Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");

    }

    @Test(priority = 3,enabled = false, groups = {"failTests"})
    public void validateExistingEmail(){
        WebDriver driver = getDriver("https://www.spotify.com");
        utilities util = new utilities(driver);
        util.maximize_window();

        util.click_element_xpath("//*[contains(text(), 'Aceptar Cookies')]");
        util.click_element_xpath("//a[normalize-space()='Registrarse']");

        util.send_keys_name("email","test@test.com");
        util.send_keys_id("confirm", "test@test.com");


        util.get_text_xpath_email_error("//*[contains(text(),'Este correo electrónico ya')]", "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");

    }

    @Test(priority = 4,enabled = false, groups = {"failTests"})
    public void checkEqualEmailsError() throws InterruptedException {
        WebDriver driver = getDriver("https://www.spotify.com");
        utilities util = new utilities(driver);
        util.maximize_window();

        util.click_element_xpath("//*[contains(text(), 'Aceptar Cookies')]");
        util.click_element_xpath("//a[normalize-space()='Registrarse']");
        util.send_keys_name("email","test999@test.com");
        util.send_keys_id("confirm", "hola@hola.com");
        util.click_element_xpath("//input[@id='password']");

        util.get_text_xpath_email_error("//*[contains(text(),'Este correo electrónico ya')]", "Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");
        util.get_text_xpath_email_error("//*[contains(text(),'Las direcciones de correo electrónico no coinciden.')]","Las direcciones de correo electrónico no coinciden.");

    }

    @Test(priority = 5,groups = {"sucessTests"})
    public void checkEqualErrorMessages() throws InterruptedException {
        WebDriver driver = getDriver("https://www.spotify.com");
        utilities util = new utilities(driver);
        util.maximize_window();

        util.click_element_xpath("//a[normalize-space()='Registrarse']");
        util.click_element_xpath("//button[@type='submit']");
        util.find_total_msg_error_xpath("//*[@aria-label='Indicador de error']");

    }

    @Test
    @Parameters({"specificTag"})
    public void spotifytags(@Optional("h1") String tagName) throws InterruptedException {
        WebDriver driver = getDriver("https://www.spotify.com");
        utilities util = new utilities(driver);
        util.maximize_window();

        util.click_element_xpath("//a[normalize-space()='Registrarse']");
        List<WebElement>Listas = util.find_tag_name(tagName);
        util.print_listas(Listas,tagName);
    }

    @AfterMethod
    public void cerrarDriver(){
        driver.close();
    }
}
