package WebObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class FacebookFormRegisterBirtday {

    WebDriver driver;
    WebDriverWait wait;

    public FacebookFormRegisterBirtday(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
    }

    //fill form open-registration day,month,year
    public void select_item_value_day(String tag, String tag_text,String option_value_dia){
        if(tag.equalsIgnoreCase("id")) {
            WebElement values_dia = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(tag_text)));
            Select combo_dia = new Select(values_dia);
            combo_dia.selectByVisibleText(option_value_dia);

            Assert.assertEquals(option_value_dia, values_dia.getAttribute("value"));
        }else if(tag.equalsIgnoreCase("xpath")){
            WebElement values_dia = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(tag_text)));
            Select combo_dia = new Select(values_dia);
            combo_dia.selectByVisibleText(option_value_dia);

            Assert.assertEquals(option_value_dia, values_dia.getAttribute("value"));
        }else if(tag.equalsIgnoreCase("name")){
            WebElement values_dia = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(tag_text)));
            Select combo_dia = new Select(values_dia);
            combo_dia.selectByVisibleText(option_value_dia);

            Assert.assertEquals(option_value_dia, values_dia.getAttribute("value"));
        }
        else if(tag.equalsIgnoreCase("css_selector")){
            WebElement values_dia = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(tag_text)));
            Select combo_dia = new Select(values_dia);
            combo_dia.selectByVisibleText(option_value_dia);

            Assert.assertEquals(option_value_dia, values_dia.getAttribute("value"));
        }
    }

    public int select_item_value_month(String tag, String text_tag_month, String option_value_mes) {
        if (tag.equalsIgnoreCase("id")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(text_tag_month)));
            Select combo_mes = new Select(values_month);
            combo_mes.selectByVisibleText(option_value_mes);
        } else if (tag.equalsIgnoreCase("xpath")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(text_tag_month)));
            Select combo_mes = new Select(values_month);
            combo_mes.selectByVisibleText(option_value_mes);
        } else if (tag.equalsIgnoreCase("name")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(text_tag_month)));
            Select combo_mes = new Select(values_month);
            combo_mes.selectByVisibleText(option_value_mes);
        }else if (tag.equalsIgnoreCase("css_selector")) {
            WebElement values_month = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(text_tag_month)));
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

    public void assert_month(String tag, String text_tag_month,int mes) {
        if (tag.equalsIgnoreCase("id")) {
            WebElement valuesmonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(text_tag_month)));
            int valuemonth = Integer.parseInt(valuesmonth.getAttribute("value"));

            Assert.assertEquals(mes, valuemonth);
        } else if (tag.equalsIgnoreCase("xpath")) {
            WebElement valuesmonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(text_tag_month)));
            int valuemonth = Integer.parseInt(valuesmonth.getAttribute("value"));

            Assert.assertEquals(mes, valuemonth);
        } else if (tag.equalsIgnoreCase("name")) {
            WebElement valuesmonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(text_tag_month)));
            int valuemonth = Integer.parseInt(valuesmonth.getAttribute("value"));

            Assert.assertEquals(mes, valuemonth);
        } else if (tag.equalsIgnoreCase("css_selector")) {
            WebElement valuesmonth = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(text_tag_month)));
            int valuemonth = Integer.parseInt(valuesmonth.getAttribute("value"));

            Assert.assertEquals(mes, valuemonth);
        }
    }

    public int select_item_value_year(String tag, String text_tag_year, String option_value_year) {
        if(tag.equalsIgnoreCase("id")) {
            WebElement values_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(text_tag_year)));
            Select combo_year = new Select(values_year);
            combo_year.selectByVisibleText(option_value_year);
        }else if(tag.equalsIgnoreCase("xpath")){
            WebElement values_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(text_tag_year)));
            Select combo_year = new Select(values_year);
            combo_year.selectByVisibleText(option_value_year);
        }else if(tag.equalsIgnoreCase("name")){
            WebElement values_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(text_tag_year)));
            Select combo_year = new Select(values_year);
            combo_year.selectByVisibleText(option_value_year);
        }else if(tag.equalsIgnoreCase("css_selector")){
            WebElement values_year = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(text_tag_year)));
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

    public void assert_year(String tag, String text_tag_year,int year){
        if(tag.equalsIgnoreCase("id")){
            WebElement valuesyear = wait.until(ExpectedConditions.presenceOfElementLocated(By.id(text_tag_year)));
            int valueyear = Integer.parseInt(valuesyear.getAttribute("value"));
            Assert.assertEquals(year, valueyear);
        }else if(tag.equalsIgnoreCase("xpath")){
            WebElement valuesyear = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(text_tag_year)));
            int valueyear = Integer.parseInt(valuesyear.getAttribute("value"));
            Assert.assertEquals(year, valueyear);
        }else if(tag.equalsIgnoreCase("name")){
            WebElement valuesyear = wait.until(ExpectedConditions.presenceOfElementLocated(By.name(text_tag_year)));
            int valueyear = Integer.parseInt(valuesyear.getAttribute("value"));
            Assert.assertEquals(year, valueyear);
        }else if(tag.equalsIgnoreCase("css_selector")){
            WebElement valuesyear = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(text_tag_year)));
            int valueyear = Integer.parseInt(valuesyear.getAttribute("value"));
            Assert.assertEquals(year, valueyear);
        }
    }
}
