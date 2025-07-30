package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * This class represents the Wishlist page in the nopCommerce application.
 * It provides functionality to check if the quantity of a product in the wishlist is greater than zero.
 */
public class WishListPage extends BasePage {

    // Locator for the quantity input field in the wishlist table
    private By Qty = By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[6]/input");

    /**
     * Constructor that initializes the WebDriver and passes it to the BasePage.
     * @param driver WebDriver instance passed from the test or parent page class
     */
    public WishListPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Checks if the quantity value in the wishlist is greater than 0.
     * @return true if the quantity is greater than 0, false otherwise
     */
    public boolean checkQtyValue() {
        String qtyString = driver.findElement(Qty).getAttribute("value");
        int qtyValue = Integer.parseInt(qtyString);
        return qtyValue > 0;
    }
}
