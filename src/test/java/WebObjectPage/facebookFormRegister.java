package WebObjectPage;

import hook.Utilities;
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

public class facebookFormRegister {

    WebDriver driver;
    WebDriverWait wait;
    Utilities util;

    //xpath
    String birthday_day_xpath = "//select[@name='birthday_day']";
    String birthday_month_xpath = "//select[@name='birthday_month']";
    String birthday_year_xpath = "//select[@name='birthday_year']";
    String name_xpath="//input[@name='firstname']";
    String lastname_xpath ="//input[@name='lastname']";
    String email_xpath="//input[@name='reg_email__']";
    String passwd_xpath="//input[@name='reg_passwd__']";
    String sex_V_xpath="//input[@name='sex' and @value='2']";
    String sex_H_xpath="//input[@name='sex' and @value='1']";
    String birthday_day_name = "birthday_day";
    String birthday_month_name = "birthday_month";
    String birthday_year_name = "birthday_year";
    //id
    String birthday_day_id = "day";
    String birthday_month_id = "month";
    String birthday_year_id = "year";
    //cssSelector
    String birthday_day_css_selector = "//select[name='birthday_day']";
    String birthday_month_xpath_css_selector = "//select[name='birthday_month']";
    String birthday_year_xpath_css_selector = "//select[name='birthday_year']";
    String url="https://www.facebook.com/login/";
    String title = "¿Has olvidado la contraseña? | No puedo entrar | Facebook";



