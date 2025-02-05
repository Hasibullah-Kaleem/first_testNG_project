package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_CompareProductPage {
    public AlloverCommerce_CompareProductPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
