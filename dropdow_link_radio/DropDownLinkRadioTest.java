package dropdow_link_radio;

import hook.ComplementDriver;
import WebObject.FacebookFormRegisterBirtday;
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
        Utilities util = new Utilities(driver);
        util.maximize_window();
        //cookie
        util.click_element_xpath("//button[@data-cookiebanner='accept_button']");

        util.click_element_link_text("¿Has olvidado la contraseña?");
        util.get_title("¿Has olvidado la contraseña? | No puedo entrar | Facebook", true);
        util.get_current_url("https://www.facebook.com/", false);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void forgotAccountPartialLinkTest(){
        driver = getDriver("https://www.facebook.com/");
        Utilities util = new Utilities(driver);
        util.maximize_window();
        //cookie
        util.click_element_xpath("//button[@data-cookiebanner='accept_button']");

        util.click_element_partial_link_text("¿Has olvidado");
        util.get_title("¿Has olvidado la contraseña? | No puedo entrar | Facebook",true);

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
        Utilities util = new Utilities(driver);
        FacebookFormRegisterBirtday reg = new FacebookFormRegisterBirtday(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//button[@data-cookiebanner='accept_button']");

        //form open-registration
        util.click_element_xpath("//a[@data-testid='open-registration-form-button']");

        //fill form open-registration name,lastname
        util.send_keys_xpath("//input[@name='firstname']", "Alan");
        util.send_keys_xpath("//input[@name='lastname']", "Smith");

        //fill form open-registration day, month, year (class FacebookFormRegisterBirtday)
        reg.select_item_value_day("xpath", "//select[@name='birthday_day']", "4");
        int month = reg.select_item_value_month("xpath", "//select[@name='birthday_month']", "abr");
        reg.assert_month("xpath","//select[@name='birthday_month']",month);
        int year = reg.select_item_value_year("xpath", "//select[@name='birthday_year']", "2012");
        reg.assert_year("xpath","//select[@name='birthday_year']",year);

        //fill form open-registration sex
        util.click_element_xpath("//input[@name='sex']");

    }

    @Test(priority = 4,groups = {"sucessTests"})
    public void birthdateTest() {
        driver = getDriver("https://www.facebook.com/");
        FacebookFormRegisterBirtday reg = new FacebookFormRegisterBirtday(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//button[@data-cookiebanner='accept_button']");

        //form open-registration
        util.click_element_xpath("//a[@data-testid='open-registration-form-button']");

        //fill form open-registration day, month, year (class FacebookFormRegisterBirtday)
        reg.select_item_value_day("xpath", "//select[@name='birthday_day']", "20");
        int month = reg.select_item_value_month("xpath", "//select[@name='birthday_month']", "dic");
        reg.assert_month("xpath","//select[@name='birthday_month']",month);
        int year = reg.select_item_value_year("xpath", "//select[@name='birthday_year']", "1990");
        reg.assert_year("xpath","//select[@name='birthday_year']",year);

    }

    @Test(priority = 5,groups = {"sucessTests"})
    public void comboboxTest(){
        driver = getDriver("https://www.facebook.com/");
        FacebookFormRegisterBirtday reg = new FacebookFormRegisterBirtday(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//button[@data-cookiebanner='accept_button']");

        //form open-registration
        util.click_element_xpath("//a[@data-testid='open-registration-form-button']");

        //fill form open-registration day, month, year (class FacebookFormRegisterBirtday)
        int month = reg.select_item_value_month("xpath", "//select[@name='birthday_month']", "dic");
        reg.assert_month("xpath","//select[@name='birthday_month']",month);

        //assert size
        util.assert_combo_size_by_name("birthday_month");

    }

    @Test(priority = 6,groups = {"sucessTests"})
    public  void completeRegistration(){
        driver = getDriver("https://www.facebook.com/");
        FacebookFormRegisterBirtday reg = new FacebookFormRegisterBirtday(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//button[@data-cookiebanner='accept_button']");

        //form open-registration
        util.click_element_xpath("//a[@data-testid='open-registration-form-button']");

        //fill form open-registration name,lastname,email,password
        util.send_keys_xpath("//input[@name='firstname']", "Alan");
        util.send_keys_xpath("//input[@name='lastname']", "Smith");
        util.send_keys_xpath("//input[@name='reg_email__']","Alan@alan.com");
        util.send_keys_xpath("//input[@name='reg_passwd__']", "Smith");

        //fill form open-registration day, month, year (class FacebookFormRegisterBirtday)
        reg.select_item_value_day("xpath", "//select[@name='birthday_day']", "31");
        int month = reg.select_item_value_month("xpath", "//select[@name='birthday_month']", "mar");
        reg.assert_month("xpath","//select[@name='birthday_month']",month);
        int year = reg.select_item_value_year("xpath", "//select[@name='birthday_year']", "1981");
        reg.assert_year("xpath","//select[@name='birthday_year']",year);

    }

    @Test(priority = 7,groups = {"sucessTests"})
    public void registrationFacebookTest() throws InterruptedException {
        driver = getDriver("https://www.facebook.com/");
        FacebookFormRegisterBirtday reg = new FacebookFormRegisterBirtday(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//button[@data-cookiebanner='accept_button']");

        //form open-registration
        util.click_element_xpath("//a[@data-testid='open-registration-form-button']");

        //fill form open-registration name,lastname,email,password
        util.send_keys_xpath("//input[@name='firstname']", "Alan");
        util.send_keys_xpath("//input[@name='lastname']", "Smith");
        util.send_keys_xpath("//input[@name='reg_email__']","5555555");
        util.send_keys_xpath("//input[@name='reg_passwd__']", "123456789");

        //fill form open-registration day, month, year (class FacebookFormRegisterBirtday)
        reg.select_item_value_day("name", "birthday_day", "26");
        int month = reg.select_item_value_month("name", "birthday_month", "ene");
        reg.assert_month("name","birthday_month",month);
        int year = reg.select_item_value_year("name", "birthday_year", "1980");
        reg.assert_year("name","birthday_year",year);

    }

    @AfterMethod
    public void cerrarDriver(){
        test.driver_close(driver);
    }
}
