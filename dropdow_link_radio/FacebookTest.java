package dropdow_link_radio;

import WebObjectPage.FacebookHomePage;
import WebObjectPage.FacebookFormRegister;
import hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookTest {

    public WebDriver driver;

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void forgotAccountTest(){
        Utilities util = new Utilities(driver);
        FacebookHomePage home =new FacebookHomePage(driver);
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        home.forget_passwd();
        reg.title_page(true);

        util.get_current_url("https://www.facebook.com/", false);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void forgotAccountPartialLinkTest(){
        Utilities util = new Utilities(driver);
        FacebookHomePage home =new FacebookHomePage(driver);
        FacebookFormRegister reg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        home.accept_cookies();

        home.forget_passwd_partial_link_text("¿Has olvidado");
        reg.title_page(true);
    }

    @Test(priority = 3,groups = {"sucessTests"})
    public void checkBoxAndComboboxTest(){
        Utilities util = new Utilities(driver);
        FacebookHomePage home =new FacebookHomePage(driver);
        FacebookFormRegister reg = new FacebookFormRegister(driver);
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
        Utilities util = new Utilities(driver);
        FacebookHomePage home =new FacebookHomePage(driver);
        FacebookFormRegister reg = new FacebookFormRegister(driver);
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
        Utilities util = new Utilities(driver);
        FacebookHomePage home =new FacebookHomePage(driver);
        FacebookFormRegister reg = new FacebookFormRegister(driver);
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
        Utilities util = new Utilities(driver);
        FacebookHomePage home =new FacebookHomePage(driver);
        FacebookFormRegister reg = new FacebookFormRegister(driver);
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
    public void registrationFacebookTest(){
        Utilities util = new Utilities(driver);
        FacebookHomePage home =new FacebookHomePage(driver);
        FacebookFormRegister reg = new FacebookFormRegister(driver);
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
        driver.quit();
    }
}
