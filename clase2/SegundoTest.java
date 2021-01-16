package clase2;

import WebObjectPage.FacebookHomePage;
import hook.ComplementDriver;
import WebObjectPage.FacebookFormRegister;
import hook.Utilities;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SegundoTest {

    WebDriver driver;
    ComplementDriver test = new ComplementDriver();

    @Before
    public WebDriver getDriver(String URL){
        driver = test.Driver(URL, "chrome");
        return driver;
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void forgotAccountTest(){
        WebDriver driver = getDriver("https://www.facebook.com/");
        Utilities util = new Utilities(driver);
        FacebookHomePage home =new FacebookHomePage(driver);
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        //home
        home.title_page(true);
        home.forget_passwd();

        //register
        reg.title_page(true);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void forgotAccountPartialLinkTest(){
        WebDriver driver = getDriver("https://www.facebook.com/");
        Utilities util = new Utilities(driver);
        FacebookHomePage home =new FacebookHomePage(driver);
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        //home
        home.title_page(true);
        home.forget_passwd_partial_link_text("olvidado");
        reg.title_page(true);

    }

    @Test(priority = 2,groups = {"sucessTests"})
    public void customSalesforceLink(){
        WebDriver driver = getDriver("https://login.salesforce.com/");
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


    @Test(priority = 3,groups = {"sucessTests"})
    public void registrationToFacebookTest(){
        WebDriver driver = getDriver("https://www.facebook.com/");
        Utilities util = new Utilities(driver);
        FacebookHomePage home =new FacebookHomePage(driver);
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        //new_count
        home.create_new_acount();

        //fill day and month
        reg.select_item_value_day("id","25");
        int mes = reg.select_item_value_month("id", "ago");
        reg.assert_month("id",mes);

    }


    @AfterMethod
    public void cerrarDriver(){
        test.driver_close(driver);
    }
}
