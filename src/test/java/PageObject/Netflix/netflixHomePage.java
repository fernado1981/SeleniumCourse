package PageObject.Netflix;

import Hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class netflixHomePage {


        WebDriver driver;
        WebDriverWait wait;
        Utilities util;


        String title_home="Netflix España - Ver series en línea, ver películas en línea";
        String registration_xpath="//a[contains(text(),'Iniciar sesión')]";
        String cookie="//button[@data-uia='cookie-disclosure-accept-cookies']";
        String email="//input[@data-uia='field-email']";
        String btnEmpezar="//span[contains(text(),'EMPEZAR')]";

        public netflixHomePage(WebDriver remoteDriver) {
            driver = remoteDriver;
            wait = new WebDriverWait(driver, 10);
            util = new Utilities(driver);
        }

        public void accept_cookie(){
            util.click_element_xpath(cookie);
        }

        public void title_page(boolean equal){
            util.get_title(title_home, equal);
        }

        public singinPage init_Session() {
            util.click_element_xpath(registration_xpath);
            singinPage nextPage = new singinPage(driver);
            return nextPage;
        }

        public void correoMail(String Correo){
            util.send_keys_xpath(email,Correo);
        }

        public singupPage tap_Empezar(){
            util.click_element_xpath(btnEmpezar);
            singupPage nextPage = new singupPage(driver);
            return nextPage;
        }


}
