package clase3;

import hook.ComplementDriver;
import hook.Utilities;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestSalesforce {

    WebDriver driver;
    ComplementDriver test = new ComplementDriver();

    @Test(groups = {"sucessTests","failTests"})

    @Before
    public WebDriver getDriver(String URL){
        driver = test.Driver(URL, "chrome");
        return driver;
    }

    @Test(priority = 0, groups = {"sucessTests"})
    public void validateSalesforceLogoTest(){
        WebDriver driver = getDriver("https://login.salesforce.com/");
        Utilities util = new Utilities(driver);
        util.maximize_window();

        util.find_id_search_tag("logo","img");
        util.find_id_search_attribute("logo","Salesforce","alt");
    }

    @Test(priority = 1, enabled = false, groups = {"sucessTests"})
    public void remenberMelsSelected(){
        WebDriver driver = getDriver("https://login.salesforce.com/?locale=eu");
        Utilities util = new Utilities(driver);
        util.maximize_window();

        util.get_current_url("https://login.salesforce.com/?locale=eu", true);
        util.click_element_xpath("//input[@id='rememberUn']");

    }

    @Test(priority = 2, groups = {"sucessTests"})
    public void FooterIsValid(){
        WebDriver driver = getDriver("https://login.salesforce.com/");
        Utilities util = new Utilities(driver);
        util.maximize_window();

        util.find_xpath_search_text("//*[contains(text(),'Reservados todos los derechos')]","© 2021 salesforce.com, inc. Reservados todos los derechos. | Privacidad","Reservados todos los derechos");

    }

    @Test(priority = 3, groups = {"sucessTests"})
    public void LoginFailureTest(){
        WebDriver driver = getDriver("https://login.salesforce.com/?locale=eu");
        Utilities util = new Utilities(driver);
        util.maximize_window();

        util.send_keys_xpath("//input[@id='username']","test@test.com");
        util.send_keys_xpath("//input[@id='password']","123466");
        util.click_element_xpath("//input[@id='Login']");

        util.find_xpath_search_text("//div[@id='error']","Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.","null");

   }

    @AfterMethod
    public void cerrarDriver(){
        test.driver_close(driver);
    }
}
