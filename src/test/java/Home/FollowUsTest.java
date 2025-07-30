package Home;

import base.BaseTest;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FollowUsTest extends BaseTest {

    @Test(priority = 1)
    public void testFacebookLinks(){
        String originalWindow = driver.getWindowHandle();
        homepage.clickOnPlatformLink("facebook");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.getWindowHandles().size() > 1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/nopCommerce", "Facebook link did not redirect to the expected URL.");

        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @Test(priority = 2)
    public void testTwitterLinks(){
        String originalWindow = driver.getWindowHandle();
        homepage.clickOnPlatformLink("twitter");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.getWindowHandles().size() > 1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                driver.close();
                driver.switchTo().window(originalWindow);
                break;
            }
        }
        Assert.assertEquals(driver.getCurrentUrl(),"https://twitter.com/nopCommerce", "Twitter link did not redirect to the expected URL.");

        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @Test(priority = 3)
    public void testYoutubeLinks(){
        String originalWindow = driver.getWindowHandle();
        homepage.clickOnPlatformLink("youtube");

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.getWindowHandles().size() > 1);

        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(originalWindow)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        Assert.assertEquals(driver.getCurrentUrl(),"https://www.youtube.com/user/nopCommerce", "YouTube link did not redirect to the expected URL.");

        driver.close();
        driver.switchTo().window(originalWindow);
    }

    @Test(priority = 4)
    public void testRssLinks(){
        homepage.clickOnPlatformLink("rss");
        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/new-online-store-is-open", "RSS link did not redirect to the expected news page.");
    }
}
