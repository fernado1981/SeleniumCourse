package Hook.BeforeAfterDriver;

import Hook.Utilities;
import PageObject.Docussing.docusingTrialFormPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class DriverDocussing_parallel {

    public WebDriver driver;
    public docusingTrialFormPage Docusing;
    public Utilities util;

    @BeforeMethod
    @Parameters({"browser"})
    public void setup(@Optional("Chrome") String browser) {
        if (browser.equalsIgnoreCase("Firefox")) {
            System.setProperty("webdriver.chrome.driver", "driver/firefox_88/geckodriver");
            driver = new FirefoxDriver();
            driver.get("https://go.docusign.com/o/trial/");
            Docusing = new docusingTrialFormPage(driver);
            Docusing.accept_cookies();
            util = new Utilities(driver);
            util.maximize_window();
        } else if (browser.equalsIgnoreCase("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://go.docusign.com/o/trial/");
            Docusing = new docusingTrialFormPage(driver);
            Docusing.accept_cookies();
            util = new Utilities(driver);
            util.maximize_window();
        }
    }

    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
