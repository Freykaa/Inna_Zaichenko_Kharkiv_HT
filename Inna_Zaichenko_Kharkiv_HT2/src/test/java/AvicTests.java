import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;


import static org.openqa.selenium.By.xpath;
import static org.testng.Assert.*;

public class AvicTests {
    private WebDriver driver;

    @BeforeTest
    public void profileSetUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeMethod
    public void testSetUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://avic.ua/");
    }

    @Test(priority = 1)
    public void checkThatUrlContainsSearchWord() {
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("iPhone 13");
        driver.findElement(By.xpath("//button[@class='button-reset search-btn']")).click();
        assertTrue(driver.getCurrentUrl().contains("query=iPhone"));
    }

    @Test(priority = 2)
    public void checkPriceFilterMin() {
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("iPhone 13");
        driver.findElement(By.xpath("//button[@class='button-reset search-btn']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//input[@class='form-control form-control-min']")).sendKeys("35000");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='form-group filter-group js_filter_parent open-filter-tooltip']//a[@class='filter-tooltip js_filters_accept']")));
        driver.findElement(By.xpath("//div[@class='form-group filter-group js_filter_parent open-filter-tooltip']//a[@class='filter-tooltip js_filters_accept']")).click();

        List<WebElement> elementList = driver.findElements(xpath("//div[@class='prod-cart__prise-new']"));
        List<Double> priceWithoutSymbols = new ArrayList<>();
        for (WebElement webElement : elementList) {
            priceWithoutSymbols.add(Double.valueOf(webElement.getText().replace(" грн", "")));
        }
        priceWithoutSymbols.forEach(price -> assertTrue( price >= 35000));
    }

    @Test(priority = 3)
    public void checkForgottenPasswordRequiredField() {
        driver.findElement(By.xpath("//div[@class='header-bottom__right-icon']//i[@class='icon icon-user-big']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//a[@href='#js_forgotPassword']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("js_forgotPassword")));
        driver.findElement(By.xpath("//div[@id='js_forgotPassword']//input[@class='validate']")).sendKeys("123");
        driver.findElement(By.xpath("//div[@id='js_forgotPassword']//button[@class='button-reset main-btn main-btn--green submit']")).click();
        assertTrue(driver.findElement(By.xpath("//div[@class='form-field input-field flex error']")).isDisplayed());
    }

    @Test(priority = 4)
    public void checkRemoveFromCart() {
        driver.findElement(By.xpath("//input[@id='input_search']")).sendKeys("iPhone 13");
        driver.findElement(By.xpath("//button[@class='button-reset search-btn']")).click();
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        driver.findElement(By.xpath("//a[@class='prod-cart__buy'][contains(@data-ecomm-cart,'Starlight (MLK13)')]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("js_cart")));
        driver.findElement(By.xpath("//i[@data-cart-remove]")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("js_cart")));
        String actualProductsCountInCart =
                driver.findElement(By.xpath("//div[contains(@class,'header-bottom__cart')]//div[contains(@class,'cart_count')]")).
                        getText();
        assertEquals(actualProductsCountInCart, "0");
    }


    @AfterTest
    public void tearDown() {
        driver.close();
        driver.quit();
    }


}
