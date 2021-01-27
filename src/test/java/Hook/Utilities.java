package Hook;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;


public class Utilities {


    WebDriver driver;
    WebDriverWait wait;

    public Utilities(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
    }

    public void maximize_window() { driver.manage().window().maximize(); }
    public void refresh(){ driver.navigate().refresh(); }

    //get title & current_url
    public void get_title(String title, boolean igual) {
        if(igual) {
            Assert.assertEquals(title, driver.getTitle());
        }else{
            Assert.assertNotEquals(title, driver.getTitle());
        }
    }

    public void get_current_url(String url, boolean igual) {
        if(igual) {
            Assert.assertEquals(url, driver.getCurrentUrl());
        }else{
            Assert.assertNotEquals(url, driver.getCurrentUrl());
        }
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

    public void send_keys_xpath(String tag_xpath, String input_text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tag_xpath)));
        driver.findElement(By.xpath(tag_xpath)).sendKeys(input_text);
    }
    public void send_keys_css_selector(String tag_css_selector, String input_text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(tag_css_selector)));
        driver.findElement(By.cssSelector(tag_css_selector)).sendKeys(input_text);
    }

    //click (xpath,lint_text,partial_linkt_text,id,name)
    public void click_element_xpath(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(text)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(text))));
        driver.findElement(By.xpath(text)).click();
    }

    public void click_element_link_text(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(text)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.linkText(text))));
        driver.findElement(By.linkText(text)).click();
    }

    public void click_element_partial_link_text(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText(text)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.partialLinkText(text))));
        driver.findElement(By.partialLinkText(text)).click();
    }

    public void click_element_id(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(text)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id(text))));
        driver.findElement(By.id(text)).click();
    }

    public void click_name(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name(text)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name(text))));
        driver.findElement(By.name(text)).click();
    }

    public void click_css_selector(String text){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(text)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(text))));
        driver.findElement(By.cssSelector(text)).click();
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

    public void print_listas(List<WebElement> listas, String tag){
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


    public void find_total_msg_error_xpath(String xpath){
        int totalMsgError = 0;

        totalMsgError = driver.findElements(By.xpath(xpath)).size();
        if(totalMsgError == 9){
            Assert.assertEquals(totalMsgError,9);
        }
    }

    public String find_erromsg_xpath(String tagxpath){
        WebElement error = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tagxpath)));
        return error.getText();
    }



}
