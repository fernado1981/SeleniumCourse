<a name='top'></a>
[Principal](../README.md)

# TESTNG:
TestNG es un herramienta de automatización que se inspira en JUnit y sus anotaciones (@)

### Testng POM
      <!-- https://mvnrepository.com/artifact/org.testng/testng -->
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.3.0</version>
            <scope>test</scope>
        </dependency>

### Anotaciones:
    @BeforeSuite
       @BeforeTest
          @BeforeClass
            @BeforeMethod
            @Test
            @AfterMethod
            @BeforeMethod
            @Test
            @AfterMethod
          @AfterClass
      @AfterTest
    @AfterSuite

**Ejemplo**

    public WebDriver driver;
    
    @BeforeMethod
    public void setBaseUrl(){
      setProperty("webdriver.chrome.driver", "driver/chromedriver");
      driver = new ChromeDriver();
      driver.get("http://www.google.es");
      util.maximize_window();
    }

    @Test
    public void verifyGoogleTitle(){
      String expectedtitle = 'Google';
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle,expectedtitle);
    }

    @AfterMethod
    public void closeDriver(){
    driver.closed();
    }

package clase12;

import org.testng.annotations.*;

public class testng {

    import org.testng.annotations.*;
    
    public class testng {

    @BeforeClass
    public void beforeClass(){
        System.out.println("--> Before Class");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");

    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("--> se va a ejecutar un test...");
    }

    @Test
    @Parameters({"username"})
    public void firstTest(@Optional("selenium@testing.com") String user){
        System.out.println("----> este es el primer test!!" );
        System.out.println("----> usuario: " + user );
    }

    @Test
    public void secondTest(){
        System.out.println("----> este es el segundo test!!");
    }

    @AfterMethod
    public void afterMethodTest(){
        System.out.println("---> After Method");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("--> After Test");
    }

    @BeforeSuite
    public void beforeSuiteTest(){
        System.out.println("-> Before Suite !!");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("-> After class");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("After suite");
    }}

### @Test(Priority=0)

Priority es un parámetro.</br>
Requiere que se le asigne un valor numérico para indicarle el orden de ejecución de los test.

![TestngPriority](images/TestngPriority.png)

### Testng.xml
Permite ejecutar uno o más test y/o classes al mismo tiempo:
        
        <suite name='casetestng'>
            <test name='testngcase1'>
                <classes>
                    <class name='case1.clase1'></class>
                </classes>
            </test>
        </suite>

### @Parameters:
Permite enviar parámetros a los tests.</br>
Se define un parámetro llamado tagName y su valor es 'a'

**Ejemplo**

    <parameter name='tagName' value='a'>
    <Parameter name="base_url" value="http://www.google.es">

Nota: Esta variable puede ser vista desde la clase de test</br>

**@optional**, En caso de correr el tests directamente sin ir al runner, el valor que se encuentre en el parámetro @optional será el manejado por el método!

    @Test
    @Parameters({'specifyTag})
    public void openUrl(@Option('http://www.google.uk') String base_url){
        driver.get(base_url);
    }

**@Test(groups)**

        <suite name='test suites testng' verbose='1'>
            <parameter name='base_url' value='http://www.google.es'/>
                <test name='all test'>
                    <groups>
                        <run>
                            <include name='succesTest'/>
                            <include name='failTest'/>
                        </run>
                    </gropus>
                </test>
        </suite>

Se pueden agrupar los tests. De esta forma, podemos elegir desde el runner.xml cuales deseamos correr o cuales no.

    @Test(groups = {'successTest','failTest'})
    
    @Test(groups = {'failTest'})
    public void failTest(){
    }
    
    @Test(groups = {'succesTest'})
    public void failTest(){
    }

[Subir](#top)