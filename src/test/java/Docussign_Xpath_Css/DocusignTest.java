package Docussign_Xpath_Css;

import WebObjectPage.DocusingForm;
import hook.Utilities;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocusignTest {

    public WebDriver driver;
    public DocusingForm Docusing;
    public Utilities util;

    public static Faker faker = new Faker();

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://go.docusign.com/o/trial/");
        Docusing = new DocusingForm(driver);
        Docusing.accept_cookies();
        util = new Utilities(driver);
        util.maximize_window();
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void completeDocusignRegistrationForm(){
        //formulario
        Docusing.fill_firstname("pepe");
        Docusing.fill_lastname("perez");
        Docusing.fill_email("pepe@pepe.com");
        Docusing.fill_phone("654897237");
        Docusing.fill_title_job("fontanero");
        Docusing.fill_ds_industry("name","Other");

    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void completeDocusignRegistrationFormFake(){
        //formulario
        String name=faker.name().firstName();
        Docusing.fill_firstname(name);

        String lastname=faker.name().lastName();
        Docusing.fill_lastname(lastname);

        String mail = faker.internet().emailAddress();
        Docusing.fill_email(mail);

        String phone=faker.phoneNumber().cellPhone();
        Docusing.fill_phone(phone);

        String job = faker.job().title();
        Docusing.fill_title_job(job);
        Docusing.fill_ds_industry("name","Other");

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void defaultxPath(){
        //formulario
        Docusing.fill_firstname("pepe");
        Docusing.fill_lastname("perez");
        Docusing.fill_email("pepe@pepe.com");
        Docusing.fill_phone("654897237");
        Docusing.fill_title_job("fontanero");
        Docusing.fill_ds_industry("xpath","Education");

    }


    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
