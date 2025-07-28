package Home;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrenciesTest extends BaseTest {
    @Test
    public void testEuroSymbol() throws InterruptedException {
        homepage.selectFromDropDown("Euro");
        Assert.assertTrue(homepage.checkPriceSymbolAllProducts("€"));
    }
}
