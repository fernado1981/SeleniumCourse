package test.SalesForceTest;

import Hook.DriverSalesForce;
import PageObject.SalesForce.salesForceOktaFormPage;
import PageObject.SalesForce.salesForceUseCustomDomainPage;
import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class SalesForceTest extends DriverSalesForce {

    public static Faker faker = new Faker();


    @Test(priority = 0, groups = {"sucessTests"})
    public void validateSalesforceLogoTest(){
        //login page
        SalesForceLogin.search_logo_img("img");
        SalesForceLogin.search_logo_img("alt");
    }

    @Test(priority = 1, groups = {"sucessTests"})
    public void remenberMelsSelected(){
        //login page
        SalesForceLogin.get_url(true);
        SalesForceLogin.remenber();

    }

    @Test(priority = 2, groups = {"sucessTests"})
    public void FooterIsValid(){
        //login page
        SalesForceLogin.search_text("txtfooter");

    }

    @Test(priority = 3, groups = {"sucessTests"})
    public void LoginFailureTest(){
        //login page
        SalesForceLogin.fill_username("test@test.com");
        SalesForceLogin.fill_password("123466");
        SalesForceLogin.login_btn_tap();
        SalesForceLogin.search_text("txtdesactivate");
    }

    @Test(priority = 3, groups = {"sucessTests"})
    public void LoginFailurefakeTest(){
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
        //loginpage
        SalesForceLogin.get_url(true);
        salesForceUseCustomDomainPage customDomain = SalesForceLogin.use_custom_domain_tap();

        //customDomainPage
        customDomain.get_url(true);
        customDomain.insert_my_domain("as");
        salesForceOktaFormPage okta = customDomain.continue_btn_tap();

        //oktaformpage
        okta.get_url(true);
        okta.fill_username("testing@testing.com");
        okta.fill_password("holamundo!");
        okta.sign_in();

    }


    @Test(priority = 2,groups = {"sucessTests"})
    public void customSalesforceLinkFake(){
        //loginpage
        SalesForceLogin.get_url(true);
        salesForceUseCustomDomainPage customDomain = SalesForceLogin.use_custom_domain_tap();

        //customDomainPage
        customDomain.get_url(true);
        customDomain.insert_my_domain("as");
        salesForceOktaFormPage okta = customDomain.continue_btn_tap();

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
        //loginpage
        SalesForceLogin.get_url(true);
        salesForceUseCustomDomainPage customDomain = SalesForceLogin.use_custom_domain_tap();

        //customDomainPage
        customDomain.get_url(true);
        customDomain.insert_my_domain("as");

    }
}