package hook;
import org.openqa.selenium.WebDriver;

public class ComplementDriver {

    WebDriver driver;

    public ComplementDriver(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public void driver_close(WebDriver driver){
        driver.quit();
    }
}
