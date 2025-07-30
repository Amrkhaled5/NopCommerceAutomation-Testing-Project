package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

/**
 * Represents the Login Page of the application.
 * Provides methods to perform login actions and validate error messages.
 */
public class LoginPage extends BasePage {

    // ========== Locators ==========
    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By loginButton = By.xpath("//button[normalize-space()='Log in']");
    private final By messageFailBox = By.xpath("//div[@class='message-error validation-summary-errors']");

    // ========== Constructor ==========

    /**
     * Initializes the LoginPage with the given WebDriver.
     * @param driver WebDriver instance.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // ========== Login Actions ==========

    /**
     * Sets the email address in the email input field.
     * @param email The email to input.
     */
    public void setEmail(String email) {
        driver.findElement(emailField).clear();
        driver.findElement(emailField).sendKeys(email);
    }

    /**
     * Sets the password in the password input field.
     * @param password The password to input.
     */
    public void setPassword(String password) {
        driver.findElement(passwordField).clear();
        driver.findElement(passwordField).sendKeys(password);
    }

    /**
     * Clicks the "Log in" button.
     * If login is successful, navigates to HomePage; otherwise, remains on LoginPage.
     * @return BasePage: either HomePage (on success) or LoginPage (on failure).
     */
    public BasePage clickLogIn() {
        driver.findElement(loginButton).click();

        // Check if login succeeded by verifying the current URL
        if (driver.getCurrentUrl().equals("https://demo.nopcommerce.com/")) {
            return new HomePage(driver);
        } else {
            return new LoginPage(driver);
        }
    }

    // ========== Error Message Validation ==========

    /**
     * Checks if the login error message box is displayed.
     * @return true if error box is visible; false otherwise.
     */
    public boolean checkErrorMessageApper() {
        return driver.findElement(messageFailBox).isDisplayed();
    }

    /**
     * Validates the text of the error message.
     * @param correctMessage The expected message text.
     * @return true if the actual message contains the expected text.
     */
    public boolean checkErrorMessageText(String correctMessage) {
        return driver.findElement(messageFailBox).getText().contains(correctMessage);
    }

    /**
     * Validates the color of the error message text.
     * @return true if the color matches the expected color.
     */
    public boolean checkErrorMessageColor() {
        String rgbaColor = driver.findElement(messageFailBox).getCssValue("color");
        String hexColor = Color.fromString(rgbaColor).asHex();
        return hexColor.contains("#e4434b");
    }
}
