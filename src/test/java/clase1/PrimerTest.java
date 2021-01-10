package clase1;

import hook.complement_driver;
import hook.utilities;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import java.util.List;

public class PrimerTest {

    WebDriver driver;
    complement_driver test = new complement_driver();

    @Before
    public WebDriver getDriver(String URL){
        driver = test.Driver(URL, "chrome");
        return driver;
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void testing(){
        WebDriver driver = getDriver("https://www.facebook.com");
        utilities util = new utilities(driver);
        util.maximize_window();
        util.get_title("Facebook - Entrar o registrarse");
        util.get_current_url("https://www.facebook.com/");

        closeDriver(driver);
    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void spotifyTest(){
        WebDriver driver = getDriver("https://www.spotify.com");
        utilities util = new utilities(driver);
        util.maximize_window();
        util.get_title("Escuchar lo es todo - Spotify");
        util.get_current_url("https://www.spotify.com/es/");
        List<WebElement> listas_h1 = util.find_tag_name("h1");
        util.print_listas(listas_h1,"h1");
        List<WebElement> listas_h2 = util.find_tag_name("h2");
        util.print_listas(listas_h2,"h2");
        List<WebElement> listas_p = util.find_tag_name("p");
        util.print_listas(listas_p,"p");

        closeDriver(driver);
    }

    @Test(priority = 2,groups = {"sucessTests"})
    public void mostrarSpotifyLinks(){
        WebDriver driver = getDriver("https://www.spotify.com");
        utilities util = new utilities(driver);
        util.maximize_window();
        util.get_title("Escuchar lo es todo - Spotify");
        util.get_current_url("https://www.spotify.com/es/");
        List<WebElement>Listas_a = util.find_tag_name("a");
        util.print_listas(Listas_a,"a");

        closeDriver(driver);
    }


    @Test(priority = 3,groups = {"sucessTests"})
    public void getTitleTest(){
        WebDriver driver = getDriver("https://www.google.es");
        utilities util = new utilities(driver);
        util.maximize_window();
        util.get_title("Google");
        util.send_keys("q","que es selenium?");
        util.refresh();

        closeDriver(driver);
    }

    @After
    public void closeDriver(WebDriver driver){
        test.driver_close(driver);

    }
}
