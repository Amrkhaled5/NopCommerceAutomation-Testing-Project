package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Represents the Home Page of the nopCommerce site.
 * Contains methods to interact with various elements like sliders, wishlist, search, and social icons.
 */
public class HomePage extends BasePage {

    // ========== Locators ==========
    private final By myAccountLink = By.xpath("//a[@class='ico-account']");

    // Currency
    private final By currencyDropDown = By.id("customerCurrency");
    private final By productsPrice = By.cssSelector(".price.actual-price");

    // Search
    private final By searchField = By.id("small-searchterms");
    private final By searchButton = By.xpath("//button[normalize-space()='Search']");

    // Sliders
    private final By firstSliderLink = By.cssSelector(".swiper-slide-active a");
    private final By secondSliderLink = By.xpath("//div[@aria-label='2 / 2']//a");

    // Social media
    private final By facebookIcon = By.xpath("//a[normalize-space()='Facebook']");
    private final By twitterIcon = By.xpath("//a[normalize-space()='Twitter']");
    private final By rssIcon = By.xpath("//a[normalize-space()='RSS']");
    private final By youtubeIcon = By.xpath("//a[normalize-space()='YouTube']");

    // Wishlist
    private final By wishListIcon = By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]");
    private final By addToWishListMessage = By.xpath("//div[@class='bar-notification success']");
    private final By addToWishListMessageContent = By.xpath("//p[@class='content']");
    private final By closeMessageButton = By.xpath("//*[@id=\"bar-notification\"]/div/span");
    private final By wishListLink = By.cssSelector("a.ico-wishlist");

    // ========== Constructor ==========
    public HomePage(WebDriver driver) {
        super(driver);
    }

    // ========== Navigation ==========

    /**
     * Clicks a link by its visible text.
     * @param linkText The visible text of the link.
     */
    public void clickOnLinks(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    /**
     * Navigates to the registration page.
     * @return RegisterPage object.
     */
    public RegisterPage goToRegisterPage() {
        clickOnLinks("Register");
        return new RegisterPage(driver);
    }

    /**
     * Navigates to the login page.
     * @return LoginPage object.
     */
    public LoginPage clickLogin() {
        clickOnLinks("Log in");
        return new LoginPage(driver);
    }

    /**
     * Logs the user out by clicking the "Log out" link.
     */
    public void clickLogOut() {
        clickOnLinks("Log out");
    }

    /**
     * Checks if the "My Account" link is visible after login.
     * @return true if visible; false otherwise.
     */
    public boolean checkMyAccountLink() {
        return driver.findElement(myAccountLink).isDisplayed();
    }

    // ========== Currency Management ==========

    /**
     * Gets the dropdown element for currency selection.
     * @return Select object representing the dropdown.
     */
    public Select getDropDownElement() {
        return new Select(driver.findElement(currencyDropDown));
    }

    /**
     * Selects a currency from the dropdown by visible text.
     * @param currency The visible text of the currency to select.
     */
    public void selectFromDropDown(String currency) {
        // Ensure page fully loaded before selecting
        JavascriptExecutor js = (JavascriptExecutor) driver;
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> js.executeScript("return document.readyState").equals("complete")
        );
        getDropDownElement().selectByVisibleText(currency);
    }

    /**
     * Verifies that all product prices contain the specified currency symbol.
     * @param symbol The expected currency symbol (e.g., "$", "€").
     * @return true if all products contain the symbol; false otherwise.
     */
    public boolean checkPriceSymbolAllProducts(String symbol) {
        List<WebElement> prices = driver.findElements(productsPrice);
        for (WebElement price : prices) {
            if (!price.getText().contains(symbol)) {
                return false;
            }
        }
        return true;
    }

    // ========== Search ==========

    /**
     * Enters a value into the search input field.
     * @param data The text to search for.
     */
    public void setSearchValue(String data) {
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(data);
    }

    /**
     * Clicks the search button and navigates to the results page.
     * @return SearchResultPage object.
     */
    public SearchResultPage clickSearchButton() {
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }

    // ========== Slider ==========

    /**
     * Clicks the first active slider link using JavaScript executor.
     */
    public void clickFirstSliderLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sliderLink = wait.until(ExpectedConditions.presenceOfElementLocated(firstSliderLink));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sliderLink);
    }

    /**
     * Clicks the second slider link using JavaScript executor.
     */
    public void clickSecondSliderLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sliderLink = wait.until(ExpectedConditions.presenceOfElementLocated(secondSliderLink));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sliderLink);
    }

    /**
     * Verifies if the current URL contains the given substring.
     * @param url The expected substring of the URL.
     * @return true if the current URL contains the string; false otherwise.
     */
    public boolean checkCurrentURL(String url) {
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl().contains(url);
    }

    // ========== Social Media ==========

    /**
     * Clicks on a social platform link by name.
     * @param platform The platform name ("facebook", "twitter", "rss", "youtube").
     */
    public void clickOnPlatformLink(String platform) {
        switch (platform.toLowerCase()) {
            case "facebook":
                driver.findElement(facebookIcon).click();
                break;
            case "twitter":
                driver.findElement(twitterIcon).click();
                break;
            case "rss":
                driver.findElement(rssIcon).click();
                break;
            case "youtube":
                driver.findElement(youtubeIcon).click();
                break;
        }
    }

    // ========== Wishlist ==========

    /**
     * Clicks the heart icon to add a product to the wishlist.
     */
    public void clickOnWishIcon() {
        // Wait for page to fully load
        JavascriptExecutor js = (JavascriptExecutor) driver;
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> js.executeScript("return document.readyState").equals("complete")
        );
        driver.findElement(wishListIcon).click();
    }

    /**
     * Verifies that the wishlist success message appears.
     * @return true if the message is visible; false otherwise.
     */
    public boolean checkMessageBoxApper() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToWishListMessage));
        return driver.findElement(addToWishListMessage).isDisplayed();
    }

    /**
     * Validates the content of the wishlist message.
     * @param correctMsg The expected message content.
     * @return true if content matches; false otherwise.
     */
    public boolean checkMessageContent(String correctMsg) {
        return driver.findElement(addToWishListMessageContent).getText().contains(correctMsg);
    }

    /**
     * Validates the background color of the wishlist message.
     * @return true if the color is green (#4bb07a); false otherwise.
     */
    public boolean checkMessageColor() {
        String rgba = driver.findElement(addToWishListMessage).getCssValue("background-color");
        return Color.fromString(rgba).asHex().contains("#4bb07a");
    }

    /**
     * Clicks the wishlist icon in the header and navigates to the wishlist page.
     * @return WishListPage object.
     */
    public WishListPage clickWishListLink() {
        driver.findElement(wishListLink).click();
        return new WishListPage(driver);
    }

    /**
     * Closes the wishlist notification message.
     */
    public void clickCloseMessageButton() {
        driver.findElement(closeMessageButton).click();
    }
}
