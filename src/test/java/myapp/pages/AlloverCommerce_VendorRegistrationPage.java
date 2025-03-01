package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_VendorRegistrationPage {
    public AlloverCommerce_VendorRegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//span[normalize-space()='Register']")
    public WebElement registerOption;

    @FindBy(xpath = "//a[normalize-space()='Signup as a vendor?']")
    public WebElement signupAsVendorOption;

    @FindBy(xpath = "//input[@id='user_email']")
    public WebElement emailAddressInputBox;

    @FindBy(xpath = "//input[@placeholder='Verification Code']")
    public WebElement verificationCodeInputBox;

    @FindBy(xpath = "//input[@name='wcfm_email_verified_button']")
    public WebElement reSendCodeButton;

    @FindBy(xpath = "//input[@id='passoword']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//input[@id='confirm_pwd']")
    public WebElement confirmPasswordInputBox;

    @FindBy(xpath = "//input[@id='wcfm_membership_register_button']")
    public WebElement registerButton;

    @FindBy(xpath = "//div[@class='wcfm-message email_verification_message wcfm-error']")
    public WebElement verificationCodeErrorMessage;

    @FindBy(xpath = "//div[@id='password_strength']")
    public WebElement passwordStrengthMessage;



}
