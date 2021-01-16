package clase3;

import hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSalesForce {

    public WebDriver driver;

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
    }

    @Test(priority = 0, groups = {"sucessTests"})
    public void validateSalesforceLogoTest(){
        Utilities util = new Utilities(driver);
        util.maximize_window();

        util.find_id_search_tag("logo","img");
        util.find_id_search_attribute("logo","Salesforce","alt");
    }

    @Test(priority = 1, enabled = false, groups = {"sucessTests"})
    public void remenberMelsSelected(){
        Utilities util = new Utilities(driver);
        //WebDriver driver = getDriver("https://login.salesforce.com/?locale=eu");

        util.maximize_window();

        util.get_current_url("https://login.salesforce.com/?locale=eu", true);
        util.click_element_xpath("//input[@id='rememberUn']");

    }

    @Test(priority = 2, groups = {"sucessTests"})
    public void FooterIsValid(){
        Utilities util = new Utilities(driver);
        util.maximize_window();

        util.find_xpath_search_text("//*[contains(text(),'Reservados todos los derechos')]","© 2021 salesforce.com, inc. Reservados todos los derechos. | Privacidad","Reservados todos los derechos");

    }

    @Test(priority = 3, groups = {"sucessTests"})
    public void LoginFailureTest(){
        Utilities util = new Utilities(driver);
        //WebDriver driver = getDriver("https://login.salesforce.com/?locale=eu");
        util.maximize_window();

        util.send_keys_xpath("//input[@id='username']","test@test.com");
        util.send_keys_xpath("//input[@id='password']","123466");
        util.click_element_xpath("//input[@id='Login']");

        util.find_xpath_search_text("//div[@id='error']","El administrador del sistema ha desactivado su acceso a salesforce.com. Póngase en contacto con su administrador si desea obtener más información.","null");

   }

    @Test(priority = 2,groups = {"sucessTests"})
    public void customSalesforceLinkA(){
        Utilities util = new Utilities(driver);
        util.maximize_window();
        util.get_current_url("https://login.salesforce.com/", true);
        util.click_element_id("mydomainLink");
        util.send_keys_name("mydomain","as");
        util.get_current_url("https://login.salesforce.com/", true);
        util.click_name("Continue");
        util.get_current_url("https://american-securities.okta.com/app/salesforce/ko9cqogcCYKWOFOXOOSX/sso/saml", true);

        util.send_keys_xpath("//input[@name='username']","testing@testing.com");
        util.send_keys_xpath("//input[@name='password']","holamundo!");

        util.click_element_xpath("//input[@type='submit']");

    }

    @Test(priority = 2,groups = {"sucessTests"})
    public void customSalesforceLinkB(){
        Utilities util = new Utilities(driver);
        util.maximize_window();

        util.click_element_link_text("Utilizar dominio personalizado");
        util.send_keys_xpath("//input[@id='mydomain']","as");

    }

    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
