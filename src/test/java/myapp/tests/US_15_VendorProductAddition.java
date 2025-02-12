package myapp.tests;
import com.github.javafaker.Faker;
import myapp.pages.*;
import myapp.utilities.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.json.Json;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URISyntaxException;
import java.util.Objects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

  /*
        TC_01

        Vendor goes to  "https://allovercommerce.com/" home page
        Vendor should be registered
        Vendor logs in with valid credentials
        Vendor clicks on My Account
        Vendor clicks on Store Manager
        Click on Add new button
        Enter "Product Title"
        Upload Featured Image
        Upload Gallery Image
        Select product category from required "Category section"
        Enter a valid data into SKU input box
        Click on Manage Stock checkbox
        Click on Sold individually checkbox
        Then click on Shipping menu
        Enter valid weight in Weight input box
        Enter valid  length in Length input box
        Enter valid width in Width input box
        Enter valid height in Height  input box
        Click on processing time dropdown menu and choose first option
        Click on Submit button
        Verify message: "Product successfully published" is displayed


        TC_02

        Vendor goes to  "https://allovercommerce.com/" home page
        Vendor should be registered
        Vendor logs in with valid credentials
        Vendor clicks on My Account
        Vendor clicks on Store Manager
        Click on Add new button
        Enter "Product Title"
        Select product category from required "Category section"
        Click on Submit Button
        Verify that message: "Featured img: This field is required." is displayed and "Gallery Images. This field is required" is displayed

         */


public class US_15_VendorProductAddition {

    AlloverCommerce_HomePage homePage;
    AlloverCommerce_VendorLoginPage loginPage;
    AlloverCommerce_VendorMyAcountPage myAccountPage;
    AlloverCommerce_StoreManagerPage storeManagerPage;
    AlloverCommerce_VendorAddProductPage addProductPage;
    AlloverCommerce_ShippingMenuPage shippingMenuPage;
    ClassLoader classLoader = getClass().getClassLoader();
    Robot robot;
    File file;
    private String imagePath;
    Actions actions;


    @BeforeMethod
    public void setUp() throws AWTException {

        homePage = new AlloverCommerce_HomePage();
        loginPage = new AlloverCommerce_VendorLoginPage();
        myAccountPage = new AlloverCommerce_VendorMyAcountPage();
        storeManagerPage = new AlloverCommerce_StoreManagerPage();
        addProductPage = new AlloverCommerce_VendorAddProductPage();
        shippingMenuPage = new AlloverCommerce_ShippingMenuPage();


        ExtentReportUtils.createTestReport("Test Report for US_15", "Testing options functionality when Vendor adds a new product");






    }

    @Test
    public void testCase01() throws AWTException {

        Driver.getDriver().get(ConfigReader.getProperty("allOverCommerce_url"));

        ExtentReportUtils.pass("User navigates to home page");

        homePage.signInIcon.click();
        loginPage.userNameInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("vendorPassword"));
        loginPage.signinButton.click();

        ExtentReportUtils.pass("Vendor successfully logs in.");


        JSUtils.JSscrollIntoView(homePage.myAccout);
        JSUtils.JSclickWithTimeout(homePage.myAccout);

        ExtentReportUtils.pass("Vendor accessed MyAccount page");


        myAccountPage.storeManager.click();
        WaitUtils.waitFor(3);
        ExtentReportUtils.pass("Vendor clicks on Store Manager button");

        ActionsUtils.actionsHoverOverOnElement(storeManagerPage.productsMenuTab);
        storeManagerPage.addNew.click();
        WaitUtils.waitFor(1);

        ExtentReportUtils.pass("Vendor clicks on Add New product button");

        addProductPage.productTitle.sendKeys("Chess");
        addProductPage.regularPrice.sendKeys("70");
        addProductPage.salePrice.sendKeys("50");

        ExtentReportUtils.pass("Vendor entered product title, regular price and sale price.");

        WaitUtils.waitFor(2);


//       JSUtils.JSscrollIntoView(shippingMenuPage.categoryCheckBox);
//       JSUtils.JSclickWithTimeout(shippingMenuPage.categoryCheckBox);
//
        //      ExtentReportUtils.pass("Vendor clicks on relevant Category checkbox");


        addProductPage.addImage1.click();
        WaitUtils.waitFor(2);

        addProductPage.selectImage1.click();
        WaitUtils.waitFor(3);

        file = new File(classLoader.getResource("test-data/chess2.jpg").getFile());
        imagePath = file.getAbsolutePath();

