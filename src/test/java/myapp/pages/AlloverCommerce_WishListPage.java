package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_WishListPage {
    public AlloverCommerce_WishListPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
