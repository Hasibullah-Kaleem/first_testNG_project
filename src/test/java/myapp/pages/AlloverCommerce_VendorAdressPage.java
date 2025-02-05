package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_VendorAdressPage {
    public AlloverCommerce_VendorAdressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//main[@id='main']//div[3]//a")
    public WebElement billingAdressButton;
}
