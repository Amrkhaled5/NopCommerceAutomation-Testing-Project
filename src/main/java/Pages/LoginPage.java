package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class LoginPage extends BasePage{

    private By emailField=By.id("Email");
    private By passwordField=By.id("Password");
    private By loginButton=By.xpath("//button[normalize-space()='Log in']");
    private By messageFailBox=By.xpath("//div[@class='message-error validation-summary-errors']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void setEmail(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public void setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }

    // Here if the test case pase it go to HomePage if not it still in the same page
    public BasePage clickLogIn(){
        driver.findElement(loginButton).click();
        if(driver.getCurrentUrl().equals("https://demo.nopcommerce.com/")){
            return new HomePage(driver);
        }
        else{
            return new LoginPage(driver);
        }

    }

    public boolean checkErrorMessageApper(){
        return driver.findElement(messageFailBox).isDisplayed();
    }

    public boolean checkErrorMessageText(String correctMessage){
        return driver.findElement(messageFailBox).getText().contains(correctMessage);
    }

    public boolean chechErrorMessageColor(String correctColor){
        String rgbaColor= driver.findElement(messageFailBox).getCssValue("color");
        String hexColor= Color.fromString(rgbaColor).asHex();
        return hexColor.contains(correctColor);
    }
}
