package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ContactDetailsPage {

    public ContactDetailsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "edit-contact")
    public WebElement editContactButton;

    @FindBy(id = "firstName")
    public WebElement firstName;

    @FindBy(id = "lastName")
    public WebElement lastName;

}
