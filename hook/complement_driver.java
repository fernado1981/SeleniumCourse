package hook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class complement_driver {

    public WebDriver Driver(String URL, String navigator){
        if (navigator.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get(URL);
            return driver;
        }else{
            System.setProperty("webdriver.firefox.driver", "driver/geckodriver");
            WebDriver driver = new FirefoxDriver();
            driver.get(URL);
            return driver;
            }
    }

    public void driver_close(WebDriver driver){
        driver.quit();
    }
}
