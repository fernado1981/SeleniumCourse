package factory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookForms {

    WebDriver driver;

    public FacebookForms(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void fillingRegistrationForm(){
        driver.findElement(By.name("firstname")).sendKeys("Paul");
        driver.findElement(By.name("lastname")).sendKeys("Roger");
        driver.findElement(By.name("reg_email__")).sendKeys("testing@qa.com");
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("testing@qa.com");
        driver.findElement(By.id("password_step_input")).sendKeys("holamundo123");
        driver.findElement(By.xpath("//input[@name='sex'][@value=2]")).click();
    }

    public void fillingRegistrationForm(String name, String lastName, String email, String confirmation, String pass){
        if (name.isEmpty()){
            driver.findElement(By.name("firstname")).sendKeys("notdefined");
        } else {
            driver.findElement(By.name("firstname")).sendKeys(name);
        }
        driver.findElement(By.name("lastname")).sendKeys(lastName);
        driver.findElement(By.name("reg_email__")).sendKeys(email);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys(confirmation);
        driver.findElement(By.id("password_step_input")).sendKeys(pass);
        driver.findElement(By.xpath("//input[@name='sex'][@value=2]")).click();
    }
}
