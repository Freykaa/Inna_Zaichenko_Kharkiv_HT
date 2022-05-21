package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

    @FindBy(xpath = "//a[@href='#js_forgotPassword']")
    private WebElement forgottenPasswordButton;

    @FindBy(xpath = "//div[@id='js_forgotPassword']//input[@class='validate']")
    private WebElement enterEmailOrPhoneForgottenPasswordForm;

    @FindBy(xpath = "//div[@id='js_forgotPassword']//button[@class='button-reset main-btn main-btn--green submit']")
    private WebElement submitEmailOrPhoneForgottenPasswordForm;

    @FindBy(xpath = "//div[@class='form-field input-field flex error']")
    private WebElement requiredFieldMessageForgottenPasswordForm;

    @FindBy(id = "js_forgotPassword")
    private WebElement forgottenPasswordForm;

    public SignInPage(WebDriver driver) { super(driver); }

    public void clickOnForgottenPasswordButton() {
        forgottenPasswordButton.click();
        waitVisibilityOfElement(30, forgottenPasswordForm);
    }

    public void enterEmailOrPhoneForgottenPasswordForm(String enterEmailOrPhone) {
        enterEmailOrPhoneForgottenPasswordForm.sendKeys(enterEmailOrPhone);
        submitEmailOrPhoneForgottenPasswordForm.click();
    }
    public WebElement getRequiredFieldMessageForgottenPasswordForm() { return requiredFieldMessageForgottenPasswordForm; }
}
