package avic_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pages.AppleStorePage;
import pages.HomePage;
import pages.MacbookPage;
import pages.SearchResultsPage;
import pages.SignInPage;

import static io.github.bonigarcia.wdm.WebDriverManager.chromedriver;

/**
 *
 */
public class BaseTest {

    private WebDriver driver;
    private static final String AVIC_URL = "https://avic.ua/";

    @BeforeTest
    public void profileSetUp() {

        chromedriver().setup();
    }

    @BeforeMethod
    public void testsSetUp() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(AVIC_URL);
    }

    @AfterMethod
    public void tearDown() { driver.quit(); }

    public WebDriver getDriver() {
        return driver;
    }

    public HomePage getHomePage() {
        return new HomePage(getDriver());
    }

    public SearchResultsPage getSearchResultsPage() {
        return new SearchResultsPage(getDriver());
    }

    public AppleStorePage getAppleStorePage() { return new AppleStorePage(getDriver()); }

    public MacbookPage getMacbookPage() { return new MacbookPage(getDriver()); }

    public SignInPage getSignInPage() { return new SignInPage(getDriver()); }
}
