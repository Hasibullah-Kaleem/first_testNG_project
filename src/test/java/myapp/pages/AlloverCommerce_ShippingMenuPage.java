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

    @FindBy(xpath = "//input[@value='1669']")
    public WebElement categoryCheckBox;

    @FindBy(xpath = "//img[@src='https://allovercommerce.com/wp-content/uploads/2025/01/Combo_of_The_Honour_of_Staunton_Series_Weighted_Chess_Pieces_in_Sheesham_and_Natural_Boxwood.jpg-300x200.webp']")
    public WebElement secondImage;

    @FindBy(id = "sku")
    public WebElement skuInput;

    @FindBy(id = "sold_individually")
    public WebElement soldIndividuallyCheckBox;

    @FindBy(xpath = "//*[@id='wcfm_products_simple_submit']/div")
    public WebElement displayMessage;

}
