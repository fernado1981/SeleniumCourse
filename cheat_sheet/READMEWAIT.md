<a name='top'></a>
[Principal](../README.md)

# Waits:
¿Qué pasa cuando nuestros tests se ejecutan más rápido que el sitio?

NoSuchElementException

¿cómo evitar eso?
disponemos de dos tipos de esperas, implicitas y explicitas, además del sleep.

### Tipos de esperas:
1. Tread.sleep</br>
2. Implicit waits</br>
3. Explicit wait

##Tread.sleep(X):

Són esperas provistas por java, causando una suspension del test en milisegundos, esta puede lanzar una excepcion.

    #espera de 5 segundos
    Thread.sleep(5000)

    @test
    public void threadTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver.get("https://go.docusign.com/o/trial/");
        Thread.sleep(5000);
        driver.findElement(By.partialLinkTest('forgot')).click();
    }

**Nota:** estas esperas debemos tratar de evitarlas siempre, dado que estas hacen que aumente el 
tiempo de ejecución de los test, para ello están las esperas explícitas e implícitas que nos ayudan 
a resolver este problema.

###Wait implícito:

El wait implícito le dice al driver que espera una fracción de tiempo determinada ante de arrojar la excepcion

    driver.manage().timeouts().implicitlyWait(1000, timeunit.MILISECONDS);
    driver.manage().timeouts().implicitlyWait(10, timeunit.SECONDS);

La espera aplica a todos los elementos que se trate de localizar, usualmente se coloca en el setUp, o en la clase utilities encargada de los métodos de busca de Selenium:

###Wait explícitos:
Se indica al driver que espere a que se cumplan ciertas condiciones(Expected Conditions), y si las condiciones no aparecen por un periodo de tiempo,
se lanza la excepción de "ElementNoVisibleException".

En contra al Wait implícito este es un wait inteligente, ya que espera a que un elemento sea cargado dinámicamente, así cuando este este presente
el flujo del test continua., por lo que es mucho mejor este wait que el implícito.

* La espera es hasta que aparezca el elemento en el sitio
* Una vez que el elemento aparece, el test sigue su flujo normal.
* Si el elemento ya se encuentra presente, entonces la espera es 0 segundos

**forma de uso:**
se debe ejecutar una instancia del objeto WebDriverWait

    WebDriverWait wait=new WebDriverWait(driver, 10);
    wait.until(ExpectedConditions.elementToBeClickable(By.id('username)));

**EJEMPLO:**

    public class Utilities {

    WebDriver driver;
    WebDriverWait wait;

    public Utilities(WebDriver remoteDriver) {
        driver = remoteDriver;
        wait = new WebDriverWait(driver, 10);
    }
    ... Métodos ...
    }

**Métodos de ExpectedConditions:**
* elementToBeClickable()
* elementToBeSelected()
* textToBePresentInElement()
* textToBePresentInElementLocated()
* titleIs()
* titleContains()
* visibilityOf()
* visibilityOfElementLocated()

[Subir](#top)