package dropdow_link_radio;

import WebObjectPage.FacebookHomePage;
import hook.ComplementDriver;
import WebObjectPage.FacebookFormRegister;
import hook.Utilities;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class DropDownLinkRadioTest {

    WebDriver driver;
    ComplementDriver test = new ComplementDriver();

    @Before
    public WebDriver getDriver(String URL) {
        driver = test.Driver(URL,"chrome");
        return driver;
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void forgotAccountTest(){
        driver = getDriver("https://www.facebook.com/");
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        FacebookHomePage home = new FacebookHomePage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        home.forget_passwd();
        reg.title_page(true);

        util.get_current_url("https://www.facebook.com/", false);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void forgotAccountPartialLinkTest(){
        driver = getDriver("https://www.facebook.com/");
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        FacebookHomePage home = new FacebookHomePage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        home.forget_passwd_partial_link_text("¿Has olvidado");
        reg.title_page(true);
    }

    @Test(priority = 2,groups = {"sucessTests"})
    public void customSalesforceLink(){
        driver = getDriver("https://login.salesforce.com/");
        Utilities util = new Utilities(driver);
        util.maximize_window();

        util.click_element_link_text("Utilizar dominio personalizado");
        util.send_keys_xpath("//input[@id='mydomain']","as");

    }

    @Test(priority = 3,groups = {"sucessTests"})
    public void checkBoxAndComboboxTest(){
        driver = getDriver("https://www.facebook.com/");
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        FacebookHomePage home = new FacebookHomePage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        //form open-registration
        home.registration();

        //fill form name,lastname
        reg.fill_name_lastname_xpath("Alan", "Smith");

        //fill form day, month, year (class FacebookFormRegisterBirtday)
        reg.select_item_value_day("xpath", "4");
        int month = reg.select_item_value_month("xpath", "abr");
        reg.assert_month("xpath",month);
        int year = reg.select_item_value_year("xpath","2012");
        reg.assert_year("xpath",year);

        //fill form open-registration sex
        reg.click_sex("H");

    }

    @Test(priority = 4,groups = {"sucessTests"})
    public void birthdateTest() {
        driver = getDriver("https://www.facebook.com/");
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        FacebookHomePage home = new FacebookHomePage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        //form open-registration
        home.registration();

        //fill form day, month, year (class FacebookFormRegisterBirtday)
        reg.select_item_value_day("xpath", "20");
        int month = reg.select_item_value_month("xpath", "dic");
        reg.assert_month("xpath",month);
        int year = reg.select_item_value_year("xpath", "1990");
        reg.assert_year("xpath",year);

    }

    @Test(priority = 5,groups = {"sucessTests"})
    public void comboboxTest(){
        driver = getDriver("https://www.facebook.com/");
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        FacebookHomePage home = new FacebookHomePage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        //form open-registration
        home.registration();

        //fill form open-registration day, month, year
        int month = reg.select_item_value_month("xpath",  "dic");
        reg.assert_month("xpath",month);

        //assert size
        util.assert_combo_size_by_name("birthday_month");

    }

    @Test(priority = 6,groups = {"sucessTests"})
    public  void completeRegistration(){
        driver = getDriver("https://www.facebook.com/");
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        FacebookHomePage home = new FacebookHomePage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        //form open-registration
        home.registration();

        //fill form open-registration name,lastname,email,password
        reg.fill_name_lastname_xpath("Alan", "Smith");
        reg.email_password_xpath("Alan@alan.com", "Smith");

        //fill form open-registration day, month, year (class FacebookFormRegisterBirtday)
        reg.select_item_value_day("xpath",  "31");
        int month = reg.select_item_value_month("xpath",  "mar");
        reg.assert_month("xpath",month);
        int year = reg.select_item_value_year("xpath", "1981");
        reg.assert_year("xpath",year);

    }

    @Test(priority = 7,groups = {"sucessTests"})
    public void registrationFacebookTest() throws InterruptedException {
        driver = getDriver("https://www.facebook.com/");
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        FacebookHomePage home = new FacebookHomePage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        //form open-registration
        home.registration();

        //fill form open-registration name,lastname,email,password
        reg.fill_name_lastname_xpath("Alan", "Smith");
        reg.email_password_xpath("5555555", "123456789");

        //fill form open-registration day, month, year
        reg.select_item_value_day("name",  "26");
        int month = reg.select_item_value_month("name",  "ene");
        reg.assert_month("name",month);
        int year = reg.select_item_value_year("name",  "1980");
        reg.assert_year("name",year);

    }

    @AfterMethod
    public void cerrarDriver(){
        test.driver_close(driver);
    }
}
