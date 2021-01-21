package clase3;

import WebObjectPage.SalesForceLoginPage;
import WebObjectPage.SalesForceOktaFormPage;
import WebObjectPage.SalesForceUseCustomDomainPage;
import hook.Utilities;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestSalesForce {

    public WebDriver driver;

    public static Faker faker = new Faker();

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
    }

    @Test(priority = 0, groups = {"sucessTests"})
    public void validateSalesforceLogoTest(){
        SalesForceLoginPage SalesForceLogin = new SalesForceLoginPage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //login page
        SalesForceLogin.search_logo_img("img");
        SalesForceLogin.search_logo_img("alt");
    }

    @Test(priority = 1, groups = {"sucessTests"})
    public void remenberMelsSelected(){
        SalesForceLoginPage SalesForceLogin = new SalesForceLoginPage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //login page
        SalesForceLogin.get_url(true);
        SalesForceLogin.remenber();

    }

    @Test(priority = 2, groups = {"sucessTests"})
    public void FooterIsValid(){
        SalesForceLoginPage SalesForceLogin = new SalesForceLoginPage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //login page
        SalesForceLogin.search_text("txtfooter");

    }

    @Test(priority = 3, groups = {"sucessTests"})
    public void LoginFailureTest(){
        SalesForceLoginPage login = new SalesForceLoginPage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //login page
        login.fill_username("test@test.com");
        login.fill_password("123466");
        login.login_btn_tap();
        login.search_text("txtdesactivate");
   }

    @Test(priority = 3, groups = {"sucessTests"})
    public void LoginFailurefakeTest(){
        SalesForceLoginPage login = new SalesForceLoginPage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //login page
        String email=faker.internet().emailAddress();
        login.fill_username(email);
        String pass = faker.internet().domainName();
        login.fill_password(pass);
        login.login_btn_tap();
        login.search_text("txtdesactivatefake");
    }

    @Test(priority = 2,groups = {"sucessTests"})
    public void customSalesforceLinkA(){
        SalesForceLoginPage SalesForceLogin = new SalesForceLoginPage(driver);
        SalesForceUseCustomDomainPage customDomain= new SalesForceUseCustomDomainPage(driver);
        SalesForceOktaFormPage okta = new SalesForceOktaFormPage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //loginpage
        SalesForceLogin.get_url(true);
        SalesForceLogin.use_custom_domain_tap();

        //customDomainPage
        customDomain.get_url(true);
        customDomain.insert_my_domain("as");
        customDomain.continue_btn_tap();

        //oktaformpage
        okta.get_url(true);
        okta.fill_username("testing@testing.com");
        okta.fill_password("holamundo!");
        okta.sign_in();

    }


    @Test(priority = 2,groups = {"sucessTests"})
    public void customSalesforceLinkFake(){
        SalesForceLoginPage SalesForceLogin = new SalesForceLoginPage(driver);
        SalesForceUseCustomDomainPage customDomain= new SalesForceUseCustomDomainPage(driver);
        SalesForceOktaFormPage okta = new SalesForceOktaFormPage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //loginpage
        SalesForceLogin.get_url(true);
        SalesForceLogin.use_custom_domain_tap();

        //customDomainPage
        customDomain.get_url(true);
        customDomain.insert_my_domain("as");
        customDomain.continue_btn_tap();

        //oktaformpage
        okta.get_url(true);
        String email = faker.internet().emailAddress();
        okta.fill_username(email);
        String pass = faker.internet().password();
        okta.fill_password(pass);
        okta.sign_in();

    }

    @Test(priority = 2,groups = {"sucessTests"})
    public void customSalesforceLinkB(){
        SalesForceLoginPage SalesForceLogin = new SalesForceLoginPage(driver);
        SalesForceUseCustomDomainPage customDomain= new SalesForceUseCustomDomainPage(driver);
        Utilities util = new Utilities(driver);
        util.maximize_window();

        //loginpage
        SalesForceLogin.get_url(true);
        SalesForceLogin.use_custom_domain_tap();

        //customDomainPage
        customDomain.get_url(true);
        customDomain.insert_my_domain("as");

    }

    @AfterMethod
    public void cerrarDriver(){
        driver.quit();
    }
}
