package myapp.tests;

import myapp.pages.AlloverCommerce_HomePage;
import myapp.pages.AlloverCommerce_VendorLoginPage;
import myapp.pages.AlloverCommerce_VendorMyAcountPage;
import myapp.utilities.ConfigReader;
import myapp.utilities.Driver;
import myapp.utilities.ExtentReportUtils;
import myapp.utilities.WaitUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class US_11_VendorMyAccount {

    Actions actions;
    AlloverCommerce_HomePage homePage;
    AlloverCommerce_VendorLoginPage loginPage;
    AlloverCommerce_VendorMyAcountPage myAcountPage;
    protected WebDriver driver;
    @BeforeMethod
    public void setUp(){
<<<<<<< HEAD

=======
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
        driver= Driver.getDriver();
        homePage = new AlloverCommerce_HomePage();
        loginPage = new AlloverCommerce_VendorLoginPage();
        myAcountPage = new AlloverCommerce_VendorMyAcountPage();
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        homePage.signInIcon.click();
        loginPage.userNameInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("vendorPassword"));
        loginPage.signinButton.click();
<<<<<<< HEAD
        ExtentReportUtils.createTestReport("UI Test ", "My account");
=======
        ExtentReportUtils.createTestReport("Smoke Test ", "My account");
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("user is on the home page of the web application");
        actions = new Actions(driver);
        actions.moveToElement(homePage.myAccout).click().perform();
<<<<<<< HEAD
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User is on My account page ");
=======
        WaitUtils.waitFor(5);
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157

    }

    @Test
    public void optionsVisibility(){
<<<<<<< HEAD
        ExtentReportUtils.passAndCaptureScreenshot("User can see all the options under dashboard");
        ExtentReportUtils.flush();
        for (WebElement eachOption : myAcountPage.allOptions){
            System.out.println(eachOption.getText());
            assertTrue(eachOption.isDisplayed());

        }

=======
        for (WebElement eachOption : myAcountPage.allOptions){
            System.out.println(eachOption.getText());
            assertTrue(eachOption.isDisplayed());
        }
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    }

    @Test
    public void optionsClickibility(){
        for (WebElement eachOption: myAcountPage.allOptions){
            assertTrue(eachOption.isEnabled());
        }
    }

    @Test
    public void storeManagerClickibility(){
        myAcountPage.storeManager.click();
<<<<<<< HEAD
        ExtentReportUtils.pass("User clicks on store manager ");
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/store-manager/"));
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User in on store manager page");
        ExtentReportUtils.flush();
=======
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/store-manager/"));
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    }

    @Test
    public void ordersClickibility(){
<<<<<<< HEAD
        ExtentReportUtils.pass("User clicks on oders ");
        myAcountPage.orders.click();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/orders/"));
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User in on orders page");
        ExtentReportUtils.flush();
=======
        myAcountPage.orders.click();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/orders/"));
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    }

    @Test
    public void downloadsClickibility(){
<<<<<<< HEAD
        ExtentReportUtils.pass("User clicks on downloads ");
        actions.moveToElement(myAcountPage.downloads).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/downloads/"));
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User in on downloads page");
        ExtentReportUtils.flush();
=======
       actions.moveToElement(myAcountPage.downloads).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/downloads/"));
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    }

    @Test
    public void addressesClickibility(){
<<<<<<< HEAD
        ExtentReportUtils.pass("User clicks on addresses ");
        actions.moveToElement(myAcountPage.addresses).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/edit-address/"));
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User in on addresses page");
        ExtentReportUtils.flush();
=======
        actions.moveToElement(myAcountPage.addresses).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/edit-address/"));
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    }

    @Test
    public void accountDetailsClickibility(){
<<<<<<< HEAD
        ExtentReportUtils.pass("User clicks on account details ");
        actions.moveToElement(myAcountPage.accountDetails).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/edit-account/"));
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User in on account details page");
        ExtentReportUtils.flush();
=======
        actions.moveToElement(myAcountPage.accountDetails).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/edit-account/"));
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    }

    @Test
    public void supportTicketsClickibility(){
<<<<<<< HEAD
        ExtentReportUtils.pass("User clicks on support tickets ");
        actions.moveToElement(myAcountPage.supportTickets).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/support-tickets/"));
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User in on support tickets page");
        ExtentReportUtils.flush();
    }

    @Test
    public void wishlistClickibility(){
        ExtentReportUtils.pass("User clicks on wishlist ");
        myAcountPage.wishlist.click();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/wishlist/"));
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User in on wishlist page");
        ExtentReportUtils.flush();
=======
        actions.moveToElement(myAcountPage.supportTickets).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/support-tickets/"));
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    }

    @Test
    public void followingsClickibility(){
<<<<<<< HEAD
        ExtentReportUtils.pass("User clicks on followings ");
        actions.moveToElement(myAcountPage.followings).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/followings/"));
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User in on followings page");
        ExtentReportUtils.flush();
=======
        actions.moveToElement(myAcountPage.followings).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/followings/"));
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
    }

    @Test
    public void logoutClickibility(){
<<<<<<< HEAD
        ExtentReportUtils.pass("User clicks on log out  ");
        actions.moveToElement(myAcountPage.logout).click().perform();
        assertTrue(loginPage.userNameInput.isDisplayed());
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("User is on login page");
        ExtentReportUtils.flush();

    }

=======
        actions.moveToElement(myAcountPage.logout).click().perform();
        assertTrue(loginPage.userNameInput.isDisplayed());
    }

    @Test
    public void wishlistClickibility(){
        myAcountPage.wishlist.click();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/wishlist/"));
    }
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}
