package Hook;

import PageObject.Spotify.spotifyHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DriverSpotify {

    public WebDriver driver;
    public spotifyHomePage SpotifyHome;
    public Utilities util;


    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
        SpotifyHome =  new spotifyHomePage(driver);
        util = new Utilities(driver);
        util.maximize_window();
    }

    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
