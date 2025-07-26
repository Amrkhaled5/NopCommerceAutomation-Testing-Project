package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage{
    //Personal Details
    private By genderMaleField=By.id("gender-male");
    private By genderFemaleField=By.id("gender-female");
    private By firstaNmaeField=By.id("FirstName");
    private By lastNameField=By.id("LastName");
    private By emailField=By.id("Email");

    //Company Details
    private By companyNameField=By.id("Company");

    //Password Fields
    private By passwordField=By.id("Password");
    private By confirmPasswordField=By.id("ConfirmPassword");

    //Register Button
    private By registerButton=By.id("register-button");

    public RegisterPage(WebDriver driver){
        super(driver);
    }

    //Select Gender
    public void setGender(String gender){
        if(gender.equalsIgnoreCase("male")){
            driver.findElement(genderMaleField).click();
        }
        else {
            driver.findElement(genderFemaleField).click();
        }
    }

    //Fill Personal Details
    public void setPersonalDetailes(String firstname,String lastname,String email){
        driver.findElement(firstaNmaeField).sendKeys(firstname);
        driver.findElement(lastNameField).sendKeys(lastname);
        driver.findElement(emailField).sendKeys(email);
    }

    //Fill Password and Confirm Password
    public void setPasswordAndConfirm(String password,String confirmationPassword){
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(confirmPasswordField).sendKeys(confirmationPassword);
    }

    //Click Register
    public RegisterResultPage clickRegister(){
        driver.findElement(registerButton).click();
        return new RegisterResultPage(driver);
    }
}
