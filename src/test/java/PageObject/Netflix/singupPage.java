package PageObject.Netflix;

import Hook.Utilities;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class singupPage {

    WebDriver driver;
    WebDriverWait wait;
    Utilities util;

    private String MyUrl;

    public singupPage(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
        util = new Utilities(driver);
    }

    public void get_url() throws InterruptedException {
        Thread.sleep(3000);
        MyUrl=util.url();
        int resultado = MyUrl.indexOf("signup");
        Assert.assertTrue("contiene signup",resultado >= 1);
    }
}
