package myapp.tests;

<<<<<<< HEAD
import myapp.pages.AlloverCommerce_HomePage;
import myapp.pages.AlloverCommerce_VendorAdressesPage;
import myapp.pages.AlloverCommerce_VendorLoginPage;
import myapp.pages.AlloverCommerce_VendorMyAcountPage;
=======
import myapp.pages.*;
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ExtentReportUtils;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
<<<<<<< HEAD
=======
import org.testng.annotations.AfterMethod;
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class US_12_VendorBillingAdress {

<<<<<<< HEAD

=======
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    Actions actions;
    AlloverCommerce_HomePage homePage;
    AlloverCommerce_VendorLoginPage loginPage;
    AlloverCommerce_VendorMyAcountPage myAcountPage;
<<<<<<< HEAD
    AlloverCommerce_VendorAdressesPage adressesPage;

=======
    AlloverCommerce_VendorAdressPage vendorAdressPage;
    AlloverCommerce_VendorBillingAdressPage billingAdressPage;
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    protected WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= Driver.getDriver();
        homePage = new AlloverCommerce_HomePage();
        loginPage = new AlloverCommerce_VendorLoginPage();
        myAcountPage = new AlloverCommerce_VendorMyAcountPage();
<<<<<<< HEAD
        adressesPage = new AlloverCommerce_VendorAdressesPage();

=======
        vendorAdressPage = new AlloverCommerce_VendorAdressPage();
        billingAdressPage= new AlloverCommerce_VendorBillingAdressPage();
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        homePage.signInIcon.click();
        loginPage.userNameInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("vendorPassword"));
        loginPage.signinButton.click();
<<<<<<< HEAD
        ExtentReportUtils.createTestReport("UI Test  ", "Billing address functionality");
=======
        ExtentReportUtils.createTestReport("Regression test ", "My account");
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
        ExtentReportUtils.passAndCaptureScreenshot("user is on the home page of the web application");
        WaitUtils.waitFor(3);
        actions = new Actions(driver);
        actions.moveToElement(homePage.myAccout).click().perform();
<<<<<<< HEAD
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User is on My account page of the application");
=======
        WaitUtils.waitFor(5);
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157

    }

    @Test
    public void validAddressTest(){
<<<<<<< HEAD
        actions.moveToElement(myAcountPage.addresses).click().perform();
        ExtentReportUtils.pass("User clicks on addresses page");
        actions.moveToElement(adressesPage.billingAdressButton).click().perform();
        ExtentReportUtils.pass("User clicks on billing address button");
        WaitUtils.waitFor(3);
        adressesPage.billingFirstNameInput.clear();
        adressesPage.billingFirstNameInput.sendKeys("Hasibullah");
        ExtentReportUtils.pass("User enters name");
        actions.moveToElement(adressesPage.billingCountry).click().sendKeys("United States (US)", Keys.ENTER).perform();
        ExtentReportUtils.pass("User enters country");
        WaitUtils.waitFor(3);
        actions.moveToElement(adressesPage.billingState).click().sendKeys("California",Keys.ENTER).perform();
        ExtentReportUtils.pass("User enters state");
        WaitUtils.waitFor(3);
        actions.moveToElement(adressesPage.saveButton).click().perform();
        ExtentReportUtils.pass("User clicks on save button");
        WebElement successMessage = WaitUtils.waitForVisibility(adressesPage.successMsg,5);
        System.out.println(successMessage.getText());
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User successfully changed the billing address");
        assertTrue(successMessage.getText().contains("Address changed successfully."));
        ExtentReportUtils.flush();
=======
       actions.moveToElement(myAcountPage.addresses).click().perform();
       actions.moveToElement(vendorAdressPage.billingAdressButton).click().perform();
        WaitUtils.waitFor(3);
        billingAdressPage.billingFirstNameInput.clear();
        billingAdressPage.billingFirstNameInput.sendKeys("Hasibullah");
        actions.moveToElement(billingAdressPage.billingCountry).click().sendKeys("United States (US)", Keys.ENTER).perform();
        WaitUtils.waitFor(3);
        actions.moveToElement(billingAdressPage.billingState).click().sendKeys("California",Keys.ENTER).perform();
        WaitUtils.waitFor(3);
        actions.moveToElement(billingAdressPage.saveButton).click().perform();

        WebElement successMessage = WaitUtils.waitForVisibility(billingAdressPage.successMsg,5);
        System.out.println(successMessage.getText());
        WaitUtils.waitFor(3);
        assertTrue(successMessage.getText().contains("Address changed successfully."));
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    }
    @Test
    public void invalidAdressTest(){
        actions.moveToElement(myAcountPage.addresses).click().perform();
<<<<<<< HEAD
        actions.moveToElement(adressesPage.billingAdressButton).click().perform();
        WaitUtils.waitFor(3);
        adressesPage.billingFirstNameInput.clear();
        adressesPage.billingFirstNameInput.sendKeys("Hasibullah");
        ExtentReportUtils.pass("User enters name");
        actions.moveToElement(adressesPage.billingCountry).click().sendKeys("United States (US)", Keys.ENTER).perform();
        ExtentReportUtils.pass("User enters country");
        WaitUtils.waitFor(3);
        actions.moveToElement(adressesPage.billingState).click().sendKeys("California",Keys.ENTER).perform();
        ExtentReportUtils.pass("User enters state");
        WaitUtils.waitFor(3);
        adressesPage.billingPostcode.clear();
        ExtentReportUtils.pass("User removes postal code");
        actions.moveToElement(adressesPage.saveButton).click().perform();
        ExtentReportUtils.pass("User clicks on save button");
        WebElement errorMessage =  WaitUtils.waitForVisibility(adressesPage.errorMsg,5);
        ExtentReportUtils.passAndCaptureScreenshot("User is not able to change the address and ZIP Code is a required field is displayed ");
=======
        actions.moveToElement(vendorAdressPage.billingAdressButton).click().perform();
        WaitUtils.waitFor(3);
        billingAdressPage.billingFirstNameInput.clear();
        billingAdressPage.billingFirstNameInput.sendKeys("Hasibullah");
        actions.moveToElement(billingAdressPage.billingCountry).click().sendKeys("United States (US)", Keys.ENTER).perform();
        WaitUtils.waitFor(3);
        actions.moveToElement(billingAdressPage.billingState).click().sendKeys("California",Keys.ENTER).perform();
        WaitUtils.waitFor(3);
        billingAdressPage.billingPostcode.clear();

        actions.moveToElement(billingAdressPage.saveButton).click().perform();
        WebElement errorMessage =  WaitUtils.waitForVisibility(billingAdressPage.errorMsg,5);
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
        System.out.println(errorMessage.getText());
        WaitUtils.waitFor(3);

        assertTrue(errorMessage.getText().contains("ZIP Code is a required field."));
    }

<<<<<<< HEAD
=======
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
}
