package Register;

import Pages.RegisterPage;
import Pages.RegisterResultPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {

    @Test
    public void testRegisterProcess() throws InterruptedException {

        // NOTE: Change the email each time this test runs, or ensure it's not already registered
        RegisterPage registerPage = homepage.goToRegisterPage();

        registerPage.setGender("male");
        registerPage.setPersonalDetails("automation", "tester", "test@example02.com");
        registerPage.setPasswordAndConfirm("P@ssw0rd", "P@ssw0rd");
        RegisterResultPage registerResultPage = registerPage.clickRegister();

        Assert.assertTrue(registerResultPage.checkMessageBoxApper(), "Success message box should appear after successful registration.");
        Assert.assertTrue(registerResultPage.checkMessageTextContent("Your registration completed"), "Success message text is incorrect or missing.");
        Assert.assertTrue(registerResultPage.checkMessageTextColor("rgba(76, 177, 124, 1)"), "Success message color does not match expected green color.");
    }
}
