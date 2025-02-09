package myapp.tests;

import myapp.pages.AlloverCommerce_HomePage;
<<<<<<< HEAD
import myapp.pages.AlloverCommerce_VendorAdressesPage;
=======
import myapp.pages.AlloverCommerce_VendorBillingAdressPage;
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
import myapp.pages.AlloverCommerce_VendorLoginPage;
import myapp.pages.AlloverCommerce_VendorMyAcountPage;
import myapp.utilities.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.AssertJUnit.*;

public class US_11_VendorLogin {

    AlloverCommerce_VendorLoginPage loginPage = new AlloverCommerce_VendorLoginPage();
    AlloverCommerce_HomePage homePage = new AlloverCommerce_HomePage();
    AlloverCommerce_VendorMyAcountPage myAcountPage = new AlloverCommerce_VendorMyAcountPage();
<<<<<<< HEAD
=======
    AlloverCommerce_VendorBillingAdressPage adressesPage = new AlloverCommerce_VendorBillingAdressPage();
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157


    protected WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));

    }

    @Test
    public void test1() throws IOException {
<<<<<<< HEAD
        ExtentReportUtils.createTestReport("UI Test", "Vendor Login Functionality");
        ExtentReportUtils.passAndCaptureScreenshot("Vendor is on the home page");
        homePage.signInIcon.click();
        WaitUtils.waitFor(3);
        ExtentReportUtils.pass("User is on login page");
        loginPage.userNameInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        WaitUtils.waitFor(3);
        ExtentReportUtils.pass("User enters valid email");
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("vendorPassword"));
        WaitUtils.waitFor(3);
        ExtentReportUtils.pass("User enters valid vendor password");
        loginPage.checkBox.click();
        WaitUtils.waitFor(3);
        ExtentReportUtils.pass("User is clicks on checkbox ");
        loginPage.signinButton.click();
        ExtentReportUtils.pass("User clicks on signin button");
        WaitUtils.waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("User successfully signed in");

        Actions actions = new Actions(driver);
        try {
            if (!homePage.myAccoutText.isDisplayed());

        }catch (NoSuchElementException e){
=======

        homePage.signInIcon.click();
        loginPage.userNameInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        WaitUtils.waitFor(3);
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("vendorPassword"));
        WaitUtils.waitFor(3);
        loginPage.checkBox.click();
        WaitUtils.waitFor(3);
        loginPage.signinButton.click();

        Actions actions = new Actions(driver);
        try {
            if (!homePage.myAccoutText.isDisplayed()) ;

        } catch (NoSuchElementException e) {
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
            actions.moveToElement(homePage.myAccout).click().perform();
            System.out.println(homePage.myAccoutText.getText());
            assertTrue(homePage.myAccoutText.getText().contains("My Account"));
        }
<<<<<<< HEAD

        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User can see my account");




        ExtentReportUtils.flush();

    }

=======
    }


>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
