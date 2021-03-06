package Hook.BeforeAfterDriver;

import Hook.Utilities;
import PageObject.Netflix.NetflixHome;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DriverNetflix {

        public WebDriver driver;
        public Utilities util;
        public NetflixHome netflixHomePage;


    @Test(groups = {"sucessTests","failTests"})

        @BeforeMethod
        public void setup(){
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            driver = new ChromeDriver();
            driver.get("https://www.netflix.com");
            netflixHomePage = new NetflixHome(driver);
            util = new Utilities(driver);
            util.maximize_window();
        }

        @AfterMethod
        public void cerrarDriver(){
            driver.quit();
        }
    }
