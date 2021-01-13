package clase2;

import hook.complement_driver;
import hook.utilities;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class SegundoTest {

    WebDriver driver;
    complement_driver test = new complement_driver();

    @Before
    public WebDriver getDriver(String URL){
        driver = test.Driver(URL, "chrome");
        return driver;
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void forgotAccountTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        utilities util = new utilities(driver);
        util.maximize_window();
        util.get_title("Facebook - Entrar o registrarse");
        util.click_element_xpath("//div[@aria-labelledby='cookie_banner_title'] //button[@data-cookiebanner='accept_button']");
        util.click_element_link_text("¿Has olvidado la contraseña?");
        util.get_title("¿Has olvidado la contraseña? | No puedo entrar | Facebook");

        closeDriver(driver);
    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void forgotAccountPartialLinkTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        utilities util = new utilities(driver);
        util.maximize_window();
        util.get_title("Facebook - Entrar o registrarse");
        util.click_element_xpath("//div[@aria-labelledby='cookie_banner_title'] //button[@data-cookiebanner='accept_button']");
        util.click_element_partial_link_text("olvidado");
        util.get_title("¿Has olvidado la contraseña? | No puedo entrar | Facebook");

        closeDriver(driver);
    }

    @Test(priority = 2,groups = {"sucessTests"})
    public void customSalesforceLink() throws InterruptedException {
        WebDriver driver = getDriver("https://login.salesforce.com/");
        utilities util = new utilities(driver);
        util.maximize_window();
        util.get_current_url("https://login.salesforce.com/");
        util.click_element_id("mydomainLink");
        util.send_keys_name("mydomain","as");
        util.get_current_url("https://login.salesforce.com/");
        util.click_name("Continue");
        util.get_current_url("https://american-securities.okta.com/app/salesforce/ko9cqogcCYKWOFOXOOSX/sso/saml");

        util.send_keys_xpath("//input[@name='username']","testing@testing.com");
        util.send_keys_xpath("//input[@name='password']","holamundo!");

        util.click_element_xpath("//input[@type='submit']");

        closeDriver(driver);
    }


    @Test(priority = 3,groups = {"sucessTests"})
    public void registrationToFacebookTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        utilities util = new utilities(driver);
        util.maximize_window();
        util.click_element_xpath("//div[@aria-labelledby='cookie_banner_title'] //button[@data-cookiebanner='accept_button']");
        util. click_element_link_text("Crear cuenta nueva");


        util.selectItemValue_day_month("day","25");
        util.selectItemValue_day_month("month","ago");

        closeDriver(driver);
    }

    @After
    public void closeDriver(WebDriver driver){
        driver.close();
    }
}
