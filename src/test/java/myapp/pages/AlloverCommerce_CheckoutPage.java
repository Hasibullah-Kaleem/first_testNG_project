package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_CheckoutPage {
    public AlloverCommerce_CheckoutPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
