package clase3;

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
    }

}
