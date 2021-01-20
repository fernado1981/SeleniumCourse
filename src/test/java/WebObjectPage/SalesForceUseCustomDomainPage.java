package WebObjectPage;

import hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesForceUseCustomDomainPage {
    WebDriver driver;
    WebDriverWait wait;
    Utilities util;

    String url="https://login.salesforce.com/";
    String my_domain_name="mydomain";
    String continue_xpath="//button[contains(text(),'Continuar')]";

    public SalesForceUseCustomDomainPage(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void get_url(boolean value){
        util.get_current_url(url, value);
    }

    public void insert_my_domain(String value) {
        util.send_keys_name(my_domain_name, value);
    }

    public void continue_btn_tap(){
        util.click_element_xpath(continue_xpath);
    }
}
