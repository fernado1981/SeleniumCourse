package PageObject.SalesForce;

import Hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class salesForceLoginPage {
    WebDriver driver;
    WebDriverWait wait;
    Utilities util;

    //cookie
    String id_logo="logo";
    String alt_logo_expected="Salesforce";
    String remenber_xpath="//input[@id='rememberUn']";
    String url="https://login.salesforce.com/";
    String footer_text_xpath="//*[contains(text(),'Reservados todos los derechos')]";
    String footer_text_contain="Reservados todos los derechos";
    String footer_text_expected="© 2021 salesforce.com, inc. Reservados todos los derechos. | Privacidad";
    String fill_username_xpath="//input[@id='username']";
    String fill_password_xpath="//input[@id='password']";
    String login_btn_xpath="//input[@id='Login']";
    String desactivate_text_xpath="//div[@id='error']";
    String desactivate_text_contain="null";
    String desactivate_text_expected="El administrador del sistema ha desactivado su acceso a salesforce.com. Póngase en contacto con su administrador si desea obtener más información.";
    String desactivate_text_contain_fake="Compruebe su nombre de usuario y contraseña. Si sigue sin poder iniciar sesión, póngase en contacto con su administrador de Salesforce.";
    String custom_domain_id_link="mydomainLink";


    public salesForceLoginPage(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void search_logo_img(String tag) {
        if (tag.equalsIgnoreCase("img")) {
            util.find_id_search_tag(id_logo, tag);
        } else if (tag.equalsIgnoreCase("alt")) {
            util.find_id_search_attribute(id_logo, alt_logo_expected, tag);
        }
    }
    public void remenber(){
        util.click_element_xpath(remenber_xpath);
    }

    public void get_url(boolean value){
        util.get_current_url(url, value);
    }

    public void search_text(String value){
        if (value.equalsIgnoreCase("txtfooter")) {
            util.find_xpath_search_text(footer_text_xpath, footer_text_expected, footer_text_contain);
        }else if(value.equalsIgnoreCase("txtdesactivate")){
            util.find_xpath_search_text(desactivate_text_xpath, desactivate_text_expected, desactivate_text_contain);
        }else if(value.equalsIgnoreCase("txtdesactivatefake")){
            util.find_xpath_search_text(desactivate_text_xpath, desactivate_text_contain_fake, desactivate_text_contain);
        }
    }

    public salesForceUseCustomDomainPage use_custom_domain_tap(){
        util.click_element_id(custom_domain_id_link);
        salesForceUseCustomDomainPage nextPage = new salesForceUseCustomDomainPage(driver);
        return nextPage;
    }

    public void fill_username(String value){
        util.send_keys_xpath(fill_username_xpath,value);
    }

    public void fill_password(String value){
        util.send_keys_xpath(fill_password_xpath,value);
    }

    public void login_btn_tap(){
        util.click_element_xpath(login_btn_xpath);
    }


}
