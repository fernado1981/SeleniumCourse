package clase3;

import WebObjectPage.SpotifyFormulario;
import WebObjectPage.SpotifyHome;
import hook.ComplementDriver;
import hook.Utilities;
import org.junit.Before;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;


public class TestSpotify {

    WebDriver driver;
    ComplementDriver test = new ComplementDriver();

    @Test(groups = {"sucessTests","failTests"})

    @Before
    public WebDriver getDriver(String URL){
        driver = test.Driver(URL, "chrome");
        return driver;
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void verifySpotifyTitle(){
        WebDriver driver = getDriver("https://www.spotify.com");
        SpotifyHome home =  new SpotifyHome(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();
        //title
        home.title_page(true);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void verifySignupUrl(){
        WebDriver driver = getDriver("https://www.spotify.com");
        SpotifyHome home = new SpotifyHome(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();
        //registration
        home.registration();

        //current_url
        util.get_current_url("https://www.spotify.com/es/signup/", true);

    }

    @Test(priority = 2, enabled = false, groups = {"failTests"})
    public void invalidEmailTest( ){
        WebDriver driver = getDriver("https://www.spotify.com");
        SpotifyHome home = new SpotifyHome(driver);
        SpotifyFormulario reg = new SpotifyFormulario(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();
        //registration
        home.registration();

        //fill email,confirm email
        reg.email_name("test.com");
        reg.confirm_email_name("test.com");

        //search text error email
        reg.text_email_error("Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");

    }

    @Test(priority = 3,enabled = true, groups = {"failTests"})
    public void validateExistingEmail(){
        WebDriver driver = getDriver("https://www.spotify.com");
        SpotifyHome home = new SpotifyHome(driver);
        SpotifyFormulario reg = new SpotifyFormulario(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();
        //registration
        home.registration();

        //fill email,confirm email
        reg.email_name("test@test.com");
        reg.confirm_email_name("test@test.com");

        //search text error email duplicate
        reg.text_email_error_duplicate("Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");

    }

    @Test(priority = 4,enabled = true, groups = {"failTests"})
    public void checkEqualEmailsError(){
        WebDriver driver = getDriver("https://www.spotify.com");
        SpotifyHome home = new SpotifyHome(driver);
        SpotifyFormulario reg = new SpotifyFormulario(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();
        //registration
        home.registration();
        //fill email,confirm email
        reg.email_name("test999@test.com");
        reg.confirm_email_name("hola@hola.com");
        //click pass
        reg.password_click();
        //assert msn error
        reg.text_email_error_duplicate("Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");
        reg.text_email_error_not_equal("Las direcciones de correo electrónico no coinciden.");

    }

    @Test(priority = 5,groups = {"sucessTests"})
    public void checkEqualErrorMessages(){
        WebDriver driver = getDriver("https://www.spotify.com");
        SpotifyHome home = new SpotifyHome(driver);
        SpotifyFormulario reg = new SpotifyFormulario(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();
        //registration
        home.registration();
        //click submit
        reg.submit();
        //find errors
        reg.total_msg_error_xpath();

    }

    @Test
    @Parameters({"specificTag"})
    public void spotifytags(@Optional("h1") String tagName){
        WebDriver driver = getDriver("https://www.spotify.com");
        SpotifyHome home = new SpotifyHome(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();
        //registration
        home.registration();

        List<WebElement>Listas = util.find_tag_name(tagName);
        util.print_listas(Listas,tagName);
    }

    @AfterMethod
    public void cerrarDriver(){
        test.driver_close(driver);
    }
}
