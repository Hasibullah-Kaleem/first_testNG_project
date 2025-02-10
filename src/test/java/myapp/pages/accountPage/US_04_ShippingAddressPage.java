package myapp.pages.accountPage;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;



public class US_04_ShippingAddressPage {




    @Test

    public void test(){

     PageFactory.initElements(Driver.getDriver(),this);

    }


 @FindBy(xpath = "//a[.//span[text()='Sign In']]")
 public WebElement signInButton;


 @FindBy(xpath = "//*[@id='username']")
 public WebElement username;

 @FindBy(id= "password")
 public WebElement password;

 @FindBy(xpath ="//button[text()='Sign In']")
 public WebElement signIn;

 @FindBy(xpath = "//span[text()='Sign Out']")
 public WebElement signOutButton;

 @FindBy(xpath = "//a[text()='Addresses']")
 public WebElement addressOption;

 //@FindBy(css="a[href*='edit-address']")
 // public WebElement editShippingAddressButton;

 @FindBy (xpath = "//a[text()='Edit Your Shipping Address']")
 public WebElement editShippingAddressButton;

 @FindBy(xpath = "//div[@role='alert']")
 public WebElement addressSuccessfullyChangedAlert; //Address changed successfully.

 @FindBy(xpath = "//input[contains(@id, 'billing_first_name')]")
 //@FindBy(id = "billing_firstName")
 public WebElement shippingFirstName;


 @FindBy(id = "billing_last_name")
 public WebElement shippingLastName;

 @FindBy(xpath = "//select[@id='billing_country']")
 public WebElement shippingCountry;

 @FindBy(id ="billing_streetAddress")
 public WebElement streetAddress;

 @FindBy(id="billing_city")
 public WebElement shippingCity;

 @FindBy(xpath = "//select[@id='shipping_state']")
 public WebElement shippingState;

 @FindBy(xpath="//span[@id=select-shipping_state-container")
 public WebElement shippingStateContainer;

 @FindBy(id="shipping_postcode")
 public WebElement shippingPostcode;


 @FindBy(xpath ="//button[@name='save_address']")
 public WebElement addressButton;





















}









