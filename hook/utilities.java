package hook;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class utilities {


    WebDriver driver;
    WebDriverWait wait;

    public utilities(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
    }

    public void maximize_window() { driver.manage().window().maximize(); }
    public void refresh(){ driver.navigate().refresh(); }

    //get title & current_url
    public void get_title(String title) {
        Assert.assertEquals(title,driver.getTitle());
    }

    public void get_current_url(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }

    //send_keys (name,id,xpath)
    public void send_keys_name(String name, String input_text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(name)));
        driver.findElement(By.name(name)).sendKeys(input_text);
    }
    public void send_keys_id(String tag_id, String input_text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(tag_id)));
        driver.findElement(By.id(tag_id)).sendKeys(input_text);
    }

    public void send_keys_xpath(String xpath, String input_text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).sendKeys(input_text);
    }

    //click (xpath,lint_text,partial_linkt_text,id,name)
    public void click_element_xpath(String xpath){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(xpath))));
        driver.findElement(By.xpath(xpath)).click();

    }

    public void click_element_link_text(String text){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(text))));
        driver.findElement(By.linkText(text)).click();
    }

    public void click_element_partial_link_text(String text){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.partialLinkText(text))));
        driver.findElement(By.partialLinkText(text)).click();
    }

    public void click_element_id(String text){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(text))));
        driver.findElement(By.id(text)).click();
    }

    public void click_name(String text){
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(text))));
        driver.findElement(By.name(text)).click();
    }

    //get_text xpath
    public void get_text_xpath_email_error(String get_xpath,String text_expected){
        wait.until(ExpectedConditions.textToBe(By.xpath(get_xpath), text_expected));
    }

    //find_id_search_tag
    public void find_id_search_tag(String id_text, String tag_search){
        WebElement logo = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id_text)));
        Assert.assertEquals(tag_search, logo.getTagName());

    }

    public void find_id_search_attribute(String id_text,String attribute_expected, String attribute_search){
        WebElement logo = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id_text)));
        Assert.assertEquals(attribute_expected, logo.getAttribute(attribute_search));
    }

    public void find_xpath_search_text(String xpath_text,String text_expected, String text_contains) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_text)));
        WebElement footerText = driver.findElement(By.xpath(xpath_text));
        if (!text_expected.equals("null")) {
            Assert.assertEquals(footerText.getText(), text_expected);
        }
        if (!text_contains.equals("null")) {
            Assert.assertTrue(footerText.getText().contains(text_contains));
        }
    }
    public List<WebElement> find_tag_name(String tag){
        List<WebElement> listas = driver.findElements(By.tagName(tag));
        System.out.println("****** " + tag + "********");
        return listas;
    }

    public void print_listas(List<WebElement> listas, String tag) throws InterruptedException {
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

    //de la clase2
    public void selectItemValue_day_month(String tag_id,String option_value){

        WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(tag_id)));
        Select combo = new Select(elemento);
        combo.selectByVisibleText(option_value);
        if (tag_id.equalsIgnoreCase("day")) {
            WebElement values = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(tag_id)));
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
            WebElement values = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(tag_id)));
            int mes_value = Integer.parseInt(values.getAttribute("value"));
            Assert.assertEquals(mes, mes_value);
        }
    }

    //de la clase 3
    public void find_total_msg_error_xpath(String xpath){
        int totalMsgError = 0;

        totalMsgError = driver.findElements(By.xpath(xpath)).size();
        if(totalMsgError == 9){
            Assert.assertEquals(totalMsgError,9);
        }

    }
}