    public facebookFormRegister(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void title_page(boolean equal){
        util.get_title(title, equal);
    }

    public void get_url(boolean value){
        util.get_current_url(url, value);
    }

    public void fill_name_lastname_xpath(String name,String Lastname){
        util.send_keys_xpath(name_xpath, name);
        util.send_keys_xpath(lastname_xpath, Lastname);
    }

    public void email_password_xpath(String email, String password){
        util.send_keys_xpath(email_xpath, email);
        util.send_keys_xpath(passwd_xpath, password);
    }

    public void click_sex(String sex) {
        if(sex.equalsIgnoreCase("V")) {
            util.click_element_xpath(sex_V_xpath);
        }else if(sex.equalsIgnoreCase("H")){
            util.click_element_xpath(sex_H_xpath);
        }
    }

    //fill form open-registration day,month,year
    public void select_item_value_day(String tag,String option_value_dia){
        if(tag.equalsIgnoreCase("id")) {
            WebElement values_dia = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(birthday_day_id)));
            Select combo_dia = new Select(values_dia);
            combo_dia.selectByVisibleText(option_value_dia);

            Assert.assertEquals(option_value_dia, values_dia.getAttribute("value"));
        }else if(tag.equalsIgnoreCase("xpath")){
            WebElement values_dia = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(birthday_day_xpath)));
            Select combo_dia = new Select(values_dia);
            combo_dia.selectByVisibleText(option_value_dia);

            Assert.assertEquals(option_value_dia, values_dia.getAttribute("value"));
        }else if(tag.equalsIgnoreCase("name")){
            WebElement values_dia = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(birthday_day_name)));
            Select combo_dia = new Select(values_dia);
            combo_dia.selectByVisibleText(option_value_dia);

            Assert.assertEquals(option_value_dia, values_dia.getAttribute("value"));
        }
        else if(tag.equalsIgnoreCase("css_selector")){
            WebElement values_dia = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(birthday_day_css_selector)));
            Select combo_dia = new Select(values_dia);
            combo_dia.selectByVisibleText(option_value_dia);

            Assert.assertEquals(option_value_dia, values_dia.getAttribute("value"));
        }
    }

    public int select_item_value_month(String tag, String option_value_mes) {
        if (tag.equalsIgnoreCase("id")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(birthday_month_id)));
            Select combo_mes = new Select(values_month);
            combo_mes.selectByVisibleText(option_value_mes);
        } else if (tag.equalsIgnoreCase("xpath")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(birthday_month_xpath)));
            Select combo_mes = new Select(values_month);
            combo_mes.selectByVisibleText(option_value_mes);
        } else if (tag.equalsIgnoreCase("name")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(birthday_month_name)));
            Select combo_mes = new Select(values_month);
            combo_mes.selectByVisibleText(option_value_mes);
        }else if (tag.equalsIgnoreCase("css_selector")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(birthday_month_xpath_css_selector)));
            Select combo_mes = new Select(values_month);
            combo_mes.selectByVisibleText(option_value_mes);
        }
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

        int mes = map.get(option_value_mes);
        return mes;
    }

    public void assert_month(String tag,int mes) {
        if (tag.equalsIgnoreCase("id")) {
            WebElement valuesmonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(birthday_month_id)));
            int valuemonth = Integer.parseInt(valuesmonth.getAttribute("value"));

            Assert.assertEquals(mes, valuemonth);
        } else if (tag.equalsIgnoreCase("xpath")) {
            WebElement valuesmonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(birthday_month_xpath)));
            int valuemonth = Integer.parseInt(valuesmonth.getAttribute("value"));

            Assert.assertEquals(mes, valuemonth);
        } else if (tag.equalsIgnoreCase("name")) {
            WebElement valuesmonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(birthday_month_name)));
            int valuemonth = Integer.parseInt(valuesmonth.getAttribute("value"));

            Assert.assertEquals(mes, valuemonth);
        } else if (tag.equalsIgnoreCase("css_selector")) {
            WebElement valuesmonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(birthday_month_xpath_css_selector)));
            int valuemonth = Integer.parseInt(valuesmonth.getAttribute("value"));

            Assert.assertEquals(mes, valuemonth);
        }
    }

    public int select_item_value_year(String tag, String option_value_year) {
        if(tag.equalsIgnoreCase("id")) {
            WebElement values_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(birthday_year_id)));
            Select combo_year = new Select(values_year);
            combo_year.selectByVisibleText(option_value_year);
        }else if(tag.equalsIgnoreCase("xpath")){
            WebElement values_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(birthday_year_xpath)));
            Select combo_year = new Select(values_year);
            combo_year.selectByVisibleText(option_value_year);
        }else if(tag.equalsIgnoreCase("name")){
            WebElement values_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(birthday_year_name)));
            Select combo_year = new Select(values_year);
            combo_year.selectByVisibleText(option_value_year);
        }else if(tag.equalsIgnoreCase("css_selector")){
            WebElement values_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(birthday_year_xpath_css_selector)));
            Select combo_year = new Select(values_year);
            combo_year.selectByVisibleText(option_value_year);
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
            WebElement valuesyear = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(birthday_year_id)));
            int valueyear = Integer.parseInt(valuesyear.getAttribute("value"));
            Assert.assertEquals(year, valueyear);
        }else if(tag.equalsIgnoreCase("xpath")){
            WebElement valuesyear = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(birthday_year_xpath)));
            int valueyear = Integer.parseInt(valuesyear.getAttribute("value"));
            Assert.assertEquals(year, valueyear);
        }else if(tag.equalsIgnoreCase("name")){
            WebElement valuesyear = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(birthday_year_name)));
            int valueyear = Integer.parseInt(valuesyear.getAttribute("value"));
            Assert.assertEquals(year, valueyear);
        }else if(tag.equalsIgnoreCase("css_selector")){
            WebElement valuesyear = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(birthday_year_xpath_css_selector)));
            int valueyear = Integer.parseInt(valuesyear.getAttribute("value"));
            Assert.assertEquals(year, valueyear);
        }
    }

    public void assert_combo_size_by_name(String name){
        WebElement meses = driver.findElement(By.name(name));
        Select combo = new Select(meses);

        List<WebElement> options=combo.getOptions();
        Assert.assertNotEquals(0, options.size());

        boolean search = false;
        for (WebElement opt:options){
            System.out.println(opt.getText());
            if(opt.getText().contentEquals("ene")){
                search=true;
                break;
            }
        }
        Assert.assertTrue(search);
    }
}
