package test.FacebookTest;


import Hook.BeforeAfterDriver.DriverFacebook;
import PageObject.Facebook.facebookFormRegisterPage;
import org.testng.annotations.Test;

public class FacebookLoginTest extends DriverFacebook {


    @Test(priority = 0,groups = {"sucessTests"})
    public void forgotAccountTest(){
        //FacebookHome
        FacebookHome.title_page(true);
        facebookFormRegisterPage FacebookReg = FacebookHome.forget_passwd();

        //FacebookReg
        FacebookReg.title_page(true);

    }

    @Test(priority = 1,groups = {"sucessTests"})
    public void forgotAccountPartialLinkTest(){
        //FacebookHome
        FacebookHome.title_page(true);
        facebookFormRegisterPage FacebookReg = FacebookHome.forget_passwd_partial_link_text("¿Has olvidado");

        //FacebookReg
        FacebookReg.title_page(true);

    }

    @Test(priority = 3,groups = {"sucessTests"})
    public void registrationToFacebookTest(){
        //FacebookHome
        facebookFormRegisterPage FacebookReg = FacebookHome.create_new_acount();

        //FacebookReg
        FacebookReg.select_item_value_day("id","25");
        int mes = FacebookReg.select_item_value_month("id", "ago");
        FacebookReg.assert_month("id",mes);

    }
}
