package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage extends BasePage{

    private By productsTitle=By.xpath("//h2[@class='product-title']/a");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    // check Title of Products
    public boolean checkCurrentURL(String url){
        return driver.getCurrentUrl().contains(url);
    }
    public boolean checkTitleContainSearchWord(String word){
        List<WebElement> titles =driver.findElements(productsTitle);
        String title;
        for(WebElement t:titles){
            title=t.getText().toLowerCase();
            if(!title.contains(word))
                return false;
        }
        return true;
    }
    public boolean checkSizeOfProducts(){
        if(driver.findElements(productsTitle).size()>0)
            return true;
        return false;
    }

    // check product with SKU
    public ProductPage clickProductLink(){
        driver.findElement(productsTitle).click();
        return new ProductPage(driver);
    }
}
