package myapp.pages.accountPage;

import myapp.tests.US_04_ShippingAddressTest;
import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;



public class US_04_ShippingAddressPage {



 public US_04_ShippingAddressPage() {

     PageFactory.initElements(Driver.getDriver(),this);

    }



 @FindBy(css = "a.login.inline-type")
 public WebElement signInButton;

// @FindBy(xpath = "//a[.//span[text()='Sign In']]")
// public WebElement signInButton;


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

 @FindBy (xpath = "//a[text()='Edit Your Shipping Address']")
 public WebElement editShippingAddressButton;



 @FindBy(id = "shipping_first_name")
 public WebElement shippingFirstName;


 @FindBy(id = "shipping_last_name")
 public WebElement shippingLastName;

 @FindBy(xpath = "//select[@id='shipping_country']")
 public WebElement shippingCountry;

 @FindBy(id ="shipping_address_1")
 public WebElement streetAddress;

 @FindBy(id="shipping_city")
 public WebElement shippingCity;

 @FindBy(xpath = "//select[@id='shipping_state']")
 public WebElement shippingState;



 @FindBy(id="shipping_postcode")
 public WebElement shippingPostcode;

 @FindBy(xpath = "//button[text()='Save address']")
 public WebElement addressButton;























}









