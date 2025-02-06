package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_StoreManagerPage {
    public AlloverCommerce_StoreManagerPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(partialLinkText = "Products")
    public WebElement productsMenuTab;

    @FindBy(partialLinkText = "Add New")
    public WebElement addNew;
}
