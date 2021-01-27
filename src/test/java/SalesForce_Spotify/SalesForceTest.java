package SalesForce_Spotify;

import WebObjectPage.salesForceLoginPage;
import WebObjectPage.salesForceOktaFormPage;
import WebObjectPage.salesForceUseCustomDomainPage;
import hook.Utilities;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalesForceTest {

    public WebDriver driver;
    public static Faker faker = new Faker();
    public salesForceLoginPage SalesForceLogin;
    public salesForceOktaFormPage okta;
    public salesForceUseCustomDomainPage customDomain;
    public Utilities util;

    @Test(groups = {"sucessTests","failTests"})


    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://login.salesforce.com/");
        SalesForceLogin = new salesForceLoginPage(driver);
        okta = new salesForceOktaFormPage(driver);
        customDomain = new salesForceUseCustomDomainPage(driver);
        util = new Utilities(driver);
    }

    @Test(priority = 0, groups = {"sucessTests"})
    public void validateSalesforceLogoTest(){
        util.maximize_window();

        //login page
        SalesForceLogin.search_logo_img("img");
        SalesForceLogin.search_logo_img("alt");
    }

    @Test(priority = 1, groups = {"sucessTests"})
    public void remenberMelsSelected(){
        util.maximize_window();

        //login page
        SalesForceLogin.get_url(true);
        SalesForceLogin.remenber();

    }

    @Test(priority = 2, groups = {"sucessTests"})
    public void FooterIsValid(){
        util.maximize_window();

        //login page
        SalesForceLogin.search_text("txtfooter");

    }

    @Test(priority = 3, groups = {"sucessTests"})
    public void LoginFailureTest(){
        util.maximize_window();

        //login page
        SalesForceLogin.fill_username("test@test.com");
        SalesForceLogin.fill_password("123466");
        SalesForceLogin.login_btn_tap();
        SalesForceLogin.search_text("txtdesactivate");
    }

    @Test(priority = 3, groups = {"sucessTests"})
    public void LoginFailurefakeTest(){
        util.maximize_window();

        //login page
        String email=faker.internet().emailAddress();
        SalesForceLogin.fill_username(email);
        String pass = faker.internet().domainName();
        SalesForceLogin.fill_password(pass);
        SalesForceLogin.login_btn_tap();
        SalesForceLogin.search_text("txtdesactivatefake");
    }

    @Test(priority = 2,groups = {"sucessTests"})
    public void customSalesforceLinkA(){
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