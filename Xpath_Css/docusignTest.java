package Xpath_Css;

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
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//button[@class='optanon-allow-all accept-cookies-button']");

        //formulario
        util.send_keys_xpath("//input[@name='first_name']", "pepe");
        util.send_keys_xpath("//input[@name='last_name']", "pepe");
        util.send_keys_xpath("//input[@name='email']", "pepe@pepe.com");
        util.send_keys_xpath("//input[@name='phone']", "654897237");
        util.send_keys_xpath("//input[@name='title']", "fontanero");
        util.send_keys_xpath("//select[@name='ds_industry']", "//option[@value='Other']");

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void defaultxPath(){
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //cookie
        util.click_element_xpath("//button[@class='optanon-allow-all accept-cookies-button']");

        //formulario
        util.send_keys_xpath("//*[@id='dsFormLabel_First_Name']/input","pepe");
        util.send_keys_xpath("//*[@id='dsFormLabel_First_Name']/input","pepe");
        util.send_keys_xpath("//*[@id='dsFormLabel_Email']/input","pepe@pepe.com");
        util.send_keys_xpath("//*[@id='dsFormLabel_Phone']/input","654897237");
        util.send_keys_xpath("//*[@id='dsFormLabel_Job_Title']/input","fontanero");
        util.click_element_xpath("//*[@id='dsFormLabel_Industry']/select/option[21]");

    }


    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
