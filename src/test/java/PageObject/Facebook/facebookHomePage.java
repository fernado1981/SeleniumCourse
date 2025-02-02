package PageObject.Facebook;

import Hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class facebookHomePage {
    WebDriver driver;
    WebDriverWait wait;
    Utilities util;

    //cookie
    String cookies_xpath="//button[@data-cookiebanner='accept_button']";
    String forget_pass="¿Has olvidado la contraseña?";
    String title_home="Facebook - Entrar o registrarse";
    String new_count_link_text ="Crear cuenta nueva";
    String registration_xpath ="//a[@data-testid='open-registration-form-button']";
    String url="https://www.facebook.com/";

    public facebookHomePage(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void accept_cookies(){
        util.click_element_xpath(cookies_xpath);
    }

    public facebookFormRegisterPage forget_passwd(){
        util.click_element_link_text(forget_pass);
        facebookFormRegisterPage nextPage = new facebookFormRegisterPage(driver);
        return nextPage;
    }
    public facebookFormRegisterPage forget_passwd_partial_link_text(String value){
        util.click_element_partial_link_text(value);
        facebookFormRegisterPage nextPage = new facebookFormRegisterPage(driver);
        return nextPage;
    }
    public void title_page(boolean equal){
        util.get_title(title_home, equal);
    }
    public void get_url(boolean value){
        util.get_current_url(url, value);
    }
    public facebookFormRegisterPage create_new_acount(){
        util.click_element_link_text(new_count_link_text);
        facebookFormRegisterPage nextPage = new facebookFormRegisterPage(driver);
        return nextPage;
    }
    public facebookFormRegisterPage registration(){
        util.click_element_xpath(registration_xpath);
        facebookFormRegisterPage nextPage = new facebookFormRegisterPage(driver);
        return nextPage;
    }


}
