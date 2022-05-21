package pages;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FragrancePage extends BasePage {

    public FragrancePage(WebDriver driver) { super(driver); }

    @FindBy(xpath = "//div[@class='catalog-products']//div[@class='simple-slider-list__link']")
    private List<WebElement> productListFragrancePage;

    public void clickOnProduct() { productListFragrancePage.get(0).click(); }
}
