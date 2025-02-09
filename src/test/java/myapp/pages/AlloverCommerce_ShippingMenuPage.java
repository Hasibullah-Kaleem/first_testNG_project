package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_ShippingMenuPage {

    public AlloverCommerce_ShippingMenuPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "wcfm_products_manage_form_shipping_head")
    public WebElement shippingMenu;

    @FindBy(id = "weight")
    public WebElement weightInput;

    @FindBy(id = "length")
    public WebElement lengthInput;

    @FindBy(id = "width")
    public WebElement widthInput;

    @FindBy(id = "height")
    public WebElement heightInput;

    @FindBy(id = "shipping_class")
    public WebElement shippingClassDropdown;

    @FindBy(id = "_wcfmmp_processing_time")
    public WebElement processingTimeDropdown;

}
