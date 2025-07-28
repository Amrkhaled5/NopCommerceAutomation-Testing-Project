package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WishListPage extends BasePage{
//    private By Qty=By.cssSelector("td.quantity input.qty-input");
    private By Qty=By.xpath("//*[@id=\"main\"]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr/td[6]/input");

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
