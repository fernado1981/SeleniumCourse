package clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testSalesforce {

    public WebDriver driver;
    public static final String SALEFORCE_URL= "https://login.salesforce.com/";

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(SALEFORCE_URL);
    }

    @Test(priority = 0)
    public void validateSalesforceLogoTest(){
        WebElement logo = driver.findElement(By.tagName())



    }
}