        StringSelection selection = new StringSelection(imagePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        robot = new Robot();
        
       robot.keyPress(KeyEvent.VK_CONTROL);
       robot.keyPress(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_V);
       robot.keyRelease(KeyEvent.VK_CONTROL);
       robot.delay(500);

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        WaitUtils.waitFor(8);
        actions = new Actions(Driver.getDriver());
        actions.moveToElement(addProductPage.selectPastedImage).click().perform();
        WaitUtils.waitFor(6);
//        robot.keyPress(KeyEvent.VK_G);
//        robot.keyRelease(KeyEvent.VK_G);
//        robot.keyRelease(KeyEvent.VK_SHIFT);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.delay(500);
//
//        robot.keyPress(KeyEvent.VK_META);
//        robot.keyPress(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_V);
//        robot.keyRelease(KeyEvent.VK_META);
//        robot.delay(500);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//        robot.delay(500);
//
//        robot.keyPress(KeyEvent.VK_ENTER);
//        robot.keyRelease(KeyEvent.VK_ENTER);
//
//        WaitUtils.waitFor(13);
//
//        JSUtils.JSclickWithTimeout(addProductPage.selectPastedImage);
//
        ExtentReportUtils.pass("Vendor successfully uploads an image.");
//
        WaitUtils.waitFor(2);
//
        ActionsUtils.actionsHoverOverOnElement(addProductPage.addImage2);
        JSUtils.JSclickWithTimeout(addProductPage.addImage2);
//
//
//
        JSUtils.JSclickWithTimeout(shippingMenuPage.secondImage);
        JSUtils.JSclickWithTimeout(addProductPage.addToGallery);
//
        ExtentReportUtils.pass("Vendor chose image from the Gallery");

        WaitUtils.waitFor(1);

        JSUtils.JSclickWithTimeout(shippingMenuPage.categoryCheckBox);
        WaitUtils.waitFor(1);

        ExtentReportUtils.pass("Vendor selected relevant check box from Category section");

        //        Enter a valid data into SKU input box
        shippingMenuPage.skuInput.clear();
        WaitUtils.waitFor(3);
        Faker faker = new Faker();
        String sku = String.valueOf(faker.number().numberBetween(2,2000));

        shippingMenuPage.skuInput.sendKeys(sku);

        ExtentReportUtils.pass("Vendor entered unique SKU in SKU input field");

        JSUtils.JSclickWithTimeout(addProductPage.manageStockCheckbox);

        WaitUtils.waitFor(1);

        shippingMenuPage.soldIndividuallyCheckBox.click();
        WaitUtils.waitFor(1);

        ExtentReportUtils.pass("Vendor clicked on Manage Stock and Sold Individually checkboxes");


        shippingMenuPage.shippingMenu.click();
        ExtentReportUtils.pass("Vendor clicked on Shipping Menu tab");
        WaitUtils.waitFor(1);

        shippingMenuPage.weightInput.sendKeys("2");
        shippingMenuPage.widthInput.sendKeys("20");
        shippingMenuPage.heightInput.sendKeys("15");
        WaitUtils.waitFor(1);

        ExtentReportUtils.pass("Vendor entered weight, width and height in relevant input fields.");

        Select dropdown = new Select(shippingMenuPage.processingTimeDropdown);
        dropdown.selectByIndex(0);
        WaitUtils.waitFor(1);

        ExtentReportUtils.pass("Vendor selects first option from dropdown menu");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.submitButton);
        addProductPage.submitButton.click();
        WaitUtils.waitFor(3);

        ExtentReportUtils.pass("Vendor clicked on Submit button.");

        assertEquals(addProductPage.publishedTag.getText(), "Published");

        ExtentReportUtils.pass("Success message is displayed: Product successfully published");


    }

    @Test
    public void testCase02(){


        Driver.getDriver().get(ConfigReader.getProperty("allOverCommerce_url"));

        ExtentReportUtils.pass("User navigates to home page");

        homePage.signInIcon.click();
        loginPage.userNameInput.sendKeys(ConfigReader.getProperty("allOverCommerce_vendorEmail"));
        loginPage.passwordInput.sendKeys(ConfigReader.getProperty("vendorPassword"));
        loginPage.signinButton.click();

        ExtentReportUtils.pass("Vendor successfully logs in.");


        JSUtils.JSscrollIntoView(homePage.myAccout);
        JSUtils.JSclickWithTimeout(homePage.myAccout);

        ExtentReportUtils.pass("Vendor accessed MyAccount page");


        myAccountPage.storeManager.click();
        WaitUtils.waitFor(3);
        ExtentReportUtils.pass("Vendor clicks on Store Manager button");

        ActionsUtils.actionsHoverOverOnElement(storeManagerPage.productsMenuTab);
        storeManagerPage.addNew.click();
        WaitUtils.waitFor(1);

        ExtentReportUtils.pass("Vendor clicks on Add New product button");

        addProductPage.productTitle.sendKeys("Chess");

        JSUtils.JSclickWithTimeout(shippingMenuPage.categoryCheckBox);
        WaitUtils.waitFor(1);

        ExtentReportUtils.pass("Vendor selected relevant check box from Category section");

        ActionsUtils.actionsHoverOverOnElement(addProductPage.submitButton);
        addProductPage.submitButton.click();
        WaitUtils.waitFor(2);

        ExtentReportUtils.pass("Vendor clicked on Submit button.");

        Assert.assertTrue(shippingMenuPage.displayMessage.isDisplayed());

        ActionsUtils.actionsScrollDown();
        ExtentReportUtils.passAndCaptureScreenshot("Error message displayed: Featured img: This field is required. Gallery Images: This field is required.");
        ExtentReportUtils.info("Test passed. Submitting a product with empty required fields is unsuccessful. ");
    }



    @AfterMethod
    public void tearDown(){

        ExtentReportUtils.flush();
        Driver.closeDriver();
    }



}