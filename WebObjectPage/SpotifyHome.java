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
    String title_home="Escuchar lo es todo - Spotify";
    String registration_xpath ="//a[normalize-space()='Registrarse']";

    public SpotifyHome(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void accept_cookies(){
        util.click_element_xpath(cookies_xpath);
    }

    public void title_page(boolean equal){
        util.get_title(title_home, equal);
    }

    public void registration(){
        util.click_element_xpath(registration_xpath);
    }

}
