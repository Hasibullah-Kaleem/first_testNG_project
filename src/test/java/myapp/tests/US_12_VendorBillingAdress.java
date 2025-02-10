package myapp.tests;


import myapp.pages.AlloverCommerce_HomePage;
import myapp.pages.AlloverCommerce_VendorAdressesPage;
import myapp.pages.AlloverCommerce_VendorLoginPage;
import myapp.pages.AlloverCommerce_VendorMyAcountPage;

import myapp.pages.*;

import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ExtentReportUtils;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class US_12_VendorBillingAdress {
    Actions actions;
    AlloverCommerce_HomePage homePage;
    AlloverCommerce_VendorLoginPage loginPage;
    AlloverCommerce_VendorMyAcountPage myAcountPage;
    AlloverCommerce_VendorAdressPage vendorAdressPage;
    AlloverCommerce_VendorBillingAdressPage billingAdressPage;
    protected WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= Driver.getDriver();
        homePage = new AlloverCommerce_HomePage();
        loginPage = new AlloverCommerce_VendorLoginPage();
        myAcountPage = new AlloverCommerce_VendorMyAcountPage();
        vendorAdressPage = new AlloverCommerce_VendorAdressPage();
        billingAdressPage= new AlloverCommerce_VendorBillingAdressPage();
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        homePage.signInIcon.click();
        loginPage.userNameInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("vendorPassword"));
        loginPage.signinButton.click();
        ExtentReportUtils.createTestReport("Regression test ", "My account");
        ExtentReportUtils.passAndCaptureScreenshot("user is on the home page of the web application");
        WaitUtils.waitFor(3);
        actions = new Actions(driver);
        actions.moveToElement(homePage.myAccout).click().perform();
        WaitUtils.waitFor(5);

    }

    @Test
    public void validAddressTest(){
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
    }
    @Test
    public void invalidAdressTest(){
        actions.moveToElement(myAcountPage.addresses).click().perform();
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
        System.out.println(errorMessage.getText());
        WaitUtils.waitFor(3);

        assertTrue(errorMessage.getText().contains("ZIP Code is a required field."));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }

}


