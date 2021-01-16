package clase2;

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

        //home
        home.title_page(true);
        home.forget_passwd();

        //register
        reg.title_page(true);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void forgotAccountPartialLinkTest(){
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

    @Test(priority = 3,groups = {"sucessTests"})
    public void registrationToFacebookTest(){
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
        driver.quit();
    }
}
