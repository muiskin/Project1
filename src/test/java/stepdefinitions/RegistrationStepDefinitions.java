package stepdefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ScenarioContext;

public class RegistrationStepDefinitions {

    AllPages allPages = new AllPages();


    @Given("user goes to home page")
    public void user_goes_to_home_page() {
        Driver.getDriver().get(ConfigReader.getProperty("CLHomePageUrl"));
    }

    @When("user clicks the sign up page")
    public void user_clicks_the_sign_up_page() {
        allPages = new AllPages();
        allPages.getclLoginPage().signupButton.click();
    }

    @When("enter firstname {string}")
    public void enter_firstname(String firstname) {
        allPages = new AllPages();
        allPages.getClSignupPage().firstname.sendKeys(firstname);
    }

    @When("enter lastname {string}")
    public void enter_lastname(String lastname) {
        allPages = new AllPages();
        allPages.getClSignupPage().lastname.sendKeys(lastname);
    }

    @When("enter email {string}")
    public void enter_email(String email) {
        allPages = new AllPages();
        if (email.equalsIgnoreCase("Faker")) {
            String FakeEmail = Faker.instance().internet().emailAddress();
            allPages.getClSignupPage().email.sendKeys(FakeEmail);
            ScenarioContext.set("email",FakeEmail);
        } else {
            allPages.getClSignupPage().email.sendKeys(email);
            ScenarioContext.set("email",email);
        }

    }

    @When("enter password {string}")
    public void enter_password(String password) {
        allPages = new AllPages();
        allPages.getClSignupPage().password.sendKeys(password);
        ScenarioContext.set("password",password);

    }

    @When("enter submit button")
    public void enter_submit_button() {
        allPages = new AllPages();
        allPages.getClSignupPage().submitButton.click();
    }

    @Then("assert that logout button is displayed")
    public void assertThatLogoutButtonIsDisplayed() {
        allPages = new AllPages();
        assert allPages.getCLHomePage().logoutButton.isDisplayed();
    }

    @Then("close driver")
    public void closeDriver() {
        Driver.closeDriver();
    }


    @Then("assert that error message is contains {string}")
    public void assertThatErrorMessageIsContains(String errorFirstname) throws InterruptedException {
        Thread.sleep(1000);
        allPages = new AllPages();
        assert allPages.getClSignupPage().error.getText().contains(errorFirstname);
    }

}
