package myapp.tests;

import myapp.pages.AlloverCommerce_CompareProductPage;
import myapp.pages.AlloverCommerce_CompareProductPage.*;
import myapp.utilities.*;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class US_07_ComparePage {

    AlloverCommerce_CompareProductPage comparePage;
    protected WebDriver driver;
    Actions action;

    @BeforeMethod
    public void setUp() {
        driver = Driver.getDriver();
        action= new Actions(Driver.getDriver());
    }

    @Test
    public void US07_TC01() throws InterruptedException {
        System.out.println("US07_TC01 is running...");


        ExtentReportUtils.createTestReport("UI Test ,", "Compare Page Test");

        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));

        comparePage = new AlloverCommerce_CompareProductPage();
        ActionsUtils actions = new ActionsUtils();

        ExtentReportUtils.pass("User is on the Home page");

        ActionsUtils.actionsHoverOverOnElement(comparePage.scaleIcon);



        action.moveToElement(comparePage.scaleIcon).click().perform();
        WaitUtils.waitFor(3);

       // BrowserUtils.clickWithTimeOut(comparePage.scaleIcon, 3);
        ExtentReportUtils.pass("User added the product to the compare page");

        ExtentReportUtils.passAndCaptureScreenshot("Product added to Compare list....");


        ActionsUtils.actionsDoubleClick(comparePage.centralPanel);
        // Scroll down using arrow keys
        ActionsUtils.actionsScrollDown();
        ActionsUtils.actionsScrollDown();
        ExtentReportUtils.passAndCaptureScreenshot("User Scroll-down the page....");
        Thread.sleep(2000);


        ActionsUtils.actionsHoverOverOnElement(comparePage.procuct2);
        ExtentReportUtils.pass("User hover over the second product to add it to the compare page");
        action.moveToElement(comparePage.scaleIcon3).click().perform();


        ExtentReportUtils.pass("User added the second product to the compare page");


        ExtentReportUtils.passAndCaptureScreenshot("Second product added to the compare page....");
        Thread.sleep(2000);

        //comparePage.startCompare.click();
        ExtentReportUtils.pass("User clicks on the Start Compare button to access the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.startCompare, 3);
        ExtentReportUtils.passAndCaptureScreenshot("User access the compare page....");

        ExtentReportUtils.pass("User is seeing the products to compare in the compare page");
        Assert.assertTrue(comparePage.compareHeader.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("User is in the compare page....");

        ExtentReportUtils.flush();
    }

    @Test
    public void US07_TC02() throws InterruptedException {
        System.out.println("US07_TC02 is running...");
        AlloverCommerce_CompareProductPage comparePage = new AlloverCommerce_CompareProductPage();

       // ActionsUtils actions = new ActionsUtils();
        ExtentReportUtils.createTestReport("UI Test ,", "Compare Page Test");

        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        BrowserUtils.clickWithTimeOut(comparePage.searchBox, 3);
        ExtentReportUtils.pass("User clicks on the search box to search for a product");
        comparePage.searchBox.sendKeys("book");
        ExtentReportUtils.pass("User searches for a product");
        comparePage.searchBox.submit();
        ExtentReportUtils.pass("User submits the search");
        ExtentReportUtils.passAndCaptureScreenshot("User is seeing the search results....");

        //  Thread.sleep(2000);

        //  Thread.sleep(1000);
        ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);
        Thread.sleep(1000);

        ActionsUtils.actionsHoverOverOnElement(comparePage.productImage1);
        Thread.sleep(1000);
        BrowserUtils.clickWithTimeOut(comparePage.addCompare1, 3);
        ExtentReportUtils.pass("User added the fourth product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("First product added to the compare page....");
        Thread.sleep(2000);

        ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);
        Thread.sleep(1000);

        ActionsUtils.actionsHoverOverOnElement(comparePage.priceProduct2);
        Thread.sleep(1000);
        BrowserUtils.clickWithTimeOut(comparePage.addCompare2, 3);
        ExtentReportUtils.pass("User added the fourth product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("Second product added to the compare page....");

        Thread.sleep(2000);
        ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);
        action.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN).build().perform();

        WaitUtils.waitFor(3);
        action.moveToElement(comparePage.priceProduct3).perform();

        action.moveToElement(comparePage.addCompare3).click().perform();
        //ActionsUtils.actionsHoverOverOnElement(comparePage.priceProduct3);

        //BrowserUtils.clickWithTimeOut(comparePage.addCompare3, 3);
        ExtentReportUtils.pass("User added the fourth product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("Third product added to the compare page....");

        Thread.sleep(2000);
        ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);

        action.sendKeys(Keys.ARROW_DOWN,Keys.PAGE_DOWN).build().perform();
        action.moveToElement(comparePage.productImage4).perform();
        Thread.sleep(1000);

        WaitUtils.waitFor(3);
        action.moveToElement(comparePage.addCompare4).click().perform();
        ExtentReportUtils.pass("User added the fourth product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("Fourth product added to the compare page....");




        //ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);


        ExtentReportUtils.pass("User clicks on the Start Compare button to access the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.startCompare, 3);
        ExtentReportUtils.passAndCaptureScreenshot("User access the compare page....");

        ExtentReportUtils.pass("User is seeing the products to compare in the compare page");
        Assert.assertTrue(comparePage.compareHeader.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("User is in the compare page....");
        ExtentReportUtils.flush();

    }

    @Test
    public void US07_TC03() throws InterruptedException {
        System.out.println("US07_TC03 is running...");
        AlloverCommerce_CompareProductPage comparePage = new AlloverCommerce_CompareProductPage();
       // ActionsUtils actions = new ActionsUtils();

        ExtentReportUtils.createTestReport("UI Test ,", "Compare Page Test");

        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        ActionsUtils.actionsHoverOverOnElement(comparePage.menCategory);

        ExtentReportUtils.pass("User clicks on men category");
        BrowserUtils.clickWithTimeOut(comparePage.fashionCategory, 3);
        ExtentReportUtils.pass("User clicks on fashion category");

        ActionsUtils.actionsHoverOverOnElement(comparePage.productMen1);
        ExtentReportUtils.pass("User hover over the first product to add it to the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.scaleProductMen1, 3);
        ExtentReportUtils.pass("User added the first product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("First product added to the compare page....");
        Thread.sleep(2000);
        ActionsUtils.actionsDoubleClick(comparePage.navigationPanel);
        action.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN).build().perform();
        WaitUtils.waitFor(3);
        action.moveToElement(comparePage.productMen2).perform();
       // ActionsUtils.actionsHoverOverOnElement(comparePage.productMen2);
        Thread.sleep(1000);
        ExtentReportUtils.pass("User hover over the second product to add it to the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.scaleProductMen2, 3);
        ExtentReportUtils.pass("User added the second product to the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("Second product added to the compare page....");
        Thread.sleep(2000);


        ExtentReportUtils.pass("User clicks on the Start Compare button to access the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.startCompare, 3);
        ExtentReportUtils.passAndCaptureScreenshot("User access the compare page....");

        ExtentReportUtils.pass("User is seeing the products to compare in the compare page");
        Assert.assertTrue(comparePage.compareHeader.isDisplayed());
        ExtentReportUtils.passAndCaptureScreenshot("User is in the compare page....");
        ExtentReportUtils.flush();
    }

    @Test
    public void US07_TC04() throws InterruptedException {
        System.out.println("US07_TC04 is running...");
        comparePage = new AlloverCommerce_CompareProductPage();
        //ActionsUtils actions = new ActionsUtils();

        ExtentReportUtils.createTestReport("UI Test ,", "Compare Page Test");

        //Given user is on the application home page  https://allovercommerce.com/
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));
        action.sendKeys(Keys.PAGE_DOWN).perform();
        WaitUtils.waitFor(3);
        action.moveToElement(comparePage.scaleIcon).click().perform();
        ExtentReportUtils.pass("User added the product to the compare page");
        Thread.sleep(2000);
        ExtentReportUtils.passAndCaptureScreenshot("Product added to Compare list....");


        ActionsUtils.actionsDoubleClick(comparePage.centralPanel);
        // Scroll down using arrow keys
        ActionsUtils.actionsScrollDown();
        ExtentReportUtils.passAndCaptureScreenshot("User Scroll-down the page....");
        Thread.sleep(2000);

        action.sendKeys(Keys.PAGE_DOWN).perform();


        action.moveToElement(comparePage.procuct2).perform();
        ExtentReportUtils.pass("User hover over the second product to add it to the compare page");
        action.moveToElement(comparePage.scaleIcon3).click().perform();

        Thread.sleep(2000);
        ExtentReportUtils.pass("User added the second product to the compare page");


        ExtentReportUtils.passAndCaptureScreenshot("Second product added to the compare page....");
        Thread.sleep(2000);

        //comparePage.startCompare.click();
        ExtentReportUtils.pass("User clicks on the Start Compare button to access the compare page");
        BrowserUtils.clickWithTimeOut(comparePage.startCompare, 3);
        ExtentReportUtils.passAndCaptureScreenshot("User access the compare page....");
        ExtentReportUtils.pass("User is seeing the products to compare in the compare page");

        Assert.assertTrue(comparePage.compareHeader.isDisplayed());
        ExtentReportUtils.pass("User is seeing the products to compare in the compare page");


        BrowserUtils.clickWithTimeOut(comparePage.removeProduct1, 3);
        ExtentReportUtils.pass("User removes the first product from the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("First product removed from the compare page....");
        Thread.sleep(1000);

        BrowserUtils.clickWithTimeOut(comparePage.removeProduct2, 3);
        ExtentReportUtils.pass("User removes the second product from the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("Second product removed from the compare page....");
        Thread.sleep(1000);

        Assert.assertTrue(comparePage.noProductsAdded.isDisplayed());
        ExtentReportUtils.pass("User is seeing the no products added message in the compare page");
        ExtentReportUtils.passAndCaptureScreenshot("No products added message is displayed....");


        ExtentReportUtils.flush();
    }


    @AfterMethod
    public void tearDown() {
        // Close the driver
        Driver.closeDriver();

    }


}
