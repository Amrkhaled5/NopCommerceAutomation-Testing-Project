package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Represents the product details page.
 * Provides methods to interact with and validate product-specific information.
 */
public class ProductPage extends BasePage {

    // Locator for the SKU (Stock Keeping Unit) of the product
    private By productSKU = By.xpath("//div[@class='sku']");

    /**
     * Constructor for the ProductPage class.
     * @param driver WebDriver instance used to interact with the page
     */
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks whether the product SKU contains the expected value.
     * @param correctSKU The expected SKU value to verify
     * @return true if the SKU contains the expected value, false otherwise
     */
    public boolean checkSKU(String correctSKU) {
        return driver.findElement(productSKU).getText().contains(correctSKU);
    }
}
