package Hook.BeforeAfterDriver;

import Hook.Utilities;
import PageObject.SalesForce.salesForceLoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DriverSalesForce {

    public WebDriver driver;
    public salesForceLoginPage SalesForceLogin;
    public Utilities util;

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        SalesForceLogin = new salesForceLoginPage(driver);
        util = new Utilities(driver);
        util.maximize_window();
    }

    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
