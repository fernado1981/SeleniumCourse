package clase12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testngSpotify {

    public WebDriver driver;

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
    }

    @Test (priority = 0)
    public void verifySpotifyTitle(){
        System.out.println("Title -> "+ driver.getTitle());
        String title = driver.getTitle();
        Assert.assertEquals(title, "Escuchar es todo - Spotify");
    }

    @Test (priority = 2)
    public void verifySignupUrl(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("signup"));
    }

    @Test (priority = 3)
    public void invalidEmailTest(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.name("email")).sendKeys("test.com");

        driver.findElement(By.id("confirm")).sendKeys("test.com");
        WebElement emailErrMsg = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico no es válido.')]"));
        Assert.assertEquals(emailErrMsg.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com" );
        Assert.assertTrue(emailErrMsg.getText().contains("ejemplo@email.com"));
        Assert.assertFalse(emailErrMsg.getText().contains("Congratulations!!"));
    }

    @Test (priority = 1)
    public void validateExistingEmail() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/uy/signup/']")).click();
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.id("confirm")).sendKeys("test@test.com");

        Thread.sleep(3000);
        WebElement emailErrMsg = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico ya')]"));
        Assert.assertEquals(emailErrMsg.getText(),"Este correo electrónico ya está conectado a una cuenta. Inicia sesión." );
    }

    @AfterMethod
    public void cerrarDriver(){
        driver.close();
    }
}
