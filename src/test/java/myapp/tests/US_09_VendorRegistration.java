package myapp.tests;

import myapp.pages.AlloverCommerce_VendorRegistrationPage;
import myapp.utilities.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class US_09_VendorRegistration {

   AlloverCommerce_VendorRegistrationPage vendorRegistrationPage;

    String email = "pelingursoytechpro@gmail.com";
    String strongPassword = "Pgpelin123!";
    protected WebDriver driver;
    Actions actions;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){
        vendorRegistrationPage = new AlloverCommerce_VendorRegistrationPage();
        actions = new Actions(Driver.getDriver());
        driver = Driver.getDriver();
        softAssert= new SoftAssert();
        ExtentReportUtils.createTestReport("AllOverCommerce Project Test Report for US_09_TC01","Testing the Vendor registration functionality");
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User navigated to allOverCommerce_url");
        //vendorRegistrationPage.registerOption.click();
        WaitUtils.waitFor(2);
        vendorRegistrationPage.registerOption.click();
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User clicked on Register option");
        vendorRegistrationPage.signupAsVendorOption.click();
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User clicked on Sign Up as Vendor option");
    }
    @Test
    public void successfulVendorRegistrationWithValidCredentials() {
        softAssert = new SoftAssert();
//        ExtentReportUtils.createTestReport("AllOverCommerce Project Test Report for US_09_TC01","Testing the Vendor registration functionality");
//        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        WaitUtils.waitFor(2);
//        ExtentReportUtils.pass("User navigated to allOverCommerce_url");
//        BrowserUtils.clickWithTimeOut(vendorRegistrationPage.registerOption,5);
//        WaitUtils.waitFor(2);
//        ExtentReportUtils.pass("User clicked on Register option");
//        vendorRegistrationPage.signupAsVendorOption.click();
//        WaitUtils.waitFor(2);
//        ExtentReportUtils.pass("User clicked on Sign Up as Vendor option");
        vendorRegistrationPage.emailAddressInputBox.sendKeys(email);
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User entered Email: " + email);
        vendorRegistrationPage.verificationCodeInputBox.sendKeys(" ");
        WaitUtils.waitFor(2);
        ExtentReportUtils.fail("User cannot receive a verification code to enter. Input is blank.");
        //vendorRegistrationPage.reSendCodeButton.click();
        vendorRegistrationPage.passwordInputBox.sendKeys(strongPassword);
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User entered a valid strong password: " + strongPassword);
        vendorRegistrationPage.confirmPasswordInputBox.sendKeys(strongPassword);
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User re- entered the valid strong password: " + strongPassword);
        actions.moveToElement(vendorRegistrationPage.registerButton).click().perform();
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User clicked on the register button");
        WaitUtils.waitFor(2);
        softAssert.assertFalse(driver.getTitle().contains("Dashboard"));
        WaitUtils.waitFor(2);
        ExtentReportUtils.fail("User cannot be directed to the Dashboard page - fails.");
        WaitUtils.waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("User is still on the registration page - cannot register succesfully");
        WaitUtils.waitFor(2);
        ExtentReportUtils.info("Registration with valid crendentials is not successful because verification code is not received");
        softAssert.assertAll();
    }

    @Test
    public void missingRequiredInputFields_UnsuccessfulRegistration() {
         softAssert = new SoftAssert();
//        ExtentReportUtils.createTestReport("AllOverCommerce Project Test Report for US_09_TC02","Testing the Vendor registration functionality");
//        WaitUtils.waitFor(2);
//        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
//        ExtentReportUtils.pass("User navigated to allOverCommerce_url");
        WaitUtils.waitFor(2);
        vendorRegistrationPage.registerOption.click();
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User clicked on Register option");
        vendorRegistrationPage.signupAsVendorOption.click();
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User clicked on Sign Up as Vendor option");
        vendorRegistrationPage.emailAddressInputBox.sendKeys("pelingursoytechpro@gmail.com");
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User entered Email: " + email);
        vendorRegistrationPage.verificationCodeInputBox.sendKeys("");
        ExtentReportUtils.pass("User leaves the verification code input Blank");
        WaitUtils.waitFor(2);
        vendorRegistrationPage.passwordInputBox.sendKeys("Pgpelin123!");
        ExtentReportUtils.pass("User entered a valid strong password: " + strongPassword);
        vendorRegistrationPage.confirmPasswordInputBox.sendKeys("Pgpelin123!");
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User re-entered a valid strong password: " + strongPassword);
        vendorRegistrationPage.registerButton.click();
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User clicked on the register button");
        WaitUtils.waitFor(2);
        softAssert.assertTrue(vendorRegistrationPage.verificationCodeErrorMessage.isDisplayed());
        WaitUtils.waitFor(2);
        ExtentReportUtils.pass("User sees the verification code is not received warning");
        WaitUtils.waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("User is still on the registration page - cannot register succesfully");
        WaitUtils.waitFor(2);
        ExtentReportUtils.info("Registration with valid credentials is not successful because verification code left empty. (Expected Outcome)");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
       ExtentReportUtils.flush();
       Driver.closeDriver();
    }
}
