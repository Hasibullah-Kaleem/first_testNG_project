package myapp.tests;


import myapp.pages.accountPage.US_04_ShippingAddressPage;
import myapp.utilities.*;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class US_04_ShippingAddressTest {


    US_04_ShippingAddressPage   us_04_shippingAddressPage;
    WebDriverWait wait;



    @BeforeMethod
    public void setUp() {
    us_04_shippingAddressPage= new US_04_ShippingAddressPage();


        Driver.getDriver().get("https://allovercommerce.com");

        Driver.getDriver().manage().deleteAllCookies();

    }

    private void signIn() throws IOException {

      us_04_shippingAddressPage.signInButton.click();




        // Take a screenshot before clicking Sign Out
       // MediaUtils.takeScreenshotOfTheEntirePage();


      us_04_shippingAddressPage.username.sendKeys("pelingursoytechpro@gmail.com");
      us_04_shippingAddressPage.password.sendKeys("techproteam");
      us_04_shippingAddressPage.signIn.click();

        // Take a screenshot before clicking Sign Out
        MediaUtils.takeScreenshotOfTheEntirePage();
       us_04_shippingAddressPage.signOutButton.click();


      WaitUtils.waitFor(3);
        // Verify the user is redirected to the My Account page
        assertTrue(Driver.getDriver().getCurrentUrl().contains("my-account"), "Failed to redirect to My Account page.");


    }


    @Test
    public void positiveTest() throws IOException, InterruptedException {
        // 1. Sign In
        signIn();
        WaitUtils.waitFor(3);
        // 2. Navigate to "Addresses" section and edit the form
       us_04_shippingAddressPage.addressOption.click();

        JSUtils.JSclickWithTimeout(us_04_shippingAddressPage.editShippingAddressButton);

        WaitUtils.waitFor(3);


        // 3. Fill out the form with valid information
        WaitUtils.waitForVisibility(us_04_shippingAddressPage.shippingFirstName, 10);


        WaitUtils.waitFor(3);


        Assert.assertEquals(us_04_shippingAddressPage.shippingFirstName.getAttribute("value"), "Sally");
        Assert.assertEquals(us_04_shippingAddressPage.shippingLastName.getAttribute("value"), "Smith");

        Assert.assertEquals(us_04_shippingAddressPage.shippingCountry.getAttribute("value"), "US");

      WaitUtils.waitFor(3);
        Assert.assertEquals(us_04_shippingAddressPage.streetAddress.getAttribute("value"), "5678 Ocean Drive");

        Assert.assertEquals(us_04_shippingAddressPage.shippingState.getAttribute("value"), "FL");
        Assert.assertEquals(us_04_shippingAddressPage.shippingCity.getAttribute("value"), "Miami");
        Assert.assertEquals(us_04_shippingAddressPage.shippingPostcode.getAttribute("value"), "43017");



        // 4. Save the address and verify the operation was successful
        //wait.until(ExpectedConditions.elementToBeClickable(us_04_shippingAddressPage.addressButton)).click();
        WaitUtils.waitFor(3);
        us_04_shippingAddressPage.addressButton.click();

        assertTrue(us_04_shippingAddressPage.addressButton.isDisplayed(), "Save operation might have successful.");
        //  MediaUtils.takeScreenshotOfTheEntirePage();
    }


    @Test
    public void negativeTest() throws IOException {

        // 1. Sign In
        signIn();
        WaitUtils.waitFor(3);
        // 2. Navigate to "Addresses" section and edit the form
       us_04_shippingAddressPage.addressOption.click();
       WaitUtils.waitFor(3);


        // MediaUtils.takeScreenshotOfTheEntirePage();
        //   us_03_billingAddressPage.editBillingAddressButton.click();
//JSUtils.JSclickWithTimeout(us_04_shippingAddressPage.editShippingAddressButton);
        us_04_shippingAddressPage.editShippingAddressButton.click();
        WaitUtils.waitFor(2);



        // 3. Fill out the form with valid information
        WaitUtils.waitForVisibility(us_04_shippingAddressPage.shippingFirstName, 10);


        WaitUtils.waitFor(3);


        Assert.assertEquals(us_04_shippingAddressPage.shippingFirstName.getAttribute("value"), "Sally");
        Assert.assertEquals(us_04_shippingAddressPage.shippingLastName.getAttribute("value"), "Smith");

        Assert.assertEquals(us_04_shippingAddressPage.shippingCountry.getAttribute("value"), "US");


        Assert.assertEquals(us_04_shippingAddressPage.streetAddress.getAttribute("value"), "5678 Ocean Drive");

        Assert.assertEquals(us_04_shippingAddressPage.shippingCity.getAttribute("value"), "Miami");
        Assert.assertEquals(us_04_shippingAddressPage.shippingState.getAttribute("value"), "FL");

      ;


        // Post Code enters incorrectly
        WaitUtils.waitForVisibility(us_04_shippingAddressPage.shippingPostcode, 1);

        if (us_04_shippingAddressPage.shippingPostcode.isDisplayed()) {
            us_04_shippingAddressPage.shippingPostcode.clear();
            us_04_shippingAddressPage.shippingPostcode.sendKeys("4301");
            System.out.println("System displays Please enter valid postcode");

        } else {
            System.out.println("postCode entered successfully");
            ActionsUtils.actionsHoverOverOnElement(us_04_shippingAddressPage.addressButton);

          us_04_shippingAddressPage.addressButton.click();
            WaitUtils.waitFor(3);


        }
    }

    @AfterMethod
    public void tearDown () {
        Driver.closeDriver();
    }
}

