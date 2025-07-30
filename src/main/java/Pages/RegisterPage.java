package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the Register page.
 * Provides methods to fill in registration fields and submit the form.
 */
public class RegisterPage extends BasePage {

    // Personal Details
    private By genderMaleField = By.id("gender-male");
    private By genderFemaleField = By.id("gender-female");
    private By firstNameField = By.id("FirstName");
    private By lastNameField = By.id("LastName");
    private By emailField = By.id("Email");

    // Company Details
    private By companyNameField = By.id("Company");

    // Password Fields
    private By passwordField = By.id("Password");
    private By confirmPasswordField = By.id("ConfirmPassword");

    // Register Button
    private By registerButton = By.id("register-button");

    /**
     * Constructor for RegisterPage.
     * @param driver WebDriver instance
     */
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Selects the gender based on the input value.
     * @param gender The gender to select ("male" or "female")
     */
    public void setGender(String gender) {
        if (gender.equalsIgnoreCase("male")) {
            driver.findElement(genderMaleField).click();
        } else {
            driver.findElement(genderFemaleField).click();
        }
    }

    /**
     * Fills in the personal details for registration.
     * @param firstName User's first name
     * @param lastName  User's last name
     * @param email     User's email address
     */
    public void setPersonalDetails(String firstName, String lastName, String email) {
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(emailField).sendKeys(email);
    }

    /**
     * Fills in the password and confirmation password fields.
     * @param password             The password to use
     * @param confirmationPassword The confirmation password
     */
    public void setPasswordAndConfirm(String password, String confirmationPassword) {
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmationPassword);
    }

    /**
     * Clicks the Register button and navigates to the registration result page.
     * @return RegisterResultPage instance
     */
    public RegisterResultPage clickRegister() {
        driver.findElement(registerButton).click();
        return new RegisterResultPage(driver);
    }
}
