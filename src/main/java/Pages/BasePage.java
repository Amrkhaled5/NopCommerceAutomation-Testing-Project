package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


/**
 * BasePage class that provides shared functionality for all page objects.
 */
public class BasePage {
    protected WebDriver driver;

    /**
     * Constructor to initialize the BasePage with a WebDriver instance.
     * @param driver The WebDriver used to interact with the browser.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Waits until the specified element contains the expected text.
     * @param locator        The locator of the element to wait for.
     * @param text           The expected text to appear in the element.
     * @param timeoutSeconds The maximum time to wait in seconds.
     */
    public void waitForElement(By locator, String text, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

}
