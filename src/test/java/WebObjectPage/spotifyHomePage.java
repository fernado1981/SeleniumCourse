package WebObjectPage;

import Hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class spotifyHomePage {
    WebDriver driver;
    WebDriverWait wait;
    Utilities util;

    //cookie
    String cookies_xpath="//*[contains(text(), 'Aceptar Cookies')]";
    String title_home="Escuchar lo es todo - Spotify";
    String registration_xpath ="//a[normalize-space()='Registrarse']";
    String url="https://www.spotify.com";
    String url_es="https://www.spotify.com/es/";

    public spotifyHomePage(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void accept_cookies(){ util.click_element_xpath(cookies_xpath); }

    public void title_page(boolean equal){ util.get_title(title_home, equal); }

    public void get_url(boolean value){
        util.get_current_url(url, value);
    }

    public void get_url_es(boolean value){
        util.get_current_url(url_es, value);
    }

    public void registration(){
        util.click_element_xpath(registration_xpath);
    }


}
