package Home;

import Pages.WishListPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WishlistTest extends BaseTest {
    @Test(priority = 0)
    public void testAddProductToWishList() {
        SoftAssert softAssert=new SoftAssert();

        homepage.clickOnWishIcon();
        softAssert.assertTrue(homepage.checkMessageBoxApper());
        softAssert.assertTrue(homepage.checkMessageContent("The product has been added to your wishlist"));
        softAssert.assertTrue(homepage.checkMessageColor("#4bb07a"));

        softAssert.assertAll();
    }
    @Test(priority = 1)
    public void testItemApperInWishList() {
        homepage.clickCloseMessageButton();
        WishListPage wishListPage=homepage.clickWishListLink();
        Assert.assertTrue(wishListPage.checkQtyValue());
    }
}
