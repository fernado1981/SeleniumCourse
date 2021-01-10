package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DriverUtilities {

    WebDriver driver;

    public DriverUtilities(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void clickBtn(String xpathExpression){
        driver.findElement(By.xpath(xpathExpression)).click();
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(3000);
    }


}
