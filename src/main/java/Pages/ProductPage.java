package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage{
    private By productSKU=By.xpath("//div[@class='sku']");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkSKU(String correctSKU){
        return driver.findElement(productSKU).getText().contains(correctSKU);
    }
}
