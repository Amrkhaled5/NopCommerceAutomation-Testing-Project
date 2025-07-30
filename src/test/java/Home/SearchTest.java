package Home;

import Pages.ProductPage;
import Pages.SearchResultPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SearchTest extends BaseTest {

    @Test(priority = 0)
    public void testSearchResultsUsingProductName() {
        String[] searchTerms = {"book", "laptop", "nike"};

        for (String t : searchTerms) {
            SoftAssert softAssert = new SoftAssert();
            homepage.setSearchValue(t); // Set the search term in the input field
            SearchResultPage searchPage = homepage.clickSearchButton(); // Perform the search

            softAssert.assertTrue(searchPage.checkCurrentURL("https://demo.nopcommerce.com/search?q=" + t), "Expected URL to contain search term: " + t);
            softAssert.assertTrue(searchPage.checkTitleContainSearchWord(t), "Expected page title to contain search term: " + t);
            softAssert.assertTrue(searchPage.checkSizeOfProducts(), "Expected search results to show at least one product for: " + t);

            softAssert.assertAll();
        }
    }

    @Test(priority = 1)
    public void testSearchResultsUsingProductSKU() {
        String[] searchTerms = {"SCI_FAITH", "APPLE_CAM", "SF_PRO_11"};

        for (String t : searchTerms) {
            homepage.setSearchValue(t);
            SearchResultPage searchPage = homepage.clickSearchButton();
            ProductPage productPage = searchPage.clickProductLink();
            Assert.assertTrue(productPage.checkSKU(t), "Expected product SKU to match searched SKU: " + t);
        }
    }
}
