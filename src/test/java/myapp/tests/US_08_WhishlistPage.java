package myapp.tests;

//

import myapp.pages.AlloverCommerce_WishListPage;
import myapp.pages.AlloverCommerce_WishListPage.*;
import myapp.utilities.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US_08_WhishlistPage {

    AlloverCommerce_WishListPage whishlist_page;
    protected WebDriver driver;
    Actions actions;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
    }

    @Test
    public void US08_TC01() throws InterruptedException {
        System.out.println("US08_TC01 is running...");

        ExtentReportUtils.createTestReport("UI Test ,", "WhishList Page Test");

        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));

        ExtentReportUtils.pass("Navigated to website");

        whishlist_page = new AlloverCommerce_WishListPage();
        actions = new Actions(Driver.getDriver());
        ExtentReportUtils.pass("User is on the Home page");
        actions.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).build().perform();
        actions.moveToElement(whishlist_page.addToWislist).perform();
        BrowserUtils.clickWithTimeOut(whishlist_page.addToWislist,5);
        WaitUtils.waitFor(4);

       // BrowserUtils.clickWithTimeOut(whishlist_page.smallHeart, 1);

        Thread.sleep(2000);
        ExtentReportUtils.pass("User clicks on the small heart icon to add the product to the Whishlist ");

        actions.moveToElement(whishlist_page.bigHeart).click().perform();
        Thread.sleep(2000);
        ExtentReportUtils.passAndCaptureScreenshot("User clicks on the big heart icon to access to Wishlist ");

        ExtentReportUtils.pass("User clicks on the big heart icon to access to Wishlist");

        Assert.assertTrue(whishlist_page.removeButton.isDisplayed());

        ExtentReportUtils.flush();

    }




    @Test
    public void US08_TC02() throws InterruptedException {
        System.out.println("US08_TC03 is running...");

        ExtentReportUtils.createTestReport("UI Test ,", "WhishList Page Test");

        whishlist_page = new AlloverCommerce_WishListPage();
        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));

        ExtentReportUtils.pass("Navigated to website");
        ExtentReportUtils.pass("User is on the Home page");
        actions=new Actions(Driver.getDriver());
        actions.moveToElement(whishlist_page.addToWislist).perform();
        WaitUtils.waitFor(3);
        BrowserUtils.clickWithTimeOut(whishlist_page.addToWislist, 5);

        Thread.sleep(2000);
        ExtentReportUtils.pass("User clicks on the small heart icon");
        actions.moveToElement(whishlist_page.bigHeart).perform();
        BrowserUtils.clickWithTimeOut(whishlist_page.bigHeart, 1);
        Thread.sleep(2000);
        ExtentReportUtils.passAndCaptureScreenshot("User clicks on the big heart icon");
        actions.moveToElement(whishlist_page.quickViewButton).perform();
        ExtentReportUtils.pass("User clicks on the big heart icon");

        Assert.assertTrue(whishlist_page.quickViewButton.isDisplayed());


        BrowserUtils.clickWithTimeOut(whishlist_page.quickViewButton, 1);
        Thread.sleep(2000);

        ExtentReportUtils.pass("User clicks on the quick view button");

        //Assert.assertTrue(whishlist_page.wishListButtonInquickView.isDisplayed());


        ExtentReportUtils.flush();

    }


    @Test
    public void US08_TC03() throws InterruptedException {
        System.out.println("US08_TC04 is running...");

        ExtentReportUtils.createTestReport("UI Test ,", "WhishList Page Test");

        AlloverCommerce_WishListPage whishlist_page = new AlloverCommerce_WishListPage();
        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));

        ExtentReportUtils.pass("Navigated to website");
        ExtentReportUtils.pass("User is on the Home page");
        actions=new Actions(Driver.getDriver());
        actions.moveToElement(whishlist_page.addToWislist).perform();
        BrowserUtils.clickWithTimeOut(whishlist_page.addToWislist, 5);

        Thread.sleep(2000);
        ExtentReportUtils.pass("User clicks on the small heart icon");
        actions.moveToElement(whishlist_page.bigHeart).perform();
        BrowserUtils.clickWithTimeOut(whishlist_page.bigHeart, 1);
        Thread.sleep(2000);
        ExtentReportUtils.passAndCaptureScreenshot("User clicks on the big heart icon");

        ExtentReportUtils.pass("User clicks on the big heart icon");
        actions.moveToElement(whishlist_page.addToCartButton).perform();
        BrowserUtils.clickWithTimeOut(whishlist_page.addToCartButton, 1);
        Thread.sleep(2000);
        ExtentReportUtils.pass("User clicks on the add to cart button");
        actions.moveToElement(whishlist_page.cartButton).perform();
        BrowserUtils.clickWithTimeOut(whishlist_page.cartButton, 1);
        Thread.sleep(2000);
        ExtentReportUtils.pass("User clicks on the cart button");
        Thread.sleep(2000);
        Assert.assertTrue(whishlist_page.shoppingCart.isDisplayed());

        ExtentReportUtils.flush();
    }


    @AfterMethod
    public void tearDown() {
        // Close the driver
        Driver.closeDriver();

    }


}