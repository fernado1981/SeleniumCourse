<a name='top'></a>
[Localizadores - Assert](cheat_sheet/READMETOOLSELENIUM.md) | [TestNG](cheat_sheet/READMETESTNG.md)

# Qué es el Testing Automatizado?
El Testing Automatizado es el proceso de automatizar los test manuales para probar una aplicación, Involucrando la creación de scripts que pueden ser ejecutados de forma repetitiva y no requiere ninguna intervención manual.

# Beneficios de Automatizar el testing
1. Ejecución de tests de forma repetitiva
2. Permite la ejecución en paralelo
3. Ejecución automática de los tests
4. Evita “errores humanos” a la hora de testear
5. Permite detectar errores

# Por qué Selenium?
* Es gratis y open-source
* Tiene una gran cantidad de foros y comunidades activas
* Compatibilidad con muchos browsers
* Compatibilidad con Sistemas Operativos (Windows, Mac, Linux, etc)
* Soporta múltiples lenguajes de programación (Java, Ruby, C#,
Python, etc)

# Limitaciones de Selenium
* Solo soporta testing de sólo aplicaciones web
* Las aplicaciones móviles no pueden ser automatizadas
* Los captcha no pueden ser automatizados
* No hay un “soporte” activo por parte de los creadores
* El usuario debe saber programar de antemano

# Primeros pasos con Selenium
1. Descargar los drivers
* https://chromedriver.chromium.org/downloads

#Estructura del proyecto:
* pom.xml, contiene información fundamental sobre el proyecto y su configuración en los proyectos maven.
* Contiene dependencias, variables, etc.
        
        <?xml version="1.0" encoding="UTF-8"?>
        <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
            <modelVersion>4.0.0</modelVersion>
            <groupId>org.example</groupId>
            <artifactId>CursoSelenium</artifactId>
            <version>1.0-SNAPSHOT</version>
            <properties>
                <maven.compiler.source>1.8</maven.compiler.source>
                <maven.compiler.target>1.8</maven.compiler.target>
            </properties>
            <dependencies>
            <!-- https://mvnrepository.com/artifact/org.testng/testng -->
                <dependency>
                    <groupId>org.testng</groupId>
                    <artifactId>testng</artifactId>
                    <version>7.3.0</version>
                    <scope>test</scope>
                </dependency>
    
            <!-- https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java -->
                <dependency>
                    <groupId>org.seleniumhq.selenium</groupId>
                    <artifactId>selenium-java</artifactId>
                    <version>3.141.59</version>
                </dependency>
                <dependency>
                    <groupId>org.testng</groupId>
                    <artifactId>testng</artifactId>
                    <version>7.1.0</version>
                    <scope>test</scope>
                </dependency>
                <dependency>
                    <groupId>junit</groupId>
                    <artifactId>junit</artifactId>
                    <version>4.12</version>
                    <scope>test</scope>
                </dependency>
    
            <!-- https://mvnrepository.com/artifact/com.github.javafaker/javafaker -->
                <dependency>
                    <groupId>com.github.javafaker</groupId>
                    <artifactId>javafaker</artifactId>
                    <version>1.0.2</version>
                </dependency>
            </dependencies>
        </project>


# Dependencias a usar:
Las dependencias se obtiene directamente del repositorio de maven (MVNrepository)
* testng
* selenium java
* junit
* javafaker

# Creación del directorio driver:
    mkdir drivers
**Anadir el driver descargado**

# Creación de primer test en mac y win:
**Mac:**

    WebDriver driver;
    
    @Test
    public void testMac(String URL){
        System.out.println("webdriver.chrome.driver", "drivers/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://www.facvebook.com");
    }

**Win:**

    WebDriver driver;
    
    @Test
    public void testMac(String URL){
        System.out.println("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.facvebook.com");
    }

# Creando instancias de los browser:
* WebDriver driver = new FirefoxDriver(); 
* WebDriver driver = new ChromeDriver(); 
* WebDriver driver = new InternetExplorerDriver();

# Acceder a un una url:
* WebDriver driver = new ChromeDriver();
* String baseURL = "https://www.bbc.com/mundo"; 
* driver.get(baseURL);

# Qué tipos de Drivers están disponibles?
* FirefoxDriver
* InternetExplorerDriver 
* ChromeDriver
* SafariDriver
* OperaDriver

# Métodos del Driver:
* driver.navigate().refresh();
* driver.navigate().back(); 
* driver.navigate().forward(); 
* driver.manage().window().maximize();

# Métodos de Webdrivers:
* int altura = driver.manage().window().getSize().getHeight(); 
* int ancho = driver.manage().window().getSize().getWidth();

# Como se cierra el explorador?
Cuando corremos nuestros tests, el browser queda abierto...
* driver.close(); → cierra el browser actual.
* driver.quit(); → cierra el TODOS los browser

# Encontrar elementos en un sitio web
* driver.findElement(LOCALIZADOR)
Busca el primer elemento que contiene la propiedad y lo retorna 
* Retorno: WebElement
* driver.findElements( LOCALIZADOR )
Busca TODOS los elementos que contienen la propiedad y los retorna en forma de lista
* Retorno: List<'WebElement>

# Métodos de WebElement
* WebElement buttonLogin = driver.findElement(By.tagName("button"));
* buttonLogin.click();
* driver.findElement(By.id("password")).sendKeys("holamundo");

# Métodos de WebElement
* System.out.println(driver.findElement(By.tagName("h3")).getText()); 
* boolean isNameBox= driver.findElement(By.id(“name”)).isDisplayed();

# Métodos de WebElement 
* boolean isTipoProductoSelected =
* driver.findElement(By.id(“tipoProducto”)).isSelected();
* boolean isPromoEnabled = driver.findElement(By.id(“PremiumPromo”)).isEnabled();

# Tipos de Localizadores
* By.id()
* By.name()
* By.tagName()
* By.className()
* By.linkText()
* By.partialLinkText()
* By.xpath()
* By.cssSelector()

[Subir](#top)