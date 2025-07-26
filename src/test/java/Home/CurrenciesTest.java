package Home;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CurrenciesTest extends BaseTest {
    @Test
    public void testEuroSymbol() throws InterruptedException {
        homepage.selectFromDropDown("Euro");
        // There is problem it some times work and some times don't
        // i used wait and sleep but the same problem just few times work
        Assert.assertTrue(homepage.checkPriceSymbolAllProducts("€"));
    }
}
