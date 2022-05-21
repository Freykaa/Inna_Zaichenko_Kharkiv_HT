package avic_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromCartTest extends BaseTest{

    private final String EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART = "0";

    @Test
    public void checkRemoveFromCart() {
        getHomePage().clickOnProductCatalogButton();
        getHomePage().clickOnAppleStoreButton();
        getAppleStorePage().clickOnMacbookButton();
        getMacbookPage().waitForPageLoadComplete(30);
        getMacbookPage().clickOnAddToCartButton();
        getMacbookPage().waitVisibilityOfElement(30, getMacbookPage().getAddToCartPopUp());
        getMacbookPage().clickOnRemoveFromCartButton();
        getMacbookPage().waitInvisibilityOfElement(30, getMacbookPage().getAddToCartPopUp());
        Assert.assertEquals(getHomePage().getTextOfAmountProductsInCart(), EXPECTED_AMOUNT_OF_PRODUCTS_IN_CART);
    }
}
