package Facebook;

import WebObjectPage.facebookHomePage;
import WebObjectPage.facebookFormRegisterPage;
import Hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FacebookTest {

    public WebDriver driver;
    public Utilities util;
    public facebookHomePage FacebookHome;
    public facebookFormRegisterPage FacebookReg;

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        FacebookHome =new facebookHomePage(driver);
        FacebookHome.accept_cookies();
        FacebookReg = new facebookFormRegisterPage(driver);
        util = new Utilities(driver);
        util.maximize_window();
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void forgotAccountTest(){
        //FacebookHome
        FacebookHome.title_page(true);
        FacebookHome.forget_passwd();

        //FacebookReg
        FacebookReg.title_page(true);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void forgotAccountPartialLinkTest(){
        //FacebookHome
        FacebookHome.title_page(true);
        FacebookHome.forget_passwd_partial_link_text("olvidado");

        //FacebookReg
        FacebookReg.title_page(true);

    }

    @Test(priority = 3,groups = {"sucessTests"})
    public void registrationToFacebookTest(){
        //FacebookHome
        FacebookHome.create_new_acount();

        //FacebookReg
        FacebookReg.select_item_value_day("id","25");
        int mes = FacebookReg.select_item_value_month("id", "ago");
        FacebookReg.assert_month("id",mes);

    }


    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
