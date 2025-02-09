package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_VendorAddProductPage {
    public AlloverCommerce_VendorAddProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//select[@id='product_type']")
    public WebElement productTypeDropdown;
    @FindBy(id = "featured_img_display")
    public WebElement addImage1;
    @FindBy(xpath = "//button[@class='browser button button-hero']")
    public WebElement selectImage1;
    @FindBy(id = "gallery_img_gimage_0_display")
    public WebElement addImage2;
    @FindBy(id = "__wp-uploader-id-4")
    public WebElement selectImage2;
    @FindBy(xpath = "(//*[@id='menu-item-upload'])[2]")
    public WebElement uploadImageTab;
    @FindBy(xpath = "//button[contains(@class, 'media-button-select')]") // //button[text()='Select']
    public WebElement selectPastedImage;
    @FindBy(xpath = "(//button[contains(text(), 'Add to Gallery')])[2]")
    public WebElement addToGallery;
    @FindBy(id = "pro_title")
    public WebElement productTitle;
    @FindBy(xpath = "//input[@id='regular_price']")
    public WebElement regularPrice;
    @FindBy(xpath = "//input[@id='sale_price']")
    public WebElement salePrice;
    @FindBy(xpath = "//body[@id='tinymce']") //there is an Iframe
    public WebElement shortDescription;
    @FindBy(xpath = "//body[@id='tinymce']") //there is an Iframe
    public WebElement description;
    @FindBy(xpath = "//input[@id='is_virtual']")
    public WebElement virtualCheckbox;
    @FindBy(xpath = "//input[@id='is_downloadable']")
    public WebElement downloadableCheckbox;
    @FindBy(xpath = "//input[@data-super_parent='399']")
    public WebElement clothesCategory;
    @FindBy(xpath = "//input[@data-super_parent='459']")
    public WebElement defactoProductBrand;
    @FindBy(xpath = "//input[@id='manage_stock']")
    public WebElement manageStockCheckbox;
    @FindBy(xpath = "//input[@id='stock_qty']")
    public WebElement stockQuantity;
    @FindBy(xpath = "//input[@value='Submit']")
    public WebElement submitButton;
    @FindBy(xpath = "//span[text()='Published']")
    public WebElement publishedTag;
    @FindBy(xpath = "//*[@id='wcfm_products_simple_submit']/div")
    public WebElement incorrectInput;
}
