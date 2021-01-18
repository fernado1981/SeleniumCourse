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
        FacebookHomePage FacebookHome =new FacebookHomePage(driver);
        FacebookFormRegister FacebookReg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        FacebookHome.accept_cookies();

        FacebookHome.forget_passwd();
        FacebookReg.title_page(true);
        FacebookReg.get_url(false);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void forgotAccountPartialLinkTest(){
        Utilities util = new Utilities(driver);
        FacebookHomePage FacebookHome =new FacebookHomePage(driver);
        FacebookFormRegister FacebookReg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        FacebookHome.accept_cookies();

        FacebookHome.forget_passwd_partial_link_text("¿Has olvidado");
        FacebookReg.title_page(true);
    }

    @Test(priority = 3,groups = {"sucessTests"})
    public void checkBoxAndComboboxTest(){
        Utilities util = new Utilities(driver);
        FacebookHomePage FacebookHome =new FacebookHomePage(driver);
        FacebookFormRegister FacebookReg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        FacebookHome.accept_cookies();

        //facebookHome open-registration
        FacebookHome.registration();

        //fill form FacebookReg
        FacebookReg.fill_name_lastname_xpath("Alan", "Smith");

        FacebookReg.select_item_value_day("xpath", "4");
        int month = FacebookReg.select_item_value_month("xpath", "abr");
        FacebookReg.assert_month("xpath",month);
        int year = FacebookReg.select_item_value_year("xpath","2012");
        FacebookReg.assert_year("xpath",year);

        FacebookReg.click_sex("H");

    }

    @Test(priority = 4,groups = {"sucessTests"})
    public void birthdateTest() {
        Utilities util = new Utilities(driver);
        FacebookHomePage FacebookHome =new FacebookHomePage(driver);
        FacebookFormRegister FacebookReg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        FacebookHome.accept_cookies();

        //facebookHome
        FacebookHome.registration();

        //fill form facebookReg
        FacebookReg.select_item_value_day("xpath", "20");
        int month = FacebookReg.select_item_value_month("xpath", "dic");
        FacebookReg.assert_month("xpath",month);
        int year = FacebookReg.select_item_value_year("xpath", "1990");
        FacebookReg.assert_year("xpath",year);

    }

    @Test(priority = 5,groups = {"sucessTests"})
    public void comboboxTest(){
        Utilities util = new Utilities(driver);
        FacebookHomePage FacebookHome =new FacebookHomePage(driver);
        FacebookFormRegister FacebookReg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        FacebookHome.accept_cookies();

        //facebookHome
        FacebookHome.registration();

        //fill form facebookReg
        int month = FacebookReg.select_item_value_month("xpath",  "dic");
        FacebookReg.assert_month("xpath",month);

        //assert size
        FacebookReg.assert_combo_size_by_name("birthday_month");

    }

    @Test(priority = 6,groups = {"sucessTests"})
    public  void completeRegistration(){
        Utilities util = new Utilities(driver);
        FacebookHomePage FacebookHome =new FacebookHomePage(driver);
        FacebookFormRegister FacebookReg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        FacebookHome.accept_cookies();

        //facebookHome
        FacebookHome.registration();

        //fill form facebookReg
        FacebookReg.fill_name_lastname_xpath("Alan", "Smith");
        FacebookReg.email_password_xpath("Alan@alan.com", "Smith");

        FacebookReg.select_item_value_day("xpath",  "31");
        int month = FacebookReg.select_item_value_month("xpath",  "mar");
        FacebookReg.assert_month("xpath",month);
        int year = FacebookReg.select_item_value_year("xpath", "1981");
        FacebookReg.assert_year("xpath",year);

    }

    @Test(priority = 7,groups = {"sucessTests"})
    public void registrationFacebookTest(){
        Utilities util = new Utilities(driver);
        FacebookHomePage FacebookHome =new FacebookHomePage(driver);
        FacebookFormRegister FacebookReg = new FacebookFormRegister(driver);
        util.maximize_window();

        //cookie
        FacebookHome.accept_cookies();

        //facebookHome
        FacebookHome.registration();

        //fill form facebookReg
        FacebookReg.fill_name_lastname_xpath("Alan", "Smith");
        FacebookReg.email_password_xpath("5555555", "123456789");

        FacebookReg.select_item_value_day("name",  "26");
        int month = FacebookReg.select_item_value_month("name",  "ene");
        FacebookReg.assert_month("name",month);
        int year = FacebookReg.select_item_value_year("name",  "1980");
        FacebookReg.assert_year("name",year);

    }

    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
