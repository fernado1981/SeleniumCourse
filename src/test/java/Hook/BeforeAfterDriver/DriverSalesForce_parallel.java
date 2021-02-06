package Hook.BeforeAfterDriver;

import Hook.Utilities;
import PageObject.SalesForce.salesForceLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class DriverSalesForce_parallel {

    public WebDriver driver;
    public salesForceLoginPage SalesForceLogin;
    public Utilities util;

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    @Parameters({"browser"})
    public void setup(@Optional("Chrome") String browser) {
        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.chrome.driver", "driver/firefox_88/geckodriver");
            driver = new FirefoxDriver();
            driver.get("https://login.salesforce.com/");
            SalesForceLogin = new salesForceLoginPage(driver);
            util = new Utilities(driver);
            util.maximize_window();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://login.salesforce.com/");
            SalesForceLogin = new salesForceLoginPage(driver);
            util = new Utilities(driver);
            util.maximize_window();
        }
    }

    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
