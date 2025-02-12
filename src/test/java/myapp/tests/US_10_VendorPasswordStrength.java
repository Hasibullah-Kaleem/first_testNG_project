package myapp.tests;

import myapp.pages.AlloverCommerce_VendorRegistrationPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ExtentReportUtils;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import static myapp.utilities.WaitUtils.waitFor;

public class US_10_VendorPasswordStrength {
    AlloverCommerce_VendorRegistrationPage vendorRegistrationPage = new AlloverCommerce_VendorRegistrationPage();
    String email = "pelingursoytechpro@gmail.com";
    String shortPassword = "1234";
    String weakPassword = "abc123";
    String goodPassword = "Abc123";
    String strongPassword = "Pgpelin123!";
    protected WebDriver driver;
    Actions actions;
    SoftAssert softAssert;

    @BeforeMethod
    public void setUp(){

        driver=Driver.getDriver();
        vendorRegistrationPage = new AlloverCommerce_VendorRegistrationPage();
    }

    @Test (priority = 1)
    public void testingWithShortLengthPassword(){
        softAssert = new SoftAssert();
        ExtentReportUtils.createTestReport("AllOverCommerce Project Test Report for US_10_TC01","Testing the Vendor registration functionality password strength for SHORT PASSCODE");

        waitFor(2);
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        waitFor(2);
        ExtentReportUtils.pass("User navigated to allovercommerce.com");
        WaitUtils.waitFor(3);
        vendorRegistrationPage.registerOption.click();
        waitFor(2);
        ExtentReportUtils.pass("User clicked on Register option");
        vendorRegistrationPage.signupAsVendorOption.click();
        waitFor(2);
        ExtentReportUtils.pass("User clicked on Sign Up as Vendor option");
        waitFor(2);
        vendorRegistrationPage.passwordInputBox.sendKeys(shortPassword);
        ExtentReportUtils.pass("User entered a short length password " + shortPassword );
        waitFor(2);
        softAssert.assertTrue(vendorRegistrationPage.passwordStrengthMessage.getText().contains("Too short"));
        waitFor(2);
        ExtentReportUtils.pass("User sees the warning for the password length " + shortPassword);
        waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("User is still on the registration page, seeing a warning message displayed for the password");
        waitFor(2);
        ExtentReportUtils.info("User enters a short password and sees a warning message displayed for the password (Expected Outcome)");
        softAssert.assertAll();


    }

    @Test(priority = 2)
    public void testingWithAllLevelPasswordLengths(){
        softAssert = new SoftAssert();
        ExtentReportUtils.createTestReport("AllOverCommerce Project Test Report for US_10_TC02","Testing the Vendor registration functionality password strength for ALL LEVELS");
        waitFor(2);
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        waitFor(2);
        ExtentReportUtils.pass("User navigated to allovercommerce.com");
        waitFor(2);
        vendorRegistrationPage.registerOption.click();
        waitFor(2);
        ExtentReportUtils.pass("User clicked on Register option");
        waitFor(2);
        vendorRegistrationPage.signupAsVendorOption.click();
        ExtentReportUtils.pass("User clicked on Sign Up as Vendor option");
        waitFor(2);
        vendorRegistrationPage.passwordInputBox.sendKeys(shortPassword);
        ExtentReportUtils.pass("User entered a short length password " + shortPassword );
        waitFor(2);
        softAssert.assertTrue(vendorRegistrationPage.passwordStrengthMessage.getText().contains("Too short"));
        waitFor(2);
        ExtentReportUtils.pass("User sees the warning for the password length short " + shortPassword);
        waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("User is still on the registration page, seeing a warning message displayed for the short password");
        vendorRegistrationPage.passwordInputBox.clear();
        waitFor(2);
        vendorRegistrationPage.passwordInputBox.sendKeys(weakPassword);
        waitFor(2);
        ExtentReportUtils.pass("User entered a weak length password  " + weakPassword);
        waitFor(2);
        softAssert.assertTrue(vendorRegistrationPage.passwordStrengthMessage.getText().contains("Weak"));
        waitFor(2);
        ExtentReportUtils.pass("User sees the warning for the password length weak " + weakPassword);
        waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("User is still on the registration page, seeing a warning message displayed for the weak password");
        waitFor(2);
        vendorRegistrationPage.passwordInputBox.clear();
        waitFor(2);
        vendorRegistrationPage.passwordInputBox.sendKeys(goodPassword);
        ExtentReportUtils.pass("User entered a good length password " + goodPassword );
        waitFor(2);
        softAssert.assertTrue(vendorRegistrationPage.passwordStrengthMessage.getText().contains("Good"));
        ExtentReportUtils.pass("User sees the warning for the password length good enough " + goodPassword);
        waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("User is still on the registration page, seeing a warning message displayed for the good password");
        waitFor(2);
        vendorRegistrationPage.passwordInputBox.clear();
        waitFor(2);
        vendorRegistrationPage.passwordInputBox.sendKeys(strongPassword);
        ExtentReportUtils.pass("User entered a strong length password " + strongPassword );
        waitFor(2);
        softAssert.assertTrue(vendorRegistrationPage.passwordStrengthMessage.getText().contains("Strong"));
        waitFor(2);
        ExtentReportUtils.pass("User sees the warning for the password length strong " + strongPassword);
        waitFor(2);
        ExtentReportUtils.passAndCaptureScreenshot("User is still on the registration page, seeing a warning message displayed for the strong password");
        waitFor(2);
        ExtentReportUtils.info("User sees every warning message for each level type of the password length (Expected Outcome)");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        ExtentReportUtils.flush();
        Driver.closeDriver();
    }


}
