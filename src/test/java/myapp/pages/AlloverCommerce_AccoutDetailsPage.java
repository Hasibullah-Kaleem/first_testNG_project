package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_AccoutDetailsPage {
    public AlloverCommerce_AccoutDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
