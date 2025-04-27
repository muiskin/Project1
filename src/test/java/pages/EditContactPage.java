package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class EditContactPage {

    public EditContactPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "/html/body/div/header/h1")
    public WebElement EditContactHeader;
}
