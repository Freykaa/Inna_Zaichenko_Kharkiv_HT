package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//div[@class='button buy']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@class='popup cart ng-animate ng-hide-animate']")
    private WebElement popUpCart;

    @FindBy(xpath = "//div[@class='cart-controls']//div[@class='link']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//div[@class='product-item__status green']")
    private WebElement inStockMessage;

    @FindBy(xpath = "//div[@class='product-item__volume-radio']//div[@itemprop='offers']")
    private List<WebElement> productSwatchVolume;

    @FindBy(xpath = "//div[@class='variant checked']")
    private WebElement selectedSwatch;

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public WebElement displayProductInStockMessage() {
        return inStockMessage;
    }

    public void addToCartAction() {
        addToCartButton.click();
        waitVisibilityOfElement(60, popUpCart);
        continueShoppingButton.click();
    }

    public void selectNonDefaultSwatch() {
        productSwatchVolume.get(1).click();
    }

    public WebElement swatchIsSelected() {
        return selectedSwatch;
    }

}
