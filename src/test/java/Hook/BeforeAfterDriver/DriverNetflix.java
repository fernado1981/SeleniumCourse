package Hook.BeforeAfterDriver;

import Hook.Utilities;
import PageObject.Netflix.netflixHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DriverNetflix {

        public WebDriver driver;
        public Utilities util;
        public netflixHomePage NetflixHome;


    @Test(groups = {"sucessTests","failTests"})

        @BeforeMethod
        public void setup(){
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.netflix.com");
            NetflixHome =new netflixHomePage(driver);
            util = new Utilities(driver);
            util.maximize_window();
        }

        @AfterMethod
        public void cerrarDriver(){
            driver.quit();
        }
    }
