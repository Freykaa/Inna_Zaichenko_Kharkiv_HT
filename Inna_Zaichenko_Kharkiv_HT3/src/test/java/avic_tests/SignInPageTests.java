package avic_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInPageTests extends BaseTest {
    private static final String INVALID_EMAIL_OR_PHONE = "NULL";

    @Test
    public void checkRequiredFieldForgottenPasswordMessage() {
        getHomePage().clickOnSignInButton();
        getSignInPage().clickOnForgottenPasswordButton();
        getSignInPage().enterEmailOrPhoneForgottenPasswordForm(INVALID_EMAIL_OR_PHONE);
        Assert.assertTrue(getSignInPage().getRequiredFieldMessageForgottenPasswordForm().isDisplayed());
    }
}
