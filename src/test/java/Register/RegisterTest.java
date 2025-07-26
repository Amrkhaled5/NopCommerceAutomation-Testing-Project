package Register;

import Pages.RegisterPage;
import Pages.RegisterResultPage;
import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterTest extends BaseTest {

    @Test
    public void testRegisterProcess() throws InterruptedException {

        // IMPORTANT Note change the mail because it already registered
        RegisterPage registerPage=homepage.goToRegisterPage();
        registerPage.setGender("male");
        registerPage.setPersonalDetailes("automation","tester","test@example7.com");
        registerPage.setPasswordAndConfirm("P@ssw0rd","P@ssw0rd");
        RegisterResultPage registerResultPage= registerPage.clickRegister();

        Assert.assertTrue(registerResultPage.checkMessageBoxApper());
        Assert.assertTrue(registerResultPage.checkMessageTextContent("Your registration completed"));
        Assert.assertTrue(registerResultPage.checkMessageTextColor("rgba(76, 177, 124, 1)"));
    }
}
