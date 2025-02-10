package myapp.tests;
import myapp.pages.AlloverCommerce_HomePage;
import myapp.pages.AlloverCommerce_VendorBillingAdressPage;
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
    AlloverCommerce_VendorBillingAdressPage adressesPage = new AlloverCommerce_VendorBillingAdressPage();


    protected WebDriver driver;


    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
        driver.get(ConfigReader.getProperty("allOverCommerce_url"));

    }

    @Test
    public void test1() throws IOException {

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
            actions.moveToElement(homePage.myAccout).click().perform();
            System.out.println(homePage.myAccoutText.getText());
            assertTrue(homePage.myAccoutText.getText().contains("My Account"));
        }
    }


    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}