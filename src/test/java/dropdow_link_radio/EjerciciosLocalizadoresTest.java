package dropdow_link_radio;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

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
    public void forgotAccountTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        Thread.sleep(6000);

        //cookie
        WebElement Acept_cookie = driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']"));
        Acept_cookie.click();

        WebElement forget_pass = driver.findElement(By.linkText("¿Has olvidado la contraseña?"));
        forget_pass.click();

        String title = driver.getTitle();
        Assert.assertEquals("¿Has olvidado la contraseña? | No puedo entrar | Facebook", title);
        Assert.assertNotEquals("https://www.facebook.com/", driver.getCurrentUrl());

        closeDriver(driver);
    }

    @Test
    public void forgotAccountPartialLinkTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        Thread.sleep(6000);

        //cookie
        WebElement Acept_cookie = driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']"));
        Acept_cookie.click();

        WebElement forget_pass = driver.findElement(By.partialLinkText("¿Has olvidado"));
        forget_pass.click();

        String title = driver.getTitle();
        Assert.assertEquals("¿Has olvidado la contraseña? | No puedo entrar | Facebook", title);

        closeDriver(driver);
    }

    @Test
    public void customSalesforceLink() throws InterruptedException {
        WebDriver driver = getDriver("https://login.salesforce.com/");
        Thread.sleep(5000);

        WebElement Custom_domain = driver.findElement(By.linkText("Utilizar dominio personalizado"));
        Custom_domain.click();

        WebElement custom_domain_complet = driver.findElement(By.xpath("//input[@id='mydomain']"));
        custom_domain_complet.sendKeys("as");

        WebElement continue_btn = driver.findElement(By.xpath("//button[normalize-space()='Continuar']"));
        continue_btn.click();

        //no veo el campo email :(

        closeDriver(driver);
    }

    @Test
    public void checkBoxAndComboboxTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        Thread.sleep(6000);

        //cookie
        WebElement Acept_cookie = driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']"));
        Acept_cookie.click();

        WebElement new_count = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        new_count.click();

        Thread.sleep(6000);

        WebElement firstname= driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys("Alan");

        WebElement lastname= driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("Smith");

        WebElement birthday_day= driver.findElement(By.xpath("//select[@name='birthday_day']"));
        birthday_day.findElement(By.xpath("//option[@value='4']")).click();

        WebElement birthday_month= driver.findElement(By.xpath("//select[@name='birthday_month']"));
        birthday_month.findElement(By.xpath("//option[@value='4']")).click();

        WebElement birthday_year= driver.findElement(By.xpath("//select[@name='birthday_year']"));
        birthday_year.findElement(By.xpath("//option[@value='2012']")).click();

        WebElement sex= driver.findElement(By.xpath("//input[@name='sex']"));
        sex.click();

        closeDriver(driver);
    }

    @Test
    public void birthdateTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        Thread.sleep(6000);

        //cookie
        WebElement Acept_cookie = driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']"));
        Acept_cookie.click();

        WebElement new_count = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        new_count.click();

        Thread.sleep(6000);

        WebElement birthday_day= driver.findElement(By.xpath("//select[@name='birthday_day']"));
        birthday_day.findElement(By.xpath("//option[@value='20']")).click();


        WebElement birthday_month= driver.findElement(By.xpath("//select[@name='birthday_month']"));
        birthday_month.findElement(By.xpath("//option[@value='12']")).click();


        WebElement birthday_year= driver.findElement(By.xpath("//select[@name='birthday_year']"));
        birthday_year.findElement(By.xpath("//option[@value='1990']")).click();


        closeDriver(driver);
    }

    @Test
    public void comboboxTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        Thread.sleep(5000);

        //cookie
        WebElement Acept_cookie = driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']"));
        Acept_cookie.click();

        WebElement new_count = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        new_count.click();

        Thread.sleep(6000);

        WebElement meses = driver.findElement(By.name("birthday_month"));
        Select combo = new Select(meses);

        List<WebElement> options=combo.getOptions();
        Assert.assertNotEquals(0, options.size());

        boolean search = false;

        for (WebElement opt:options){
            System.out.println(opt.getText());
            if(opt.getText().contentEquals("ene"))   {
                search=true;
                break;
            }
        }

        Assert.assertTrue(search);
        closeDriver(driver);
    }

    @Test
    public  void completeRegistration() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        Thread.sleep(5000);

        //cookie
        WebElement Acept_cookie = driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']"));
        Acept_cookie.click();

        WebElement new_count = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        new_count.click();

        Thread.sleep(6000);

        WebElement firstname= driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys("Alan");

        WebElement lastname= driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("Smith");

        WebElement email= driver.findElement(By.xpath("//input[@name='reg_email__']"));
        email.sendKeys("Alan@alan.com");

        WebElement pass= driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        pass.sendKeys("Smith");


        setBirthdate(driver,"31","mar","1981");
    }
    public void setBirthdate(WebDriver driver, String day, String month, String year){
        WebElement birthday_day= driver.findElement(By.name("birthday_day"));
        Select comboDay = new Select(birthday_day);
        comboDay.selectByVisibleText(day);

        WebElement birthday_month= driver.findElement(By.name("birthday_month"));
        Select comboMonth = new Select(birthday_month);
        comboMonth.selectByVisibleText(month);

        WebElement birthday_year= driver.findElement(By.name("birthday_year"));
        Select comboYear = new Select(birthday_year);
        comboYear.selectByVisibleText(year);

        closeDriver(driver);

    }

    @Test
    public void registrationFacebookTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com/");
        Thread.sleep(5000);

        //cookie
        WebElement Acept_cookie = driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']"));
        Acept_cookie.click();

        WebElement new_count = driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
        new_count.click();

        Thread.sleep(6000);

        WebElement firstname= driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys("Alan");

        WebElement lastname= driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("Smith");

        WebElement mobile= driver.findElement(By.xpath("//input[@name='reg_email__']"));
        mobile.sendKeys("5555555");

        WebElement pass= driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        pass.sendKeys("123456789");

        WebElement birthday_day= driver.findElement(By.name("birthday_day"));
        Select comboDay = new Select(birthday_day);
        comboDay.selectByVisibleText("26");

        WebElement birthday_month= driver.findElement(By.name("birthday_month"));
        Select comboMonth = new Select(birthday_month);
        comboMonth.selectByVisibleText("ene");

        WebElement birthday_year= driver.findElement(By.name("birthday_year"));
        Select comboYear = new Select(birthday_year);
        comboYear.selectByVisibleText("1980");

        closeDriver(driver);

    }

    @After
    public void closeDriver(WebDriver driver){
        driver.close();
    }
}
