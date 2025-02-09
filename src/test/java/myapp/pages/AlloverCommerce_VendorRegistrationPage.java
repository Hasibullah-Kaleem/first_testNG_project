package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_VendorRegistrationPage {
    public AlloverCommerce_VendorRegistrationPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
