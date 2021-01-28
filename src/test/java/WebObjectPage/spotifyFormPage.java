package WebObjectPage;

import Hook.Utilities;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class spotifyFormPage {

    WebDriver driver;
    WebDriverWait wait;
    Utilities util;

    String cookies_xpath="//*[contains(text(), 'Aceptar Cookies')]";
    String email_name = "email";
    String placeholder_email="//input[@placeholder='Pon tu correo electrónico.']";
    String placeholder_repit_email="//input[@placeholder='Vuelve a poner tu correo electrónico.']";
    String placeholder_passwd="//input[@placeholder='Crea una contraseña.']";
    String placeholder_displayname="//input[@placeholder='Pon un nombre de perfil.']";
    String css_selector_email="input[id='email']";
    String css_selector_confirm_email="input[id='confirm']";
    String css_selector_passwd="input[id='password']";
    String css_selector_displayname="input[id='displayname']";
    String email_name_confirm ="confirm";
    String email_msg_error = "//*[contains(text(),'Este correo electrónico no es válido.')]";
    String email_msn_error_duplicate="//*[contains(text(),'Este correo electrónico ya está conectado')]";
    String email_msn_error_not_equals ="//*[contains(text(),'Las direcciones de correo electrónico no coinciden.')]";
    String total_msn_erro="//*[@aria-label='Indicador de error']";
    String passwd_xpath="//input[@id='password']";
    String password_name="password";
    String submit_xpath="//button[@type='submit']";
    String displayname = "displayname";

    String css_selector_day="input[id='day']";
    String css_selector_month="select[id='month']";
    String css_selector_year="input[id='year']";
    String xpath_day="input[@id='day']";
    String xpath_month="select[@id='month']";
    String xpath_year="input[@id='year']";
    String id_day="day";
    String id_month="month";
    String id_year="year";

    String gender_sex_h ="//*[contains(text(),'Hombre')]";
    String accept_term="//*[contains(text(),'Compartir mis datos de')]";
    String url="https://www.spotify.com/es/signup/";


    public spotifyFormPage(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void accept_cookies(){
        util.click_element_xpath(cookies_xpath);
    }
    public void get_url(boolean value){
        util.get_current_url(url, value);
    }

    public void email_name(String email) {
        util.send_keys_name(email_name, email);
    }
    public void confirm_email_name(String email) {
        util.send_keys_name(email_name_confirm, email);
    }

    public void text_email_error(String text_expected) {
        util.get_text_xpath_email_error(email_msg_error, text_expected);
    }

    public void text_email_error_duplicate(String text_expected) {
        util.get_text_xpath_email_error(email_msn_error_duplicate, text_expected);
    }

    public void text_email_error_not_equal(String text_expected) {
        util.get_text_xpath_email_error(email_msn_error_not_equals, text_expected);
    }

    public void password_click(){
        util.click_element_xpath(passwd_xpath);
    }

    public void password_send_key(String value){
        util.send_keys_name(password_name,value);
    }

    public void submit(){
        util.click_element_xpath(submit_xpath);
    }

    public void total_msg_error_xpath() {
        util.find_total_msg_error_xpath(total_msn_erro);
    }

    public void display_name(String value){
        util.send_keys_name(displayname,value);
    }

    public void email_css_selector(String value) {
        util.send_keys_css_selector(css_selector_email, value);
    }
    public void confirm_email_css_selector(String value) {
        util.send_keys_css_selector(css_selector_confirm_email, value);
    }

    public void password_css_selector(String value){
        util.send_keys_css_selector(css_selector_passwd,value);
    }
    public void display_name_css_selector(String value){
        util.send_keys_css_selector(css_selector_displayname,value);
    }

    public void gender_sex() {
        util.click_element_xpath(gender_sex_h);
    }

    public void accept_terms() {
        util.click_element_xpath(accept_term);
    }

    public void email_placeholder(String value){
        util.send_keys_xpath(placeholder_email, value);
    }

    public void confirm_email_placeholder(String value){
        util.send_keys_xpath(placeholder_repit_email,value);
    }

    public void password_placeholder(String value){
        util.send_keys_xpath(placeholder_passwd,value);
    }
    public void displayname_placeholder(String value){
        util.send_keys_xpath(placeholder_displayname, value);
    }

    //fill form open-registration day,month,year
    public void select_item_value_day(String tag,String option_value_dia){
        if(tag.equalsIgnoreCase("id")) {
            WebElement values_dia = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id_day)));
            values_dia.sendKeys(option_value_dia);

            Assert.assertEquals(option_value_dia, values_dia.getAttribute("value"));
        }else if(tag.equalsIgnoreCase("xpath")){
            WebElement values_dia = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_day)));
            values_dia.sendKeys(option_value_dia);

            Assert.assertEquals(option_value_dia, values_dia.getAttribute("value"));
        } else if(tag.equalsIgnoreCase("css_selector")){
            WebElement values_dia = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css_selector_day)));
            values_dia.sendKeys(option_value_dia);

            Assert.assertEquals(option_value_dia, values_dia.getAttribute("value"));
        }
    }

    public int select_item_value_month(String tag, String option_value_mes) {
        if (tag.equalsIgnoreCase("id")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id_month)));
            values_month.sendKeys(option_value_mes);
        } else if (tag.equalsIgnoreCase("xpath")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_month)));
            values_month.sendKeys(option_value_mes);
        }else if (tag.equalsIgnoreCase("css_selector")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css_selector_month)));
            values_month.sendKeys(option_value_mes);
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("Enero", 1);
        map.put("Febrero", 2);
        map.put("Marzo", 3);
        map.put("Abril", 4);
        map.put("Mayo", 5);
        map.put("Junio", 6);
        map.put("Julio", 7);
        map.put("Agosto", 8);
        map.put("Septiembre", 9);
        map.put("Octubre", 10);
        map.put("Noviembre", 11);
        map.put("Diciembre", 12);

        int mes = map.get(option_value_mes);
        return mes;
    }

    public void assert_month(String tag,int mes) {
        if (tag.equalsIgnoreCase("id")) {
            WebElement valuesmonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id_day)));
            int valuemonth = Integer.parseInt(valuesmonth.getAttribute("value"));

            Assert.assertEquals(mes, valuemonth);
        } else if (tag.equalsIgnoreCase("xpath")) {
            WebElement valuesmonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_day)));
            int valuemonth = Integer.parseInt(valuesmonth.getAttribute("value"));

            Assert.assertEquals(mes, valuemonth);
        } else if (tag.equalsIgnoreCase("css_selector")) {
            WebElement valuesmonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css_selector_month)));
            int valuemonth = Integer.parseInt(valuesmonth.getAttribute("value"));

            Assert.assertEquals(mes, valuemonth);
        }
    }

    public int select_item_value_year(String tag, String option_value_year) {
        if(tag.equalsIgnoreCase("id")) {
            WebElement values_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id_year)));
            values_year.sendKeys(option_value_year);
        }else if(tag.equalsIgnoreCase("xpath")){
            WebElement values_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_year)));
            values_year.sendKeys(option_value_year);
        }else if(tag.equalsIgnoreCase("css_selector")){
            WebElement values_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css_selector_year)));
            values_year.sendKeys(option_value_year);
        }

        Map<String, Integer> map_year = new HashMap<String, Integer>();
        map_year.put("2021", 2021);
        map_year.put("2020", 2020);
        map_year.put("2019", 2019);
        map_year.put("2018", 2018);
        map_year.put("2017", 2017);
        map_year.put("2016", 2016);
        map_year.put("2015", 2015);
        map_year.put("2014", 2014);
        map_year.put("2013", 2013);
        map_year.put("2012", 2012);
        map_year.put("2011", 2011);
        map_year.put("2010", 2010);
        map_year.put("1999", 1999);
        map_year.put("1998", 1998);
        map_year.put("1997", 1997);
        map_year.put("1996", 1996);
        map_year.put("1995", 1995);
        map_year.put("1994", 1994);
        map_year.put("1993", 1993);
        map_year.put("1992", 1992);
        map_year.put("1991", 1991);
        map_year.put("1990", 1990);
        map_year.put("1989", 1989);
        map_year.put("1988", 1988);
        map_year.put("1987", 1987);
        map_year.put("1986", 1986);
        map_year.put("1985", 1985);
        map_year.put("1984", 1984);
        map_year.put("1983", 1983);
        map_year.put("1982", 1982);
        map_year.put("1981", 1981);
        map_year.put("1980", 1980);

        int year = map_year.get(option_value_year);
        return year;
    }

    public void assert_year(String tag,int year){
        if(tag.equalsIgnoreCase("id")){
            WebElement valuesyear = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id_year)));
            int valueyear = Integer.parseInt(valuesyear.getAttribute("value"));
            Assert.assertEquals(year, valueyear);
        }else if(tag.equalsIgnoreCase("xpath")){
            WebElement valuesyear = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath_year)));
            int valueyear = Integer.parseInt(valuesyear.getAttribute("value"));
            Assert.assertEquals(year, valueyear);
        }else if(tag.equalsIgnoreCase("css_selector")){
            WebElement valuesyear = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(css_selector_year)));
            int valueyear = Integer.parseInt(valuesyear.getAttribute("value"));
            Assert.assertEquals(year, valueyear);
        }
    }
}
