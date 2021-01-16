package clase3;

import WebObjectPage.SpotifyFormulario;
import WebObjectPage.SpotifyHome;
import hook.Utilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;


public class TestSpotify {

    public WebDriver driver;

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void verifySpotifyTitle(){
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
        SpotifyHome home =  new SpotifyHome(driver);
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
        SpotifyHome home =  new SpotifyHome(driver);
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
        SpotifyHome home =  new SpotifyHome(driver);
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
        SpotifyHome home =  new SpotifyHome(driver);
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
        SpotifyHome home =  new SpotifyHome(driver);
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
        SpotifyHome home =  new SpotifyHome(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();
        //registration
        home.registration();

        List<WebElement>Listas = util.find_tag_name(tagName);
        util.print_listas(Listas,tagName);
    }

    @Test(priority = 2,groups = {"sucessTests"})
    public void spotifyByNameTest(){
        SpotifyHome home =  new SpotifyHome(driver);
        SpotifyFormulario reg = new SpotifyFormulario(driver);
        Utilities util = new Utilities(driver);

        util.maximize_window();

        //cookie
        home.accept_cookies();
        //registration
        home.registration();

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

    @Test(priority = 3,groups = {"sucessTests"})
    public void spotifyByPlaceHolder(){
        SpotifyHome home =  new SpotifyHome(driver);
        SpotifyFormulario reg = new SpotifyFormulario(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();
        //registration
        home.registration();

        //formulario
        reg.email_placeholder("pepe@pepe.com");
        reg.confirm_email_placeholder("pepe@pepe.com");
        reg.password_placeholder("pepito");
        reg.displayname_placeholder("pepin");

        //formulario SpotifyFormulario
        reg.select_item_value_day("css_selector","31");
        reg.select_item_value_year("css_selector","1981");
        reg.assert_year("css_selector",1981);

        //radio and check de formulario
        reg.gender_sex();

    }

    @Test(priority = 4,groups = {"sucessTests"})
    public void spotifyByName(){
        SpotifyHome home =  new SpotifyHome(driver);
        SpotifyFormulario reg = new SpotifyFormulario(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();
        //registration
        home.registration();

        //formulario
        reg.email_css_selector("pepe@pepe.com");
        reg.confirm_email_css_selector("pepe@pepe.com");
        reg.password_css_selector("pepito");
        reg.display_name_css_selector("pepin");

        //formulario SpotifyFormulario
        reg.select_item_value_day("css_selector","31");
        reg.select_item_value_month("css_selector","Febrero");
        reg.assert_month("css_selector",2);
        reg.select_item_value_year("css_selector","1981");
        reg.assert_year("css_selector",1981);
        reg.gender_sex();

        //radio and check de formulario
        reg.accept_terms();

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void spotifyTest(){
        SpotifyHome home =  new SpotifyHome(driver);
        Utilities util = new Utilities(driver);

        util.maximize_window();
        home.title_page(true);
        util.get_current_url("https://www.spotify.com/es/", true);
        List<WebElement> listas_h1 = util.find_tag_name("h1");
        util.print_listas(listas_h1,"h1");
        List<WebElement> listas_h2 = util.find_tag_name("h2");
        util.print_listas(listas_h2,"h2");
        List<WebElement> listas_p = util.find_tag_name("p");
        util.print_listas(listas_p,"p");

    }

    @Test(priority = 2,groups = {"sucessTests"})
    public void mostrarSpotifyLinks(){
        SpotifyHome home =  new SpotifyHome(driver);
        Utilities util = new Utilities(driver);

        util.maximize_window();
        home.title_page(true);
        util.get_current_url("https://www.spotify.com/es/", true);
        List<WebElement>Listas_a = util.find_tag_name("a");
        util.print_listas(Listas_a,"a");

    }

    @AfterMethod
    public void cerrarDriver(){
       driver.quit();
    }
}
