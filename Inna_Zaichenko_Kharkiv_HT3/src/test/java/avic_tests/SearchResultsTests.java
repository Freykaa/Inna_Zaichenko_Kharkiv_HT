package avic_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 *
 */
public class SearchResultsTests extends BaseTest {

    private static final String SEARCH_KEYWORD = "iPhone 13";
    private static final String EXPECTED_QUERY = "query=iPhone";
    private static final String PRICE_MINiMUM = "35000";

    @Test
    public void checkThatUrlContainsSearchWord() {

        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        Assert.assertTrue(getDriver().getCurrentUrl().contains(EXPECTED_QUERY));
    }

    @Test
    public void checkPriceFilterMinimum() {
        getHomePage().searchByKeyword(SEARCH_KEYWORD);
        getHomePage().implicitWait(30);
        getSearchResultsPage().filterByPriceMin(PRICE_MINiMUM);
        getSearchResultsPage().getSearchResultsProductListPrice().forEach(price -> Assert.assertTrue(price >= Integer.parseInt(PRICE_MINiMUM)));
    }

}
