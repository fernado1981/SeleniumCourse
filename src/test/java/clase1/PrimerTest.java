package clase1;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class PrimerTest {

    @Before
    public WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    public void testing(){
        WebDriver driver = getDriver("https://www.facebook.com");
        driver.manage().window().maximize();

        System.out.println("El titulo del sitio es " + driver.getTitle());
        System.out.println("La url del sitio es " + driver.getCurrentUrl());
        closeDriver(driver);

    }

    @Test
    public void spotifyTest(){
        WebDriver driver = getDriver("https://www.spotify.com");

        System.out.println("El titulo del sitio es " + driver.getTitle());
        System.out.println("La url del sitio es " + driver.getCurrentUrl());

        List<WebElement> listaDeH1s = driver.findElements(By.tagName("h1"));
        System.out.println("Se encontraron " + listaDeH1s.size() + " elementos");

        for (WebElement elemento : listaDeH1s){
            System.out.println("H1 -> " + elemento.getText());
        }


        List<WebElement> listaDeH2s = driver.findElements(By.tagName("h2"));
        System.out.println("Se encontraron " + listaDeH2s.size() + " elementos");

        for (WebElement elemento : listaDeH2s){
            System.out.println("H2 -> " + elemento.getText());
        }

        List<WebElement> listaParrafos = driver.findElements(By.tagName("p"));
        System.out.println("****** PARRAFOS ********");

        for (WebElement listaParrafo : listaParrafos) {
            if (!listaParrafo.getText().isEmpty()) {
                System.out.println("Parrafo: " + listaParrafo.getText());
            }
        }
        closeDriver(driver);
    }

    @Test
    public void mostrarSpotifyLinks(){
        WebDriver driver = getDriver("https://www.spotify.com");
        List<WebElement> listaLinks = driver.findElements(By.tagName("a"));
        System.out.println("Existen " + listaLinks.size() + " links");

        for (WebElement element : listaLinks){
            if (!element.getText().isEmpty()) {
                System.out.println("Link: " + element.getText());
            }
        }
        System.out.println("Se imprimiran solo 3 links: ");
        for (int i = 0; i < 3; i++){
            System.out.println(listaLinks.get(i).getText());
        }
        closeDriver(driver);
    }


    @Test
    public void getTitleTest(){
        WebDriver driver = getDriver("https://www.google.com");
        String googleTitle = driver.getTitle();

        if (googleTitle.equals("Google")){
            System.out.println("Test Passed!!!");
        } else {
            System.out.println("Test failed!!!");
        }
        driver.findElement(By.name("q")).sendKeys("que es selenium?");
        driver.navigate().refresh();
        closeDriver(driver);
    }

    @After
    public void closeDriver(WebDriver driver){
        driver.close();
    }
}
