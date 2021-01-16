package clase1;

import WebObjectPage.FacebookHomePage;
import hook.ComplementDriver;
import hook.Utilities;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.List;

public class PrimerTest {

    WebDriver driver;
    ComplementDriver test = new ComplementDriver();

    @Before
    public WebDriver getDriver(String URL){
        driver = test.Driver(URL, "chrome");
        return driver;
    }

    @Test(priority = 0,groups = {"sucessTests"})
    public void testing(){
        WebDriver driver = getDriver("https://www.facebook.com");
        FacebookHomePage home =new FacebookHomePage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();
        //cookie
        home.accept_cookies();
        home.title_page(true);

        util.get_current_url("https://www.facebook.com/",true);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void spotifyTest(){
        WebDriver driver = getDriver("https://www.spotify.com");
        Utilities util = new Utilities(driver);
        util.maximize_window();
        util.get_title("Escuchar lo es todo - Spotify", true);
        util.get_current_url("https://www.spotify.com/es/", true);
        List<WebElement> listas_h1 = util.find_tag_name("h1");
        util.print_listas(listas_h1,"h1");
        List<WebElement> listas_h2 = util.find_tag_name("h2");
        util.print_listas(listas_h2,"h2");
        List<WebElement> listas_p = util.find_tag_name("p");
        util.print_listas(listas_p,"p");

    }

    @Test(priority = 2,groups = {"sucessTests"})
    public void mostrarSpotifyLinks(){
        WebDriver driver = getDriver("https://www.spotify.com");
        Utilities util = new Utilities(driver);
        util.maximize_window();
        util.get_title("Escuchar lo es todo - Spotify", true);
        util.get_current_url("https://www.spotify.com/es/", true);
        List<WebElement>Listas_a = util.find_tag_name("a");
        util.print_listas(Listas_a,"a");

    }


    @Test(priority = 3,groups = {"sucessTests"})
    public void getTitleTest(){
        WebDriver driver = getDriver("https://www.google.es");
        Utilities util = new Utilities(driver);
        util.maximize_window();
        util.get_title("Google", true);
        util.send_keys_name("q","que es selenium?");
        util.refresh();

    }

    @AfterMethod
    public void cerrarDriver(){
        test.driver_close(driver);
    }
}
