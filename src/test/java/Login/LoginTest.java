package Login;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {

    @Test(priority = 0)
    public void testValidLogIn(){
        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage=homepage.clickLogin();
        loginPage.setEmail("test@example7.com");
        loginPage.setPassword("P@ssw0rd");
        BasePage homePage2= loginPage.clickLogIn();

        softAssert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/");
        if (homePage2 instanceof HomePage) {
            HomePage realHomePage2 = (HomePage) homePage2;
            softAssert.assertTrue(realHomePage2.checkMyAccountLink());
        }
        softAssert.assertAll();
        homepage.clickLogOut();
    }

    @Test(priority = 1)
    public void testInvalidLogIn() {
        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage=homepage.clickLogin();
        loginPage.setEmail("wrong@example.com");
        loginPage.setPassword("P@ssw0rd");
        BasePage loginPage2= loginPage.clickLogIn();
        LoginPage realloginPage2=null;

        if (loginPage2 instanceof LoginPage) {
            realloginPage2 = (LoginPage) loginPage2;
        }

        softAssert.assertTrue(realloginPage2.checkErrorMessageApper());
        softAssert.assertTrue(realloginPage2.checkErrorMessageText("Login was unsuccessful"));
        softAssert.assertTrue(realloginPage2.chechErrorMessageColor("#e4434b"));

        softAssert.assertAll();


    }
}
