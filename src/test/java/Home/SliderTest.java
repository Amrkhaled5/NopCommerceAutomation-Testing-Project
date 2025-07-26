package Home;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {
    @Test (priority = 0)
    public void TestFirstSliderLink(){
        homepage.clickFirstSliderLink();
        Assert.assertTrue(homepage.checkcurrentURL("https://demo.nopcommerce.com/nokia-lumia-1020"),"Slider should navigate to Nokia Lumia 1020 page with URL");
    }

    @Test (priority = 1)
    public void TestSecondSliderLink(){
        homepage.clickSecondSliderLink();
        Assert.assertTrue(homepage.checkcurrentURL("https://demo.nopcommerce.com/iphone-6"),
                "Second slider should navigate to iPhone 6 page with URL");
    }
}
