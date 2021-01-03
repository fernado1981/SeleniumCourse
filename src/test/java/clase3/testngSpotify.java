package clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class testngSpotify {

    public WebDriver driver;
    public static final String SALEFORCE_URL= "https://login.salesforce.com/";

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
    }

    @Test (priority = 0)
    public void verifySpotifyTitle(){
        System.out.println("Title -> "+ driver.getTitle());
        String title = driver.getTitle();
        Assert.assertEquals(title, "Escuchar lo es todo - Spotify");
    }

    @Test (priority = 1)
    public void verifySignupUrl(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[normalize-space()='Registrarse']")).click();

        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("signup"));
    }

    @Test (priority = 2)
    public void invalidEmailTest(){
        driver.findElement(By.xpath("//a[normalize-space()='Registrarse']")).click();
        driver.findElement(By.name("email")).sendKeys("test.com");

        driver.findElement(By.id("confirm")).sendKeys("test.com");
        WebElement emailErrMsg = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico no es válido.')]"));
        Assert.assertEquals(emailErrMsg.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com" );
        Assert.assertTrue(emailErrMsg.getText().contains("ejemplo@email.com"));
        Assert.assertFalse(emailErrMsg.getText().contains("Congratulations!!"));
    }

    @Test (priority = 3)
    public void validateExistingEmail() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Registrarse']")).click();
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.id("confirm")).sendKeys("test@test.com");

        Thread.sleep(3000);
        WebElement emailErrMsg = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico ya')]"));
        Assert.assertEquals(emailErrMsg.getText(),"Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");
    }

    @Test (priority = 4)
    public void checkEqualEmailsError() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Registrarse']")).click();
        driver.findElement(By.name("email")).sendKeys("test999@test.com");
        driver.findElement(By.id("confirm")).sendKeys("hola@hola.com");
        driver.findElement(By.xpath("//input[@id='password']")).click();

        Thread.sleep(3000);
        WebElement emailErrMsg = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico ya')]"));
        Assert.assertEquals(emailErrMsg.getText(),"Este correo electrónico ya está conectado a una cuenta. Inicia sesión.") ;


        WebElement passErrMsg = driver.findElement(By.xpath("//*[contains(text(),'Las direcciones de correo electrónico no coinciden')]"));
        Assert.assertEquals(passErrMsg.getText(),"Las direcciones de correo electrónico no coinciden.");
    }

    @Test (priority = 5)
    public void checkEqualErrorMessages() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Registrarse']")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        int totalMsgError = 0;
        totalMsgError = driver.findElements(By.xpath("//*[@aria-label='Indicador de error']")).size();
        if(totalMsgError == 9){
            Assert.assertEquals(totalMsgError,9);
        }
    }

    public void estngSalesforce(){


    }

    @AfterMethod
    public void cerrarDriver(){
        driver.close();
    }
}
