package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.lang.Integer.parseInt;

public class HomePage extends BasePage {

    @FindBy(xpath = "//li[@class='menu-list__item full']/a[@href='/categorys/3/']")
    private WebElement fragranceShopButton;

    @FindBy(xpath = "//div[@class='header-basket']//span//span")
    private WebElement headerCartCount;

    public HomePage(WebDriver driver) { super(driver); }

    public void clickFragranceShopButton() {
        fragranceShopButton.click();
    }

    public String cartCount() {
        return headerCartCount.getText().replaceAll("[^\\d]", "");
    }
}
