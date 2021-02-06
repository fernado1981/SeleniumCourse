package test.ExamTest;

import Hook.BeforeAfterDriver.DriverNetflix;
import PageObject.Netflix.singinPage;
import PageObject.Netflix.singupPage;
import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Netflix extends DriverNetflix {

    public static Faker faker = new Faker();

    @Test(priority = 5,groups = {"sucessTests"})
    public void get_title_page(){
        NetflixHome.accept_cookie();
        NetflixHome.title_page(true);
    }

    @Test(priority = 4,groups = {"sucessTests"})
    public void iniciarSesionPageTest(){
        NetflixHome.accept_cookie();
        NetflixHome.title_page(true);
        singinPage NetflixReg = NetflixHome.init_Session();
        NetflixReg.titleH1();
        NetflixReg.iniciarSesionFacebook();

    }

    @Test(priority = 3,groups = {"sucessTests"})
    public void loginToNetflixErrorTest(){
        NetflixHome.accept_cookie();
        NetflixHome.title_page(true);
        singinPage NetflixReg = NetflixHome.init_Session();
        NetflixReg.titleH1();
        NetflixReg.iniciarSesionFacebook();
        NetflixReg.regEmailAndPass();
        NetflixReg.validateMsgError();
        NetflixReg.validateCheckBox();
    }


    @Test(priority = 2,groups = {"sucessTests"})
    public void fakeEmailTest() throws InterruptedException {
        NetflixHome.accept_cookie();
        NetflixHome.title_page(true);
        String email = faker.internet().emailAddress();
        NetflixHome.correoMail(email);
        singupPage NetflixSingUp = NetflixHome.tap_Empezar();
        NetflixSingUp.get_url();
    }

    @DataProvider(name="email")
    public Object[][] DataProviderEjemplo(){
        return new Object[][]{
                {"pepe@gmail.com"},
                {"pepito@gmail.com"},
                {"rita@gmail.com"},
        };
    }

    @Test(priority = 1,groups = {"sucessTests"},dataProvider = "email")
    public void nombrePaisCapital(String email) throws InterruptedException {
        NetflixHome.accept_cookie();
        NetflixHome.title_page(true);
        NetflixHome.correoMail(email);
        singupPage NetflixSingUp = NetflixHome.tap_Empezar();
        NetflixSingUp.get_url();
    }

}
