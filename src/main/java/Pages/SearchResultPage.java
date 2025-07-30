package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * This class handles actions and validations on the Search Results Page.
 */
public class SearchResultPage extends BasePage {

    private final By productsTitle = By.xpath("//h2[@class='product-title']/a");

    /**
     * Constructor to initialize the SearchResultPage with a WebDriver instance.
     * @param driver WebDriver instance used for interacting with the page
     */
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks if the current URL contains the expected URL fragment.
     * @param url The expected substring of the URL
     * @return true if the URL contains the given substring, false otherwise
     */
    public boolean checkCurrentURL(String url) {
        return driver.getCurrentUrl().contains(url);
    }

    /**
     * Validates that all product titles in the search result contain the search keyword.
     * @param word The keyword that should be present in each product title
     * @return true if all product titles contain the keyword, false if any title does not
     */
    public boolean checkTitleContainSearchWord(String word) {
        List<WebElement> titles = driver.findElements(productsTitle);
        for (WebElement title : titles) {
            if (!title.getText().toLowerCase().contains(word.toLowerCase())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if there is at least one product displayed in the search results.
     * @return true if at least one product is found, false otherwise
     */
    public boolean checkSizeOfProducts() {
        return !driver.findElements(productsTitle).isEmpty();
    }

    /**
     * Clicks the first product link from the search results and navigates to its product page.
     * @return ProductPage instance representing the product detail page
     */
    public ProductPage clickProductLink() {
        driver.findElement(productsTitle).click();
        return new ProductPage(driver);
    }
}
