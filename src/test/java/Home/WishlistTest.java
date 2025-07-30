package Home;

import Pages.WishListPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Test class to verify wishlist functionality on the homepage.
 */
public class WishlistTest extends BaseTest {

    /**
     * Test to verify that clicking on the wishlist icon displays a success message
     * and confirms the message content and color.
     */
    @Test(priority = 0)
    public void testAddProductToWishList() {
        SoftAssert softAssert = new SoftAssert();

        homepage.clickOnWishIcon(); // Click the wishlist icon on a product

        softAssert.assertTrue(homepage.checkMessageBoxApper(), "Expected the wishlist success message to appear.");
        softAssert.assertTrue(homepage.checkMessageContent("The product has been added to your wishlist"), "Expected wishlist success message content is incorrect.");
        softAssert.assertTrue(homepage.checkMessageColor(), "Expected success message color to be green (#4bb07a).");

        softAssert.assertAll();
    }

    /**
     * Test to verify that the product added to the wishlist appears in the wishlist page.
     */
    @Test(priority = 1)
    public void testItemApperInWishList() {
        homepage.clickCloseMessageButton(); // Close the success message
        WishListPage wishListPage = homepage.clickWishListLink(); // Navigate to the wishlist page

        Assert.assertTrue(wishListPage.checkQtyValue(), "Expected wishlist item quantity to be greater than 0.");
    }
}
