package clase15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DocusignLandingPage {

    public WebDriver driver;

    public DocusignLandingPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public String getUrl(){
        return driver.getCurrentUrl();
    }

    public DocusignRegistrationPage clickFreeTrialBtn(){
        driver.findElement(By.xpath("//*[@href='https://go.docusign.com/o/trial']")).click();
        DocusignRegistrationPage docusignRegistrationPage = new DocusignRegistrationPage(driver);
        return docusignRegistrationPage;
    }

}
