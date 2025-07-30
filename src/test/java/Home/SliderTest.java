package Home;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {

    @Test(priority = 0)
    public void TestFirstSliderLink() {
        homepage.clickFirstSliderLink();

        Assert.assertTrue(homepage.checkCurrentURL("https://demo.nopcommerce.com/nokia-lumia-1020"), "First slider should navigate to the Nokia Lumia 1020 product page.");
    }

    @Test(priority = 1)
    public void TestSecondSliderLink() {
        homepage.clickSecondSliderLink();

        Assert.assertTrue(homepage.checkCurrentURL("https://demo.nopcommerce.com/iphone-6"), "Second slider should navigate to the iPhone 6 product page.");
    }
}
