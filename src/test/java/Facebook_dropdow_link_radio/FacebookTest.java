package Facebook_dropdow_link_radio;

import WebObjectPage.facebookHomePage;
import WebObjectPage.facebookFormRegister;
import com.github.javafaker.Faker;
import hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookTest {

    public WebDriver driver;
    public  Utilities util;
    public facebookHomePage FacebookHome;
    public facebookFormRegister FacebookReg;
    public static Faker faker = new Faker();

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        FacebookHome =new facebookHomePage(driver);
        FacebookReg = new facebookFormRegister(driver);
        FacebookHome.accept_cookies();
        util = new Utilities(driver);
        util.maximize_window();
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void forgotAccountTest(){
        FacebookHome.forget_passwd();
        FacebookReg.title_page(true);
        FacebookReg.get_url(false);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void forgotAccountPartialLinkTest(){
        FacebookHome.forget_passwd_partial_link_text("¿Has olvidado");
        FacebookReg.title_page(true);
    }

    @Test(priority = 3,groups = {"sucessTests"})
    public void checkBoxAndComboboxTest(){
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

    @Test(priority = 3,groups = {"sucessTests"})
    public void checkBoxAndComboboxFakeTest(){
        //facebookHome open-registration
        FacebookHome.registration();

        //fill form FacebookReg
        String name = faker.name().firstName();
        String lastname=faker.name().lastName();
        FacebookReg.fill_name_lastname_xpath(name, lastname);

        FacebookReg.select_item_value_day("xpath", "4");
        int month = FacebookReg.select_item_value_month("xpath", "abr");
        FacebookReg.assert_month("xpath",month);
        int year = FacebookReg.select_item_value_year("xpath","2012");
        FacebookReg.assert_year("xpath",year);

        FacebookReg.click_sex("H");

    }

    @Test(priority = 4,groups = {"sucessTests"})
    public void birthdateTest() {
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

    @Test(priority = 6,groups = {"sucessTests"})
    public  void completeRegistrationFake(){
        //facebookHome
        FacebookHome.registration();

        //fill form facebookReg
        String firstname=faker.name().firstName();
        String lastname = faker.name().lastName();
        FacebookReg.fill_name_lastname_xpath(firstname, lastname);
        String email = faker.internet().emailAddress();
        String pass = faker.internet().password();
        FacebookReg.email_password_xpath(email, pass);

        FacebookReg.select_item_value_day("xpath",  "31");
        int month = FacebookReg.select_item_value_month("xpath",  "mar");
        FacebookReg.assert_month("xpath",month);
        int year = FacebookReg.select_item_value_year("xpath", "1981");
        FacebookReg.assert_year("xpath",year);

    }

    @Test(priority = 7,groups = {"sucessTests"})
    public void registrationFacebookTest(){
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

    @Test(priority = 7,groups = {"sucessTests"})
    public void registrationFacebookFakeTest(){
        //facebookHome
        FacebookHome.registration();
        //fill form facebookReg
        String firstname=faker.name().firstName();
        String lastname = faker.name().lastName();
        FacebookReg.fill_name_lastname_xpath(firstname, lastname);
        String pass = faker.internet().password();
        FacebookReg.email_password_xpath("5555555", pass);

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
