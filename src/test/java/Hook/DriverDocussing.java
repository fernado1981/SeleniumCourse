package Hook;

import PageObject.Docussing.docusingTrialFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class DriverDocussing {

    public WebDriver driver;
    public docusingTrialFormPage Docusing;
    public Utilities util;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://go.docusign.com/o/trial/");
        Docusing = new docusingTrialFormPage(driver);
        Docusing.accept_cookies();
        util = new Utilities(driver);
        util.maximize_window();
    }

    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
