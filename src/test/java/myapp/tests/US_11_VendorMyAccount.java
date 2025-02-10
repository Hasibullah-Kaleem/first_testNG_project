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
        driver= Driver.getDriver();
        homePage = new AlloverCommerce_HomePage();
        loginPage = new AlloverCommerce_VendorLoginPage();
        myAcountPage = new AlloverCommerce_VendorMyAcountPage();
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        homePage.signInIcon.click();
        loginPage.userNameInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("vendorPassword"));
        loginPage.signinButton.click();
        ExtentReportUtils.createTestReport("Smoke Test ", "My account");
        WaitUtils.waitFor(3);
        ExtentReportUtils.passAndCaptureScreenshot("user is on the home page of the web application");
        actions = new Actions(driver);
        actions.moveToElement(homePage.myAccout).click().perform();
        WaitUtils.waitFor(5);

    }

    @Test
    public void optionsVisibility(){
        for (WebElement eachOption : myAcountPage.allOptions){
            System.out.println(eachOption.getText());
            assertTrue(eachOption.isDisplayed());
        }
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
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/store-manager/"));
    }

    @Test
    public void ordersClickibility(){
        myAcountPage.orders.click();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/orders/"));
    }

    @Test
    public void downloadsClickibility(){
        actions.moveToElement(myAcountPage.downloads).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/downloads/"));
    }

    @Test
    public void addressesClickibility(){
        actions.moveToElement(myAcountPage.addresses).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/edit-address/"));
    }

    @Test
    public void accountDetailsClickibility(){
        actions.moveToElement(myAcountPage.accountDetails).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/edit-account/"));
    }

    @Test
    public void supportTicketsClickibility(){
        actions.moveToElement(myAcountPage.supportTickets).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/support-tickets/"));
    }

    @Test
    public void followingsClickibility(){
        actions.moveToElement(myAcountPage.followings).click().perform();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/my-account-2/followings/"));
    }

    @Test
    public void logoutClickibility(){
        actions.moveToElement(myAcountPage.logout).click().perform();
        assertTrue(loginPage.userNameInput.isDisplayed());
    }

    @Test
    public void wishlistClickibility(){
        myAcountPage.wishlist.click();
        assertTrue(driver.getCurrentUrl().contains("https://allovercommerce.com/wishlist/"));
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}