package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_StoreManagerPage {
    public AlloverCommerce_StoreManagerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
