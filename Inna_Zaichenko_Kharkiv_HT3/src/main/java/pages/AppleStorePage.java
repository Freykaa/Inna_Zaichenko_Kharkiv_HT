package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AppleStorePage extends BasePage {

    @FindBy(xpath = "//div[@class='brand-box__title']/a[contains(@href, 'macbook')]")
    private WebElement macbookButton;

    public AppleStorePage(WebDriver driver) { super(driver); }

    public void clickOnMacbookButton() { macbookButton.click(); }
}
