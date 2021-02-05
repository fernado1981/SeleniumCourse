package PageObject.SalesForce;

import Hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class salesForceOktaFormPage {

    WebDriver driver;
    WebDriverWait wait;
    Utilities util;

    String url="https://american-securities.okta.com/app/salesforce/ko9cqogcCYKWOFOXOOSX/sso/saml";
    String fill_username_xpath="//input[@name='username']";
    String fill_password_xpath="//input[@name='password']";
    String sign_in_btn_xpath="//input[@type='submit']";


    public salesForceOktaFormPage(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void get_url(boolean value){
        util.get_current_url(url, value);
    }

    public void fill_username(String value){
        util.send_keys_xpath(fill_username_xpath,value);
    }

    public void fill_password(String value){
        util.send_keys_xpath(fill_password_xpath,value);
    }

    public void sign_in(){
        util.click_element_xpath(sign_in_btn_xpath);
    }
}
