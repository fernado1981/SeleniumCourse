package WebObjectPage;

import hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SpotifyHome {
    WebDriver driver;
    WebDriverWait wait;
    Utilities util;

    //cookie
    String cookies_xpath="//*[contains(text(), 'Aceptar Cookies')]";
    String forget_pass="¿Has olvidado la contraseña?";
    String title_home="Escuchar lo es todo - Spotify";
    String new_count_link_text ="Crear cuenta nueva";
    String registration_xpath ="//a[normalize-space()='Registrarse']";

    public SpotifyHome(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void accept_cookies(){
        util.click_element_xpath(cookies_xpath);
    }

    public void forget_passwd(){
        util.click_element_link_text(forget_pass);
    }
    public void forget_passwd_partial_link_text(String value){
        util.click_element_partial_link_text(value);
    }
    public void title_page(boolean equal){
        util.get_title(title_home, equal);
    }

    public void create_new_acount(){
        util.click_element_link_text(new_count_link_text);
    }

    public void registration(){
        util.click_element_xpath(registration_xpath);
    }

}
