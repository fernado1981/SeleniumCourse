package clase15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DocusignTest {


    WebDriver driver;

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.docusign.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void docusignTest(){
        Assert.assertEquals(driver.getTitle(), "DocuSign | #1 in Electronic Signature and Agreement Cloud");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.docusign.com/");

        driver.findElement(By.xpath("//*[@href='https://go.docusign.com/o/trial']")).click();
        Assert.assertEquals(driver.getTitle(),"DocuSign Free Trial");
        Assert.assertEquals(driver.getCurrentUrl(),"https://go.docusign.com/o/trial/");

        driver.findElement(By.name("first_name")).sendKeys("Brianne");
        driver.findElement(By.name("last_name")).sendKeys("Eastburn");
        driver.findElement(By.name("email")).sendKeys("test@test.com");

        //driver.findElement(By.xpath("//*[@title='close']")).click();
        driver.findElement(By.id("submitMainText_0")).click();

    }

    @Test
    public void docusignCopyTest(){
        DocusignLandingPage docusignLandingPage = new DocusignLandingPage(driver);
        // Camion c1 = new Camion("Rojo");

        Assert.assertEquals(docusignLandingPage.getTitle(), "DocuSign | #1 in Electronic Signature and Agreement Cloud");
        Assert.assertEquals(docusignLandingPage.getUrl(), "https://www.docusign.com/");
        DocusignRegistrationPage docusignRegistrationPage = docusignLandingPage.clickFreeTrialBtn();

        Assert.assertEquals(docusignRegistrationPage.getTitle(),"DocuSign Free Trial");
        Assert.assertEquals(docusignRegistrationPage.getUrl(),"https://go.docusign.com/o/trial/");

        docusignRegistrationPage.fillingRegistrationFields();
        docusignRegistrationPage.clickOnGetStartedBtn();

        /*driver.findElement(By.name("first_name")).sendKeys("Brianne");
        driver.findElement(By.name("last_name")).sendKeys("Eastburn");
        driver.findElement(By.name("email")).sendKeys("test@test.com");
*/
        //driver.findElement(By.xpath("//*[@title='close']")).click();
        //driver.findElement(By.id("submitMainText_0")).click();

    }





}
