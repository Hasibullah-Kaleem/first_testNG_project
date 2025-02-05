package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_ShippingAdressPage {
    public AlloverCommerce_ShippingAdressPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
