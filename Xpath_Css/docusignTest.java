package Xpath_Css;

import WebObjectPage.DocusingForm;
import hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DocusignTest {

    public WebDriver driver;

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://go.docusign.com/o/trial/");
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void completeDocusignRegistrationForm(){
        DocusingForm Docusing = new DocusingForm(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        Docusing.accept_cookies();

        //formulario
        Docusing.fill_firstname("pepe");
        Docusing.fill_lastname("perez");
        Docusing.fill_email("pepe@pepe.com");
        Docusing.fill_phone("654897237");
        Docusing.fill_title_job("fontanero");
        Docusing.fill_ds_industry("name","Other");

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void defaultxPath(){
        DocusingForm Docusing = new DocusingForm(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        Docusing.accept_cookies();

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
