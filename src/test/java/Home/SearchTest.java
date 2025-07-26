package Home;

import Pages.ProductPage;
import Pages.SearchResultPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BaseTest {
    @Test(priority = 0)
    public void testSearchResultsUsingProductName(){
        String[] searchTerms = {"book", "laptop", "nike"};
        for(String t:searchTerms){
            SoftAssert softAssert=new SoftAssert();
            homepage.setSearchValue(t);
            SearchResultPage searchPage=homepage.clickSearchButton();

            softAssert.assertTrue(searchPage.checkCurrentURL("https://demo.nopcommerce.com/search?q="+t));
            softAssert.assertTrue(searchPage.checkTitleContainSearchWord(t));
            softAssert.assertTrue(searchPage.checkSizeOfProducts());

            softAssert.assertAll();
        }
    }

    @Test(priority = 1)
    public void testSearchResultsUsingProductSKU(){
        String[] searchTerms = {"SCI_FAITH", "APPLE_CAM", "SF_PRO_11"};
        for(String t:searchTerms){

            homepage.setSearchValue(t);
            SearchResultPage searchPage=homepage.clickSearchButton();

            ProductPage productPage=searchPage.clickProductLink();
            Assert.assertTrue(productPage.checkSKU(t));
        }
    }

}
