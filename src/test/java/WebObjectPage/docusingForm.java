package WebObjectPage;

import hook.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class docusingForm {

    WebDriver driver;
    WebDriverWait wait;
    Utilities util;


    String cookies_xpath="//button[@class='optanon-allow-all accept-cookies-button']";
    String firstname_xpath="//input[@name='first_name']";
    String lastname_xpath="//input[@name='last_name']";
    String email_xpath="//input[@name='email']";
    String phone_xpath="//input[@name='phone']";
    String title_job_xpath = "//input[@name='title']";
    String ds_industry_xpath = "//select[@name='ds_industry']";
    String ds_industry_css_selector = "//select[name='ds_industry']";
    String ds_industry_name = "ds_industry";


    public docusingForm(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void accept_cookies(){
        util.click_element_xpath(cookies_xpath);
    }

    public void fill_firstname(String value){
        util.send_keys_xpath(firstname_xpath, value);
    }

    public void fill_lastname(String value){
        util.send_keys_xpath(lastname_xpath, value);
    }

    public void fill_email(String value){
        util.send_keys_xpath(email_xpath, value);
    }

    public void fill_phone(String value){
        util.send_keys_xpath(phone_xpath, value);
    }

    public void fill_title_job(String value){
        util.send_keys_xpath(title_job_xpath, value);
    }

    public void fill_ds_industry(String tag, String option_value){
        if (tag.equalsIgnoreCase("name")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(ds_industry_name)));
            values_month.sendKeys(option_value);
        } else if (tag.equalsIgnoreCase("xpath")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ds_industry_xpath)));
            values_month.sendKeys(option_value);
        }else if (tag.equalsIgnoreCase("css_selector")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(ds_industry_css_selector)));
            values_month.sendKeys(option_value);
        }
    }

}
