package hook;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class utilities {


    WebDriver driver;

    public utilities(WebDriver remoteDriver) {
        driver = remoteDriver;
    }

    public void maximize_window() {
        driver.manage().window().maximize();
    }

    public void get_title(String title) {
        Assert.assertEquals(title,driver.getTitle());
    }

    public void get_current_url(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    public List<WebElement> find_tag_name(String tag) {
        List<WebElement> listas = driver.findElements(By.tagName(tag));
        System.out.println("****** " + tag + "********");
        return listas;
    }

    public void send_keys(String tag, String value){
        driver.findElement(By.name(tag)).sendKeys(value);
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public void print_listas(List<WebElement> listas, String tag) {
        if (tag.equalsIgnoreCase("a")) {
            System.out.println("Se imprimiran solo 3 links: ");
            for (int i = 0; i < 3; i++) {
                System.out.println(listas.get(i).getText());
            }
        } else {
            for (WebElement lista : listas) {
                if (!lista.getText().isEmpty()) {
                    System.out.println(lista.getText());
                }
            }
        }
    }
}