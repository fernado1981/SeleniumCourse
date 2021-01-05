package clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testSalesforce {

    public WebDriver driver;
    public static final String SALEFORCE_URL= "https://login.salesforce.com/";
    public static final String SALEFORCE_URL_eu= "https://login.salesforce.com/?locale=eu";
    private String url;

    @Test(groups = {"sucessTests","failTests"})

    @BeforeMethod
    public void setup(){
        this.url = SALEFORCE_URL;
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @Test(priority = 0, groups = {"sucessTests"})
    public void validateSalesforceLogoTest(){
        WebElement logo = driver.findElement(By.id("logo"));
        String tagName = logo.getTagName();
        Assert.assertEquals("img", tagName);
        String attr = logo.getAttribute("alt");
        Assert.assertEquals("Salesforce", attr);
    }

    @Test(priority = 4, enabled=false, groups = {"failTests"})
    public void remenberMelsSelected(){
        driver.get(SALEFORCE_URL_eu);
        String urlactual=driver.getCurrentUrl();
        Assert.assertEquals("https://login.salesforce.com/?locale=eu",urlactual);
        WebElement remenber= driver.findElement(By.xpath("//input[@id='rememberUn']"));
        remenber.click();
        Assert.assertTrue(remenber.isSelected());
}
    @Test(priority = 2, groups = {"succesTests"})
    public void FooterIsValid(){
       WebElement footerText = driver.findElement(By.xpath("//*[contains(text(),'Reservados todos los derechos')]"));
       Assert.assertEquals(footerText.getText(),"© 2021 salesforce.com, inc. Reservados todos los derechos. | Privacidad");
       Assert.assertTrue(footerText.getText().contains("Reservados todos los derechos"));
    }
    @Test(priority = 3, groups = {"succesTests"})
    public void LoginFailureTest() throws InterruptedException {
        driver.get(SALEFORCE_URL_eu);
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("123466");
        driver.findElement(By.xpath("//input[@id='Login']")).click();
        Thread.sleep(3000);
        String testError = driver.findElement(By.xpath("//div[@id='error']")).getText();
        Assert.assertEquals(testError,"Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.");
    }

    @AfterMethod
    public void cerrarDriver(){
        driver.close();
    }
}
