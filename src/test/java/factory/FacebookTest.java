package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FacebookTest {

    public WebDriver driver;
    String fName = "";
    String fLastName ="";
    String fEmail = "";
    String fConfirmation = "";
    String fPass = "";

    public FacebookTest(String name, String lastName, String email, String confirmation, String pass){
        fName = name;
        fLastName = lastName;
        fEmail = email;
        fConfirmation = confirmation;
        fPass = pass;
    }

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void registrationTest() throws InterruptedException {
        DriverUtilities driverUtility = new DriverUtilities(driver);
        FacebookForms forms = new FacebookForms(driver);

        System.out.println("Titulo --> " + driverUtility.getTitle());

        driverUtility.clickBtn("//a[@ajaxify='/reg/spotlight/']");
        //driverUtility.sleep();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleIs("Facebook Registration"));

        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("firstname"))));
        //wait.until(ExpectedConditions.textToBePresentInElement());

        forms.fillingRegistrationForm(fName, fLastName, fEmail, fConfirmation, fPass);
        driverUtility.clickBtn("//*[@name='websubmit']");

        //driver.findElement(By.xpath("//a[@ajaxify='/reg/spotlight/']")).click();
        //Thread.sleep(3000);

        /*driver.findElement(By.name("firstname")).sendKeys("Paul");
        driver.findElement(By.name("lastname")).sendKeys("Roger");
        driver.findElement(By.name("reg_email__")).sendKeys("testing@qa.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("testing@qa.com");
        driver.findElement(By.id("password_step_input")).sendKeys("holamundo123");
        driver.findElement(By.xpath("//input[@name='sex'][@value=2]")).click();
        */

        //driver.findElement(By.name("websubmit")).click();
    }

    @Test
    public void registionTestFail(){
        System.out.println("---> " + fName);
        System.out.println("---> " + fPass);
        System.out.println("---> " + fConfirmation);
    }

    @AfterMethod
    public void closeDriver(){
        //driver.close();
    }


}
