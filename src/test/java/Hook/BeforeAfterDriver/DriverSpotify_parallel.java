package Hook.BeforeAfterDriver;

import Hook.Utilities;
import PageObject.Spotify.spotifyHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

public class DriverSpotify_parallel {

    public WebDriver driver;
    public spotifyHomePage SpotifyHome;
    public Utilities util;

    @Test(groups = {"sucessTests","failTests"})

    @Parameters({"browser"})
    @BeforeMethod()
    public void setup(@Optional("Chrome") String browser) {
        if (browser.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.chrome.driver", "driver/firefox_88/geckodriver");
                driver = new FirefoxDriver();
                driver.get("https://www.spotify.com");
                SpotifyHome = new spotifyHomePage(driver);
                util = new Utilities(driver);
                util.maximize_window();
                SpotifyHome.accept_cookies();
            } else if (browser.equalsIgnoreCase("Chrome")) {
                System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
                driver = new ChromeDriver();
                driver.get("https://www.spotify.com");
                SpotifyHome = new spotifyHomePage(driver);
                util = new Utilities(driver);
                util.maximize_window();
                SpotifyHome.accept_cookies();
            }
        }

    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
