package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends BasePage{
    private By Qty=By.cssSelector("td.quantity input.qty-input");

    public WishListPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkQtyValue(){
        String qtyString=driver.findElement(Qty).getAttribute("value");
        int qtyValue=Integer.parseInt(qtyString);
        if (qtyValue>0)
            return true;
        return false;
    }
}
