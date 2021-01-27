package SalesForce_Spotify;

import WebObjectPage.spotifyForm;
import WebObjectPage.spotifyHome;
import hook.Utilities;
import com.github.javafaker.Faker;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;


public class SpotifyTest {

    public WebDriver driver;
    public spotifyHome SpotifyHome;
    public spotifyForm SpotifyReg;
    public Utilities util;

    public static Faker faker = new Faker();

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
        SpotifyHome =  new spotifyHome(driver);
        SpotifyReg =  new spotifyForm(driver);
        util = new Utilities(driver);
        util.maximize_window();
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void verifySpotifyTitle(){
        //cookie
        SpotifyHome.accept_cookies();
        //title
        SpotifyHome.title_page(true);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void verifySignupUrl(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();
        //SpotifyReg
        SpotifyReg.get_url(true);

    }

    @Test(priority = 2, enabled = false, groups = {"failTests"})
    public void invalidEmailTest( ){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();

        //SpotifyReg
        SpotifyReg.email_name("test.com");
        SpotifyReg.confirm_email_name("test.com");

        //assert msn error
        SpotifyReg.text_email_error("Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");

    }

    @Test(priority = 3,enabled = false, groups = {"failTests"})
    public void validateExistingEmail(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();

        //SpotifyReg
        SpotifyReg.email_name("test@test.com");
        SpotifyReg.confirm_email_name("test@test.com");

        //assert msn error
        SpotifyReg.text_email_error_duplicate("Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");

    }

    @Test(priority = 4,enabled = false, groups = {"failTests"})
    public void checkEqualEmailsErrorFake(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();

        //SpotifyReg
        SpotifyReg.email_name("test999@test.com");
        String email = faker.internet().emailAddress();
        SpotifyReg.confirm_email_name(email);
        SpotifyReg.password_click();

        //assert msn error
        SpotifyReg.text_email_error_duplicate("Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");
        SpotifyReg.text_email_error_not_equal("Las direcciones de correo electrónico no coinciden.");

    }

    @Test(priority = 4,enabled = false, groups = {"failTests"})
    public void checkEqualEmailsError(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();

        //SpotifyReg
        SpotifyReg.email_name("test999@test.com");
        SpotifyReg.confirm_email_name("hola@hola.com");
        SpotifyReg.password_click();

        //assert msn error
        SpotifyReg.text_email_error_duplicate("Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");
        SpotifyReg.text_email_error_not_equal("Las direcciones de correo electrónico no coinciden.");

    }

    @Test(priority = 5,groups = {"sucessTests"})
    public void checkEqualErrorMessages(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();
        //SpotifyReg
        SpotifyReg.submit();
        //assert msn error
        SpotifyReg.total_msg_error_xpath();

    }

    @Test(priority = 6,groups = {"sucessTests"})
    @Parameters({"specificTag"})
    public void spotifytags(@Optional("h1") String tagName){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();
        //SpotifyReg
        List<WebElement>Listas = util.find_tag_name(tagName);
        util.print_listas(Listas,tagName);
    }

    @Test(priority = 7,groups = {"sucessTests"})
    public void spotifyByNameTest(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();

        //SpotifyReg
        SpotifyReg.email_name("pepe@pepe.com");
        SpotifyReg.confirm_email_name("pepe@pepe.com");
        SpotifyReg.password_send_key("pepito");
        SpotifyReg.display_name("pepin");

        SpotifyReg.select_item_value_day("css_selector","31");
        SpotifyReg.select_item_value_month("css_selector","Febrero");
        SpotifyReg.select_item_value_year("css_selector","1981");
        SpotifyReg.gender_sex();

        //aceptar terminos
        SpotifyReg.accept_terms();

    }

    @Test(priority = 8,groups = {"sucessTests"})
    public void spotifyByPlaceHolder(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();

        //SpotifyReg
        SpotifyReg.email_placeholder("pepe@pepe.com");
        SpotifyReg.confirm_email_placeholder("pepe@pepe.com");
        SpotifyReg.password_placeholder("pepito");
        SpotifyReg.displayname_placeholder("pepin");

        SpotifyReg.select_item_value_day("css_selector","31");
        SpotifyReg.select_item_value_year("css_selector","1981");
        SpotifyReg.assert_year("css_selector",1981);

        SpotifyReg.gender_sex();

    }

    @Test(priority = 8,groups = {"sucessTests"})
    public void spotifyByPlaceHolderFakeTest(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();

        //SpotifyReg
        String email = faker.internet().emailAddress();
        SpotifyReg.email_name(email);
        SpotifyReg.confirm_email_name(email);
        String pass = faker.internet().password();
        SpotifyReg.password_send_key(pass);
        String displayName=faker.internet().avatar();
        SpotifyReg.display_name(displayName);

        SpotifyReg.select_item_value_day("css_selector","31");
        SpotifyReg.select_item_value_year("css_selector","1981");
        SpotifyReg.assert_year("css_selector",1981);

        SpotifyReg.gender_sex();

    }

    @Test(priority = 9,groups = {"sucessTests"})
    public void spotifyByName(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();

        //SpotifyReg
        SpotifyReg.email_css_selector("pepe@pepe.com");
        SpotifyReg.confirm_email_css_selector("pepe@pepe.com");
        SpotifyReg.password_css_selector("pepito");
        SpotifyReg.display_name_css_selector("pepin");

        SpotifyReg.select_item_value_day("css_selector","31");
        SpotifyReg.select_item_value_month("css_selector","Febrero");
        SpotifyReg.assert_month("css_selector",2);
        SpotifyReg.select_item_value_year("css_selector","1981");
        SpotifyReg.assert_year("css_selector",1981);
        SpotifyReg.gender_sex();

        //aceptar terminos
        SpotifyReg.accept_terms();

    }

    @Test(priority = 7,groups = {"sucessTests"})
    public void spotifyByNameFakeTest(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registration();

        //SpotifyReg
        String email = faker.internet().emailAddress();
        SpotifyReg.email_name(email);
        SpotifyReg.confirm_email_name(email);
        String pass = faker.internet().password();
        SpotifyReg.password_send_key(pass);
        String displayName=faker.internet().avatar();
        SpotifyReg.display_name(displayName);

        SpotifyReg.select_item_value_day("css_selector","31");
        SpotifyReg.select_item_value_month("css_selector","Febrero");
        SpotifyReg.select_item_value_year("css_selector","1981");
        SpotifyReg.gender_sex();

        //aceptar terminos
        SpotifyReg.accept_terms();

    }

    @Test(priority = 10,groups = {"sucessTests"})
    public void spotifyTest(){
        SpotifyHome.title_page(true);
        SpotifyHome.get_url_es(true);

        List<WebElement> listas_h1 = util.find_tag_name("h1");
        util.print_listas(listas_h1,"h1");
        List<WebElement> listas_h2 = util.find_tag_name("h2");
        util.print_listas(listas_h2,"h2");
        List<WebElement> listas_p = util.find_tag_name("p");
        util.print_listas(listas_p,"p");

    }

    @Test(priority = 11,groups = {"sucessTests"})
    public void mostrarSpotifyLinks(){
        SpotifyHome.title_page(true);
        SpotifyHome.get_url_es(true);

        List<WebElement>Listas_a = util.find_tag_name("a");
        util.print_listas(Listas_a,"a");

    }

    @AfterMethod
    public void cerrarDriver(){
       driver.quit();
    }
}
