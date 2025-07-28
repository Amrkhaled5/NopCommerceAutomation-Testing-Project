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
import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage{

    private By myAccountLink=By.xpath("//a[@class='ico-account']");

    //currancy Locators
    private By currencyDropDown=By.id("customerCurrency");
    private By productsPrice=By.cssSelector(".price.actual-price");

    // Search Locators
    private By searchField=By.id("small-searchterms");
    private By searchButton=By.xpath("//button[normalize-space()='Search']");

    //Slider Locator
    private By firstSliderLink = By.cssSelector(".swiper-slide-active a");
    private By secondSliderLink = By.xpath("//div[@aria-label='2 / 2']//a");
    private By sliderDiv=By.xpath("//*[@id=\"main\"]/div/div/div/div/div[1]");

    // Folow Us
    private By facebookIcon=By.xpath("//a[normalize-space()='Facebook']");
    private By twitterIcon=By.xpath("//a[normalize-space()='Twitter']");
    private By rssIcon=By.xpath("//a[normalize-space()='RSS']");
    private By youtubIcon=By.xpath("//a[normalize-space()='YouTube']");

    //WishList
    private By wishListIcon=By.xpath("//*[@id=\"main\"]/div/div/div/div/div[4]/div[2]/div[3]/div/div[2]/div[3]/div[2]/button[3]");
    private By addToWishListMessage=By.xpath("//div[@class='bar-notification success']");
    private By addToWishListMessageContent=By.xpath("//p[@class='content']");
    private By closeMessageButton=By.xpath("//*[@id=\"bar-notification\"]/div/span");

    //WishListLink
    private By wishListLink=By.cssSelector("a.ico-wishlist");

    public HomePage(WebDriver driver){
        super(driver);
    }

    //Links Manage
    public void clickOnLinks(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }
    public RegisterPage goToRegisterPage(){
        clickOnLinks("Register");
        return new RegisterPage(driver);
    }
    public LoginPage clickLogin(){
        clickOnLinks("Log in");
        return new LoginPage(driver);
    }
    public boolean checkMyAccountLink(){
        return driver.findElement(myAccountLink).isDisplayed();
    }
    public void clickLogOut(){
        clickOnLinks("Log out");
    }

    //curreny manage
    public Select getDropDownElement(){
        return new Select(driver.findElement(currencyDropDown));
    }
    public void selectFromDropDown(String currency){
        // need to wait all elements in the page to load
        JavascriptExecutor js = (JavascriptExecutor) driver;
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> js.executeScript("return document.readyState").equals("complete"));

        getDropDownElement().selectByVisibleText(currency);
    }
    public boolean checkPriceSymbolAllProducts(String symbol){
        List<WebElement> prices =driver.findElements(productsPrice);
        String price;
        for(WebElement p:prices){
            price=p.getText();
            if(!price.contains(symbol))
                return false;
        }
        return true;
    }

    // Search Functions
    public void setSearchValue(String data){
        driver.findElement(searchField).clear();
        driver.findElement(searchField).sendKeys(data);
    }
    public SearchResultPage clickSearchButton(){
        driver.findElement(searchButton).click();
        return new SearchResultPage(driver);
    }

    // Slider functions
    public void clickFirstSliderLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sliderLink = wait.until(ExpectedConditions.presenceOfElementLocated(firstSliderLink));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sliderLink);
    }
    public void clickSecondSliderLink() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement sliderLink = wait.until(ExpectedConditions.presenceOfElementLocated(secondSliderLink));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", sliderLink);
    }
    public boolean checkcurrentURL(String url){
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl().contains(url);
    }

    // Social Media functions
    public void clickOnPlatformLink(String platform){
        if(platform=="facebook")
            driver.findElement(facebookIcon).click();
        else if (platform=="twitter")
            driver.findElement(twitterIcon).click();
        else if (platform=="rss")
            driver.findElement(rssIcon).click();
        else if (platform=="youtube")
            driver.findElement(youtubIcon).click();
    }


    //WishList functions
    public void clickOnWishIcon(){
        // wait all page elements to load before any action
        JavascriptExecutor js = (JavascriptExecutor) driver;
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                webDriver -> js.executeScript("return document.readyState").equals("complete"));

        driver.findElement(wishListIcon).click();
    }
    public boolean checkMessageBoxApper(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(addToWishListMessage));
        return driver.findElement(addToWishListMessage).isDisplayed();
    }
    public boolean checkMessageContent(String correctMsg){
        return driver.findElement(addToWishListMessageContent).getText().contains(correctMsg);
    }
    public boolean checkMessageColor(String hex){
        String rgba=driver.findElement(addToWishListMessage).getCssValue("background-color");
        return Color.fromString(rgba).asHex().contains(hex);
    }

    public WishListPage clickWishListLink(){
        driver.findElement(wishListLink).click();
        return new WishListPage(driver);
    }
    public  void clickCloseMessageButton(){
        driver.findElement(closeMessageButton).click();
    }
}
