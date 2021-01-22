package DataProviderTest;

import hook.DataFactory;
import hook.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class fillFormWithFakersTest {
    String firstname = DataFactory.getFirstname();
    String lastname = DataFactory.getLasttname();
    String email = DataFactory.getEmail();
    String phone = DataFactory.getPhone();

    public WebDriver driver;

    @Test
    public void fillFormWithFakers(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/?locale=eu");

        Utilities util = new Utilities(driver);
        util.maximize_window();
        util.click_element_id("signup_link");

        util.click_element_xpath("//button[@title='Accept Cookies Button']");

        util.send_keys_name("UserFirstName",firstname);
        util.send_keys_name("UserLastName",lastname);
        util.send_keys_name("UserEmail",email);
        util.send_keys_name("UserPhone",phone);
        util.send_keys_name("CompanyName","ORT");
        util.click_name("Start my free trial");

        String error = util.find_erromsg_xpath("//span[contains(text(),'Please read and agree to the Master Subscription Agreement')]");
        Assert.assertEquals(error,"Please read and agree to the Master Subscription Agreement");

    }

}
