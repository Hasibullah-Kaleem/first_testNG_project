package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_CartPage {
    public AlloverCommerce_CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
