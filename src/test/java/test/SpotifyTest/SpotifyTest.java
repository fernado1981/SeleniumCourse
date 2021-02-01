package test.SpotifyTest;

import Hook.DriverSpotify;
import PageObject.Spotify.spotifyFormPage;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;


public class SpotifyTest extends DriverSpotify {

    public static Faker faker = new Faker();


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
        spotifyFormPage SpotifyRegister = SpotifyHome.registration();
        //SpotifyReg
        SpotifyRegister.get_url(true);

    }

    @Test(priority = 2, enabled = false, groups = {"failTests"})
    public void invalidEmailTest( ){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        spotifyFormPage SpotifyRegister = SpotifyHome.registration();

        //SpotifyReg
        SpotifyRegister.email_name("test.com");
        SpotifyRegister.confirm_email_name("test.com");

        //assert msn error
        SpotifyRegister.text_email_error("Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");

    }

    @Test(priority = 3,enabled = true, groups = {"failTests"})
    public void validateExistingEmail(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        spotifyFormPage SpotifyRegister = SpotifyHome.registration();

        //SpotifyReg
        SpotifyRegister.email_name("test@test.com");
        SpotifyRegister.confirm_email_name("test@test.com");

        //assert msn error
        SpotifyRegister.text_email_error_duplicate("Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");

    }

    @Test(priority = 4,enabled = false, groups = {"failTests"})
    public void checkEqualEmailsErrorFake(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        spotifyFormPage SpotifyRegister = SpotifyHome.registration();

        //SpotifyReg
        SpotifyRegister.email_name("test999@test.com");
        String email = faker.internet().emailAddress();
        SpotifyRegister.confirm_email_name(email);
        SpotifyRegister.password_click();

        //assert msn error
        SpotifyRegister.text_email_error_duplicate("Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");
        SpotifyRegister.text_email_error_not_equal("Las direcciones de correo electrónico no coinciden.");

    }

    @Test(priority = 4,enabled = false, groups = {"failTests"})
    public void checkEqualEmailsError(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        spotifyFormPage SpotifyRegister = SpotifyHome.registration();

        //SpotifyReg
        SpotifyRegister.email_name("test999@test.com");
        SpotifyRegister.confirm_email_name("hola@hola.com");
        SpotifyRegister.password_click();

        //assert msn error
        SpotifyRegister.text_email_error_duplicate("Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");
        SpotifyRegister.text_email_error_not_equal("Las direcciones de correo electrónico no coinciden.");

    }

    @Test(priority = 5,groups = {"sucessTests"})
    public void checkEqualErrorMessages(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        spotifyFormPage SpotifyRegister = SpotifyHome.registration();
        //SpotifyReg
        SpotifyRegister.submit();
        //assert msn error
        SpotifyRegister.total_msg_error_xpath();

    }

    @Test(priority = 6,groups = {"sucessTests"})
    @Parameters({"specificTag"})
    public void spotifytags(@Optional("h1") String tagName){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        SpotifyHome.registrationVoid();
        //SpotifyReg
        List<WebElement>Listas = util.find_tag_name(tagName);
        util.print_listas(Listas,tagName);
    }

    @Test(priority = 7,groups = {"sucessTests"})
    public void spotifyByNameTest(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        spotifyFormPage SpotifyRegister = SpotifyHome.registration();

        //SpotifyReg
        SpotifyRegister.email_name("pepe@pepe.com");
        SpotifyRegister.confirm_email_name("pepe@pepe.com");
        SpotifyRegister.password_send_key("pepito");
        SpotifyRegister.display_name("pepin");

        SpotifyRegister.select_item_value_day("css_selector","31");
        SpotifyRegister.select_item_value_month("css_selector","Febrero");
        SpotifyRegister.select_item_value_year("css_selector","1981");
        SpotifyRegister.gender_sex();

        //aceptar terminos
        SpotifyRegister.accept_terms();

    }

    @Test(priority = 8,groups = {"sucessTests"})
    public void spotifyByPlaceHolder(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        spotifyFormPage SpotifyRegister = SpotifyHome.registration();

        //SpotifyReg
        SpotifyRegister.email_placeholder("pepe@pepe.com");
        SpotifyRegister.confirm_email_placeholder("pepe@pepe.com");
        SpotifyRegister.password_placeholder("pepito");
        SpotifyRegister.displayname_placeholder("pepin");

        SpotifyRegister.select_item_value_day("css_selector","31");
        SpotifyRegister.select_item_value_year("css_selector","1981");
        SpotifyRegister.assert_year("css_selector",1981);

        SpotifyRegister.gender_sex();

    }

    @Test(priority = 8,groups = {"sucessTests"})
    public void spotifyByPlaceHolderFakeTest(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        spotifyFormPage SpotifyRegister = SpotifyHome.registration();

        //SpotifyReg
        String email = faker.internet().emailAddress();
        SpotifyRegister.email_name(email);
        SpotifyRegister.confirm_email_name(email);
        String pass = faker.internet().password();
        SpotifyRegister.password_send_key(pass);
        String displayName=faker.internet().avatar();
        SpotifyRegister.display_name(displayName);

        SpotifyRegister.select_item_value_day("css_selector","31");
        SpotifyRegister.select_item_value_year("css_selector","1981");
        SpotifyRegister.assert_year("css_selector",1981);

        SpotifyRegister.gender_sex();

    }

    @Test(priority = 9,groups = {"sucessTests"})
    public void spotifyByName(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        spotifyFormPage SpotifyRegister = SpotifyHome.registration();

        //SpotifyReg
        SpotifyRegister.email_css_selector("pepe@pepe.com");
        SpotifyRegister.confirm_email_css_selector("pepe@pepe.com");
        SpotifyRegister.password_css_selector("pepito");
        SpotifyRegister.display_name_css_selector("pepin");

        SpotifyRegister.select_item_value_day("css_selector","31");
        SpotifyRegister.select_item_value_month("css_selector","Febrero");
        SpotifyRegister.assert_month("css_selector",2);
        SpotifyRegister.select_item_value_year("css_selector","1981");
        SpotifyRegister.assert_year("css_selector",1981);
        SpotifyRegister.gender_sex();

        //aceptar terminos
        SpotifyRegister.accept_terms();

    }

    @Test(priority = 7,groups = {"sucessTests"})
    public void spotifyByNameFakeTest(){
        //cookie
        SpotifyHome.accept_cookies();
        //SpotifyHome
        spotifyFormPage SpotifyRegister = SpotifyHome.registration();

        //SpotifyReg
        String email = faker.internet().emailAddress();
        SpotifyRegister.email_name(email);
        SpotifyRegister.confirm_email_name(email);
        String pass = faker.internet().password();
        SpotifyRegister.password_send_key(pass);
        String displayName=faker.internet().avatar();
        SpotifyRegister.display_name(displayName);

        SpotifyRegister.select_item_value_day("css_selector","31");
        SpotifyRegister.select_item_value_month("css_selector","Febrero");
        SpotifyRegister.select_item_value_year("css_selector","1981");
        SpotifyRegister.gender_sex();

        //aceptar terminos
        SpotifyRegister.accept_terms();

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
}
