package Hook.BeforeAfterDriver;

import Hook.Utilities;
import PageObject.Facebook.facebookHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DriverFacebook {
    public WebDriver driver;
    public Utilities util;
    public facebookHomePage FacebookHome;


    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        FacebookHome =new facebookHomePage(driver);
        FacebookHome.accept_cookies();
        util = new Utilities(driver);
        util.maximize_window();
    }

    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
