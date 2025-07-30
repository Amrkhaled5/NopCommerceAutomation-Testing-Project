package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * This class represents the page that shows the result of registration on the nopCommerce site.
 * It provides methods to validate the registration result message and its style.
 */
public class RegisterResultPage extends BasePage {

    // Locators for result elements
    private final By resultBox = By.xpath("//div[@class='page-body']");
    private final By resultText = By.xpath("//div[@class='result']");

    /**
     * Constructor for RegisterResultPage
     * @param driver WebDriver instance passed from the test
     */
    public RegisterResultPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Check if the result message box appears (is displayed).
     * @return true if the message box is visible, false otherwise
     */
    public boolean checkMessageBoxApper() {
        return driver.findElement(resultBox).isDisplayed();
    }

    /**
     * Check if the text content of the result message matches the expected text (case-insensitive).
     * @param correctText The expected success message
     * @return true if the actual message matches, false otherwise
     */
    public boolean checkMessageTextContent(String correctText) {
        String actualText = driver.findElement(resultText).getText().trim();
        return actualText.equalsIgnoreCase(correctText.trim());
    }

    /**
     * Check if the color of the result message text matches the expected RGBA value.
     * @param expectedColorRGB Expected RGBA color string, e.g., "rgba(76, 177, 124, 1)"
     * @return true if the color matches, false otherwise
     */
    public boolean checkMessageTextColor(String expectedColorRGB) {
        String actualColor = driver.findElement(resultText).getCssValue("color").trim();
        return actualColor.equals(expectedColorRGB);
    }

    /**
     * Optional improvement: Check message box with explicit wait.
     * Useful when the element takes time to appear after registration.
     * @param timeoutSeconds How many seconds to wait before failing
     * @return true if the message box becomes visible within the timeout
     */
    public boolean checkMessageBoxApperWithWait(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        WebElement box = wait.until(ExpectedConditions.visibilityOfElementLocated(resultBox));
        return box.isDisplayed();
    }
}
