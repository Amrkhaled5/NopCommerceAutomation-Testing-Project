package base;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * BaseTest class sets up and tears down the WebDriver for all test classes.
 * It also initializes the HomePage object to be used across tests.
 */
public class BaseTest {
    protected WebDriver driver;
    protected HomePage homepage;

    /**
     * This method sets up the Chrome WebDriver before any test class runs.
     * It maximizes the browser window, navigates to the nopCommerce demo site,
     * and initializes the HomePage object.
     */
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        homepage = new HomePage(driver);
    }

    /**
     * This method quits the WebDriver after all tests in the class are executed.
     * It ensures that the browser session is properly closed.
     */
    @AfterClass
    public void shutDown() {
        driver.quit();

    }
}
