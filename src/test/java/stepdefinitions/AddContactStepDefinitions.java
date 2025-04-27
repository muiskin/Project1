package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AllPages;

import java.util.ArrayList;
import java.util.List;

public class AddContactStepDefinitions {

    AllPages allPages;
    public String firstName;
    public String lastName;

    @Then("assert that add contact button displayed")
    public void assert_that_add_contact_button_displayed() {
       allPages = new AllPages();
       assert allPages.getContactListPage().addContact.isDisplayed();
    }

    @When("the user clicks the add a new contact button")
    public void theUserClicksTheAddANewContactButton() {
        allPages = new AllPages();
        allPages.getContactListPage().addContact.click();
    }

    @And("the user enter valid firstname {string}")
    public void theUserEnterValidFirstname(String firstname) throws InterruptedException {
        Thread.sleep(2000);
        allPages = new AllPages();
        if (firstname.equalsIgnoreCase("Faker")) {
            this.firstName = Faker.instance().name().firstName();
            allPages.getAddContactPage().firstName.sendKeys(this.firstName);
        } else {
            allPages.getAddContactPage().firstName.sendKeys(firstname);
            this.firstName = firstname;
        }
    }

    @And("the user enter valid lastname {string}")
    public void theUserEnterValidLastname(String lastname) {
        allPages = new AllPages();
        if (lastname.equalsIgnoreCase("Faker")) {
            this.lastName = Faker.instance().name().lastName();
            allPages.getAddContactPage().lastName.sendKeys(this.lastName);
        } else {
            allPages.getAddContactPage().lastName.sendKeys(lastname);
            this.lastName = lastname;
        }
    }

    @And("the user clicks the submit button")
    public void theUserClicksTheSubmitButton() {
        allPages = new AllPages();
        allPages.getAddContactPage().submitButton.click();
    }

    @Then("assert that user added")
    public void assertThatUserAdded() throws InterruptedException {
        Thread.sleep(2000);
        allPages = new AllPages();

        int rowSize = allPages.getContactListPage().webTable.findElements(By.xpath("./tr")).size();

        List<WebElement> rows = new ArrayList<>();

        for (int i = 0; i < (rowSize+1); i++) {

            rows = allPages.getContactListPage().webTable.findElements(By.xpath("./tr["+i+"]/td[2]"));

        }

        String fullName = this.firstName+" "+this.lastName;

        boolean found = false;
        for (WebElement w: rows){
            if(w.getText().equals(fullName)){
                 found = true;
                 break;
            }
        }
        if (found){
            assert true;
        }

    }

    @Then("assert that add contact page error message is contains {string}")
    public void assertThatAddContactPageErrorMessageIsContains(String error) throws InterruptedException {
        Thread.sleep(1000);
        allPages = new AllPages();
        assert allPages.getAddContactPage().error.getText().contains(error);
    }

    @When("the user clicks the recently added contact")
    public void theUserClicksTheRecentlyAddedContact() {
        allPages = new AllPages();
        WebElement firstRowNameColumn = allPages.getContactListPage().webTable.findElement(By.xpath("./tr[1]/td[2]"));
        firstRowNameColumn.click();
    }

    @Then("assert that edit contact button is displayed")
    public void assertThatEditContactButtonIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        allPages = new AllPages();
        assert allPages.getContactDetailsPage().editContactButton.isDisplayed();
    }
}
