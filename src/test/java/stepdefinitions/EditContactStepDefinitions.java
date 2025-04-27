package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AllPages;

import static org.junit.Assert.assertEquals;

public class EditContactStepDefinitions {

    AllPages allPages;
    public WebElement firstRowNameColumn;
    public String name;

    @When("the user clicks the exist contact")
    public void theUserClicksTheExistContact() {
        allPages = new AllPages();
        this.firstRowNameColumn = allPages.getContactListPage().webTable.findElement(By.xpath("./tr[1]/td[2]"));
        this.name = this.firstRowNameColumn.getText();
        this.firstRowNameColumn.click();


    }

    @Then("assert that the name the user clicked on and the name on the edit page are the same")
    public void assert_that_the_name_the_user_clicked_on_and_the_name_on_the_edit_page_are_the_same()  {
        allPages = new AllPages();

        String firstNameContactDetails = allPages.getContactDetailsPage().firstName.getText();
        String lastNameContactDetails = allPages.getContactDetailsPage().lastName.getText();
        String fullName = allPages.getContactDetailsPage().firstName.getText()+" "+allPages.getContactDetailsPage().lastName.getText();
        assertEquals(this.name, fullName);

    }

    @And("the user clicks the edit button")
    public void theUserClicksTheEditButton() {
        allPages = new AllPages();
        allPages.getContactDetailsPage().editContactButton.click();
    }

    @Then("assert that edit contact header displayed")
    public void assertThatEditContactHeaderDisplayed() {
        allPages = new AllPages();
        assert allPages.getEditContactPage().EditContactHeader.isDisplayed();
    }
}
