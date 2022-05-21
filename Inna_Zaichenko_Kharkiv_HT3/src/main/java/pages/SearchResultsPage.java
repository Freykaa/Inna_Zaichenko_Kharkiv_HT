package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@class='prod-cart__descr']")
    private List<WebElement> searchResultsProductList;

    @FindBy(xpath = "//div[@class='prod-cart__prise-new']")
    private List<WebElement> searchResultsProductListPrice;

    @FindBy(xpath = "//input[@class='form-control form-control-min']")
    private WebElement filterPriceMin;

    @FindBy(xpath = "//div[@class='form-group filter-group js_filter_parent open-filter-tooltip']//a[@class='filter-tooltip js_filters_accept']")
    private WebElement filterPriceTooltipAccept;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }


    public void filterByPriceMin(String priceMin) {
        filterPriceMin.sendKeys(priceMin);
        waitVisibilityOfElement(30, filterPriceTooltipAccept);
        filterPriceTooltipAccept.click();
        implicitWait(3);
    }

    public List<Double> getSearchResultsProductListPrice() {
        List<Double> priceWithoutSymbols = new ArrayList<>();
        for (WebElement webElement : searchResultsProductListPrice) {
            priceWithoutSymbols.add(Double.valueOf(webElement.getText().replace(" грн", "")));
        }
        return priceWithoutSymbols;
    }



}
