package myapp.pages;

import myapp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlloverCommerce_VendorLoginPage {

    public AlloverCommerce_VendorLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }



    @FindBy(id = "username")
    public WebElement userNameInput;

    @FindBy(id = "password")
    public WebElement passwordInput;

    @FindBy(id = "rememberme")
    public WebElement checkBox;

    @FindBy(xpath = "//button[@name='login']")
    public WebElement signinButton;

<<<<<<< HEAD


=======
>>>>>>> b0c3fbf1fefdbe09786bf96c44a484dc1b398157
}
