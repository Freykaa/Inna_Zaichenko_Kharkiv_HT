package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductPageTests extends BaseTest {

    @Test
    public void checkThatInStockMessageIsDisplayed() {
        getHomePage().clickFragranceShopButton();
        getFragrancePage().waitForPageLoadComplete(30);
        getFragrancePage().clickOnProduct();
        getProductPage().waitForPageLoadComplete(30);
        Assert.assertTrue(getProductPage().displayProductInStockMessage().isDisplayed());
    }

    @Test
    public void checkAddToCart() {
        getHomePage().clickFragranceShopButton();
        getFragrancePage().waitForPageLoadComplete(30);
        getFragrancePage().clickOnProduct();
        getProductPage().waitForPageLoadComplete(30);
        getProductPage().addToCartAction();
        Assert.assertEquals(getHomePage().cartCount(), "1");
    }

    @Test
    public void checkThatProductsAreSwatchable() {
        getHomePage().clickFragranceShopButton();
        getFragrancePage().waitForPageLoadComplete(30);
        getFragrancePage().clickOnProduct();
        getProductPage().waitForPageLoadComplete(30);
        getProductPage().selectNonDefaultSwatch();
        Assert.assertTrue(getProductPage().swatchIsSelected().isDisplayed());
    }
}
