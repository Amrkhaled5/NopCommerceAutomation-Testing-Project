package Home;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CurrenciesTest extends BaseTest {

    //Verifies that when the user selects "Euro" from the currency dropdown, all displayed product prices reflect the Euro symbol (€).
    @Test
    public void testEuroSymbol() {
        homepage.selectFromDropDown("Euro");
        Assert.assertTrue(homepage.checkPriceSymbolAllProducts("€"), "Not all product prices use the Euro symbol (€)");
    }
}
