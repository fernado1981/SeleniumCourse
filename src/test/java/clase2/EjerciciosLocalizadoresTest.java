package clase2;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EjerciciosLocalizadoresTest {

    @Before
    public WebDriver getDriver(String URL) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }


    @Test
    public void forgotAccountTest() {
        WebDriver driver = getDriver("https://www.facebook.com/");
        //System.out.println("Titulo: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Facebook - Entrar o registrarse");
        WebElement cookie = driver.findElement(By.xpath("//div[@aria-labelledby='cookie_banner_title'] //button[@data-cookiebanner='accept_button']"));
        cookie.click();
        WebElement text =  driver.findElement(By.linkText("¿Has olvidado la contraseña?"));
        text.click();
        //System.out.println("Titulo nuevo : " + driver.getTitle());
        Assert.assertNotEquals(driver.getTitle(), "Facebook - Inicia sesión o regístrate");
        Assert.assertEquals(driver.getTitle(), "¿Has olvidado la contraseña? | No puedo entrar | Facebook");
        closeDriver(driver);
    }

    @Test
    public void forgotAccountPartialLinkTest() {
        WebDriver driver = getDriver("https://www.facebook.com/");
        //System.out.println("Titulo: " + driver.getTitle());
        Assert.assertNotEquals(driver.getTitle(),"Titulo: Facebook - Entrar o registrarse");
        WebElement cookie = driver.findElement(By.xpath("//div[@aria-labelledby='cookie_banner_title'] //button[@data-cookiebanner='accept_button']"));
        cookie.click();
        driver.findElement(By.partialLinkText("olvidado")).click();
        //System.out.println("Titulo nuevo : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"¿Has olvidado la contraseña? | No puedo entrar | Facebook");
        closeDriver(driver);
    }

    @Test
    public void customSalesforceLink() throws InterruptedException {
        WebDriver driver = getDriver("https://login.salesforce.com/");
        //driver.findElement(By.linkText("Use Custom Domain")).click();
        //driver.findElement(By.partialLinkText("Use")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://login.salesforce.com/");

        driver.findElement(By.id("mydomainLink")).click();
        driver.findElement(By.name("mydomain")).sendKeys("as");
        Assert.assertEquals(driver.getCurrentUrl(), "https://login.salesforce.com/");

        driver.findElement(By.name("Continue")).click();
        Thread.sleep(3000);
        Assert.assertEquals(driver.getCurrentUrl(), "https://american-securities.okta.com/app/salesforce/ko9cqogcCYKWOFOXOOSX/sso/saml");

        driver.findElement(By.id("okta-signin-username")).sendKeys("testing@test.com");
        driver.findElement(By.name("password")).sendKeys("holamundo!");
        driver.findElement(By.id("okta-signin-submit")).click();
        closeDriver(driver);
    }


    @Test
    public void registrationToFacebookTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        driver.findElement(By.linkText("Crear cuenta nueva")).click();

        Thread.sleep(3000);

        WebElement elementoDia = driver.findElement(By.id("day"));
        Select comboDias = new Select(elementoDia);
        comboDias.selectByVisibleText("25");

        WebElement elementoMes = driver.findElement(By.id("month"));
        Select comboMeses = new Select(elementoMes);
        comboMeses.selectByVisibleText("ago");
        closeDriver(driver);
    }

    @After
    public void closeDriver(WebDriver driver){
        driver.close();
    }
}
