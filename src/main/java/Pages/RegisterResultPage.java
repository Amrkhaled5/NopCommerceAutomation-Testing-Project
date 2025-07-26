package Pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterResultPage extends BasePage{

    private By resultBox=By.xpath("//div[@class='page-body']");
    private By resultText=By.xpath("//div[@class='result']");

    public RegisterResultPage(WebDriver driver){
        super(driver);
    }

    //Check message apper or not
    public boolean checkMessageBoxApper() throws InterruptedException {
        return driver.findElement(resultBox).isDisplayed();

    }

    //Check Message Text Content
    public boolean checkMessageTextContent(String CorrectText){
        return driver.findElement(resultText).getText().equalsIgnoreCase(CorrectText);
    }

    //Check Message Text Color
    public boolean checkMessageTextColor(String CorrectColor){
        return driver.findElement(resultText).getCssValue("color").contains(CorrectColor);
    }

}
