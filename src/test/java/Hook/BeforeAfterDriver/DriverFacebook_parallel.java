package Hook.BeforeAfterDriver;

import Hook.Utilities;
import PageObject.Facebook.facebookHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class DriverFacebook_parallel {
    public WebDriver driver;
    public Utilities util;
    public facebookHomePage FacebookHome;


    @Test(groups = {"sucessTests","failTests"})

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(@Optional("Chrome") String browser) {
        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.chrome.driver", "driver/firefox_88/geckodriver");
            driver = new FirefoxDriver();
            driver.get("https://www.facebook.com/");
            FacebookHome =new facebookHomePage(driver);
            FacebookHome.accept_cookies();
            util = new Utilities(driver);
            util.maximize_window();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.facebook.com/");
            FacebookHome =new facebookHomePage(driver);
            FacebookHome.accept_cookies();
            util = new Utilities(driver);
            util.maximize_window();
        }
    }

    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
