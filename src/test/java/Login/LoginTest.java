package Login;

import Pages.BasePage;
import Pages.HomePage;
import Pages.LoginPage;
import base.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest extends BaseTest {

    // Data provider for valid credentials
    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][] {
                {"test@example02.com", "P@ssw0rd"},
        };
    }

    // Data provider for invalid credentials
    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {
        return new Object[][] {
                {"wrong@example.com", "P@ssw0rd"},
        };
    }

    // Test for valid login scenarios
    @Test(dataProvider = "validLoginData", priority = 0)
    public void testValidLogIn(String email, String password){
        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage = homepage.clickLogin();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        BasePage resultPage = loginPage.clickLogIn();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://demo.nopcommerce.com/", "URL after login is incorrect.");

        if (resultPage instanceof HomePage) {
            HomePage realHomePage = (HomePage) resultPage;
            softAssert.assertTrue(realHomePage.checkMyAccountLink(), "My Account link is not visible after login.");
        } else {
            softAssert.fail("Login did not navigate to HomePage.");
        }

        softAssert.assertAll();
        homepage.clickLogOut();
    }
    // Test for Invalid login scenarios
    @Test(dataProvider = "invalidLoginData", priority = 1)
    public void testInvalidLogin(String email, String password) {
        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage = homepage.clickLogin();
        loginPage.setEmail(email);
        loginPage.setPassword(password);
        BasePage resultPage = loginPage.clickLogIn();

        if (resultPage instanceof LoginPage) {
            LoginPage returnedLoginPage = (LoginPage) resultPage;

            softAssert.assertTrue(returnedLoginPage.checkErrorMessageApper(), "Error message did not appear after invalid login.");
            softAssert.assertTrue(returnedLoginPage.checkErrorMessageText("Login was unsuccessful"), "Error message text is incorrect.");
            softAssert.assertTrue(returnedLoginPage.checkErrorMessageColor(), "Error message color is not as expected.");
        } else {
            softAssert.fail("Invalid login should stay on LoginPage.");
        }
        softAssert.assertAll();
    }
}
