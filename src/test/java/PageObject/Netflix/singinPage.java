package PageObject.Netflix;

import Hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class singinPage {

    WebDriver driver;
    WebDriverWait wait;
    Utilities util;

    String titleH1="Iniciar sesión";
    String singtitleH1="//h1[contains(text(),'Iniciar sesión')]";
    String facebookLogin="//span[contains(text(),'Iniciar sesión con Facebook')]";
    String expectedFacebookLogin="Iniciar sesión con Facebook";
    String email="//input[@autocomplete='email']";
    String pass="//input[@name='password']";
    String btnsubmit="//button[@type='submit' and @data-uia='login-submit-button']";
    String errorEmailMsg="//*[contains(text(),'Escribe un correo válido.')]";
    String textErrorEmail="Escribe un correo válido.";
    String checkbox="//input[@type='checkbox']";

    public singinPage(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void titleH1(){
        util.get_text_xpath(singtitleH1, titleH1);
    }

    public void iniciarSesionFacebook(){
        util.get_text_xpath(facebookLogin, expectedFacebookLogin);
    }

    public void regEmailAndPass(){
        util.send_keys_xpath(email,"XXXX");
        util.send_keys_xpath(pass,"holamundo");
        util.click_element_xpath(btnsubmit);
    }

    public void validateMsgError(){
        util.get_text_xpath_email_error(errorEmailMsg,textErrorEmail);
    }

    public void validateCheckBox() {
        util.checkBox_selected(checkbox);
    }
}
