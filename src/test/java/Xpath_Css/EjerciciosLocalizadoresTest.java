package Xpath_Css;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class EjerciciosLocalizadoresTest {

    @Before
    public WebDriver getDriver(String URL) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

        ChromeOptions options=new ChromeOptions();
        options.addArguments("headless");

        ChromeDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    public void completeDocusignRegistrationForm() throws InterruptedException {
        WebDriver driver = getDriver("https://go.docusign.com/o/trial/");
        Thread.sleep(6000);

        //cookie
        WebElement Acept_cookie = driver.findElement(By.xpath("//button[normalize-space()='Aceptar y continuar']"));
        Acept_cookie.click();


        //formulario
        WebElement name =driver.findElement(By.xpath("//input[@name='first_name']"));
        name.sendKeys("pepe");

        WebElement last_name =driver.findElement(By.xpath("//input[@name='last_name']"));
        last_name.sendKeys("pepe");

        WebElement email =driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("pepe@pepe.com");

        WebElement mobile =driver.findElement(By.xpath("//input[@name='phone']"));
        mobile.sendKeys("654897237");

        WebElement job =driver.findElement(By.xpath("//input[@name='title']"));
        job.sendKeys("fontanero");

        WebElement select_industry =driver.findElement(By.xpath("//select[@name='ds_industry']"));
        select_industry.findElement(By.xpath("//option[@value='Other']")).click();

        closeDriver(driver);
    }

    @Test
    public void defaultxPath() throws InterruptedException {
        WebDriver driver = getDriver("https://go.docusign.com/o/trial/");
        Thread.sleep(3000);

        //cookie
        WebElement Acept_cookie = driver.findElement(By.xpath("//button[normalize-space()='Aceptar y continuar']"));
        Acept_cookie.click();

        //este ejercicio no lo puedo hacer dado que tengo instalado el plugin Selectorhub y me deshabilita esas opciones :( https://go.docusign.com/o/trial/
        WebElement name =driver.findElement(By.xpath("//*[@id=\"dsFormLabel_First_Name\"]/input"));
        name.sendKeys("pepe");

        WebElement last_name =driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Last_Name\"]/input"));
        last_name.sendKeys("pepe");

        WebElement email =driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Email\"]/input"));
        email.sendKeys("pepe@pepe.com");

        WebElement mobile =driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Phone\"]/input"));
        mobile.sendKeys("654897237");

        WebElement job =driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Job_Title\"]/input"));
        job.sendKeys("fontanero");

        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Industry\"]/select/option[21]")).click();


        closeDriver(driver);
    }

    @Test
    public void spotifyByNameTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        Thread.sleep(5000);

        WebElement cookie=driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        cookie.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        email.sendKeys("pepe@pepe.com");

        WebElement email_confirm = driver.findElement(By.xpath("//input[@id='confirm']"));
        email_confirm.sendKeys("pepe@pepe.com");

        WebElement pass = driver.findElement(By.xpath("//input[@id='password']"));
        pass.sendKeys("pepito");

        WebElement display_name = driver.findElement(By.xpath("//input[@id='displayname']"));
        display_name.sendKeys("pepin");

        WebElement day = driver.findElement(By.xpath("//input[@id='day']"));
        day.sendKeys("31");

        WebElement select_month = driver.findElement(By.xpath("//select[@id='month']"));
        select_month.findElement(By.xpath("//option[@value='02']")).click();

        WebElement year= driver.findElement(By.xpath("//input[@id='year']"));
        year.sendKeys("1981");

        WebElement radio_sex = driver.findElement(By.xpath("//*[@name='gender'][@value='male']"));
        radio_sex.click();

        WebElement checkbox_data= driver.findElement(By.xpath("//span[@xpath='1']"));
        checkbox_data.click();



        closeDriver(driver);
    }

    @Test
    public void spotifyByPlaceHolder() throws InterruptedException {
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        Thread.sleep(5000);

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Introduce tu correo electónico.']"));
        email.sendKeys("pepe@pepe.com");

        WebElement email_confirm = driver.findElement(By.xpath("//input[@placeholder='Vuelve a introducir tu correo electrónico.']"));
        email_confirm.sendKeys("pepe@pepe.com");

        WebElement pass = driver.findElement(By.xpath("//input[@placeholder='Crea una contraseña.']"));
        pass.sendKeys("pepito");

        WebElement display_name = driver.findElement(By.xpath("//input[@placeholder='Introduce un nombre de perfil.']"));
        display_name.sendKeys("pepin");

        WebElement day = driver.findElement(By.xpath("//input[@placeholder='DD']"));
        day.sendKeys("31");

        WebElement year= driver.findElement(By.xpath("//input[@placeholder='AAAA']"));
        year.sendKeys("1981");

        WebElement radio_sex = driver.findElement(By.xpath("//*[@name='gender'][@value='male']"));
        radio_sex.click();

        WebElement checkbox_data= driver.findElement(By.xpath("//span[@xpath='1']"));
        checkbox_data.click();


        //closeDriver(driver);
    }

    @Test
    public void spotifyByName() throws InterruptedException {
        //css_selector
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        Thread.sleep(5000);

        WebElement email = driver.findElement(By.cssSelector("input[id='email']"));
        email.sendKeys("pepe@pepe.com");

        WebElement email_confirm = driver.findElement(By.cssSelector("input[id='confirm']"));
        email_confirm.sendKeys("pepe@pepe.com");

        WebElement pass = driver.findElement(By.cssSelector("input[id='password']"));
        pass.sendKeys("pepito");

        WebElement display_name = driver.findElement(By.cssSelector("input[id='displayname']"));
        display_name.sendKeys("pepin");

        WebElement day = driver.findElement(By.cssSelector("input[id='day']"));
        day.sendKeys("31");

        WebElement select_month = driver.findElement(By.cssSelector("select[id='month']"));
        select_month.findElement(By.cssSelector("option[value='02']")).click();

        WebElement year= driver.findElement(By.cssSelector("input[id='year']"));
        year.sendKeys("1981");

        WebElement radio_sex = driver.findElement(By.xpath("//*[@name='gender'][@value='male']"));
        radio_sex.click();

        WebElement checkbox_data= driver.findElement(By.xpath("//span[@xpath='1']"));
        checkbox_data.click();

        closeDriver(driver);
    }

    @Test
    public void checkBoxTest() throws InterruptedException {
        // creo que esta url no es correcta dadfo que no hay ningun checkbox Gender :(
        WebDriver driver = getDriver("https://www.facebook.com/");
        Thread.sleep(5000);


        closeDriver(driver);
    }

    @After
    public void closeDriver(WebDriver driver){
        driver.close();
    }
}
