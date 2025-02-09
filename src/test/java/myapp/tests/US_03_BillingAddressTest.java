package myapp.tests;


import myapp.pages.accountPage.US_03_BillingAddressPage;
import myapp.utilities.*;

import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;




public class US_03_BillingAddressTest {

    US_03_BillingAddressPage us_03_billingAddressPage;
    WebDriverWait wait;


    @BeforeMethod
    public void setUp() {
        us_03_billingAddressPage = new US_03_BillingAddressPage();
        Driver.getDriver().get("https://allovercommerce.com");
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    }

    private void signIn() throws IOException {

        us_03_billingAddressPage.signInButton.click();
        us_03_billingAddressPage.username.sendKeys("pelingursoytechpro@gmail.com");
        us_03_billingAddressPage.password.sendKeys("techproteam");
        us_03_billingAddressPage.signIn.click();

        // Take a screenshot before clicking Sign Out
        MediaUtils.takeScreenshotOfTheEntirePage();
        us_03_billingAddressPage.signOutButton.click();


        // Verify the user is redirected to the My Account page
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("my-account"), "Failed to redirect to My Account page.");
    }


    @Test
    public void positiveTest() throws IOException, InterruptedException {
        // 1. Sign In
        signIn();
        WaitUtils.waitFor(3);
        // 2. Navigate to "Addresses" section and edit the form
        us_03_billingAddressPage.addressOption.click();

        JSUtils.JSclickWithTimeout(us_03_billingAddressPage.editBillingAddressButton);

        WaitUtils.waitFor(3);

        // 3. Fill out the form with valid information
        WaitUtils.waitForVisibility(us_03_billingAddressPage.billingFirstName, 10);


        WaitUtils.waitFor(3);


        Assert.assertEquals(us_03_billingAddressPage.billingFirstName.getAttribute("value"), "Sally");
        Assert.assertEquals(us_03_billingAddressPage.billingLastName.getAttribute("value"), "Smith");
        // Assert.assertEquals(us_03_billingAddressPage.billingCompany.getAttribute("value"), "home office");
        Assert.assertEquals(us_03_billingAddressPage.billingCountry.getAttribute("value"), "US");


        Assert.assertEquals(us_03_billingAddressPage.streetAddress.getAttribute("value"), "5678 Ocean Drive");

        Assert.assertEquals(us_03_billingAddressPage.billingState.getAttribute("value"), "FL");
        Assert.assertEquals(us_03_billingAddressPage.billingCity.getAttribute("value"), "Miami");
        Assert.assertEquals(us_03_billingAddressPage.billingPostcode.getAttribute("value"), "43017");
        Assert.assertEquals(us_03_billingAddressPage.billingPhone.getAttribute("value"), "+1 222 772007");
        Assert.assertEquals(us_03_billingAddressPage.billingEmail.getAttribute("value"), "sallysmith@abc.com");


        // 4. Save the address and verify the operation was successful

        Assert.assertTrue(us_03_billingAddressPage.saveButton.isDisplayed(), "Save operation might have failed.");
        //  MediaUtils.takeScreenshotOfTheEntirePage();
    }


    @Test
    public void negativeTest() throws IOException {

        // 1. Sign In
        signIn();
        WaitUtils.waitFor(3);
        // 2. Navigate to "Addresses" section and edit the form
        us_03_billingAddressPage.addressOption.click();


        // MediaUtils.takeScreenshotOfTheEntirePage();
        //   us_03_billingAddressPage.editBillingAddressButton.click();
        JSUtils.JSclickWithTimeout(us_03_billingAddressPage.editBillingAddressButton);

        WaitUtils.waitFor(3);

        // 3. Fill out the form with valid information
        WaitUtils.waitForVisibility(us_03_billingAddressPage.billingFirstName, 10);


        WaitUtils.waitFor(3);


        Assert.assertEquals(us_03_billingAddressPage.billingFirstName.getAttribute("value"), "Sally");
        Assert.assertEquals(us_03_billingAddressPage.billingLastName.getAttribute("value"), "Smith");

        Assert.assertEquals(us_03_billingAddressPage.billingCountry.getAttribute("value"), "US");


        Assert.assertEquals(us_03_billingAddressPage.streetAddress.getAttribute("value"), "5678 Ocean Drive");

        Assert.assertEquals(us_03_billingAddressPage.billingCity.getAttribute("value"), "Miami");
        Assert.assertEquals(us_03_billingAddressPage.billingState.getAttribute("value"), "FL");

        Assert.assertEquals(us_03_billingAddressPage.billingPhone.getAttribute("value"), "+1 222 772007");
        Assert.assertEquals(us_03_billingAddressPage.billingEmail.getAttribute("value"), "sallysmith@abc.com");


        // Post Code enters incorrectly
        WaitUtils.waitForVisibility(us_03_billingAddressPage.billingPostcode, 1);

        if (us_03_billingAddressPage.billingPostcode.isDisplayed()) {
            us_03_billingAddressPage.billingPostcode.clear();
            us_03_billingAddressPage.billingPostcode.sendKeys("4301");
            System.out.println("System displays Please enter valid postcode");

        } else {
            System.out.println("postCode entered successfully");
            ActionsUtils.actionsHoverOverOnElement(us_03_billingAddressPage.saveButton);

            us_03_billingAddressPage.saveButton.click();
            WaitUtils.waitFor(3);


        }
    }

        @AfterMethod
        public void tearDown () {
            Driver.closeDriver();
        }
    }
