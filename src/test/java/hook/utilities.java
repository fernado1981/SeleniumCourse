package hook;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public void send_keys_name(String name, String input_text){
        driver.findElement(By.name(name)).sendKeys(input_text);
    }

    public void send_keys_id(String tag_id, String input_text){
        driver.findElement(By.id(tag_id)).sendKeys(input_text);
    }

    public void send_keys_xpath(String xpath, String input_text){
        driver.findElement(By.xpath(xpath)).sendKeys(input_text);
    }

    public void refresh(){
        driver.navigate().refresh();
    }

    public void click_element_xpath(String xpath){
        driver.findElement(By.xpath(xpath)).click();
    }

    public void click_element_link_text(String text){
        driver.findElement(By.linkText(text)).click();
    }

    public void click_element_partial_link_text(String text){
        driver.findElement(By.partialLinkText(text)).click();
    }

    public void click_element_id(String text){
        driver.findElement(By.id(text)).click();
    }

    public void click_name(String text){
        driver.findElement(By.name(text)).click();

    }

    public List<WebElement> find_tag_name(String tag) {
        List<WebElement> listas = driver.findElements(By.tagName(tag));
        System.out.println("****** " + tag + "********");
        return listas;
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

    public void selectItemValue_day_month(String tag_id,String option_value){

        WebElement elemento = driver.findElement(By.id(tag_id));
        Select combo = new Select(elemento);
        combo.selectByVisibleText(option_value);
        if (tag_id.equalsIgnoreCase("day")) {
            WebElement values = driver.findElement(By.id(tag_id));
            Assert.assertEquals(option_value, values.getAttribute("value"));
        }else{
            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("ene", 1);
            map.put("feb", 2);
            map.put("mar", 3);
            map.put("abr", 4);
            map.put("may", 5);
            map.put("jun", 6);
            map.put("jul", 7);
            map.put("ago", 8);
            map.put("sep", 9);
            map.put("oct", 10);
            map.put("nov", 11);
            map.put("dic", 12);

            int mes = map.get("ago");
            WebElement values = driver.findElement(By.id(tag_id));
            int mes_value = Integer.parseInt(values.getAttribute("value"));
            Assert.assertEquals(mes, mes_value);
        }

    }
}