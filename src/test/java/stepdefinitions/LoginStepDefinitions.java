package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AllPages;
import utilities.ConfigReader;
import utilities.ScenarioContext;


public class LoginStepDefinitions {

    AllPages allPages;


    @When("enter valid email\\({string}) for login")
    public void enterValidEmailForLogin(String validEmail) {
        allPages = new AllPages();
        allPages.getclLoginPage().email.sendKeys(ConfigReader.getProperty("EmailForLogin"));
        ScenarioContext.set("email",ConfigReader.getProperty("EmailForLogin"));
    }

    @And("enter valid password\\({string}) for login")
    public void enterValidPasswordForLogin(String validPass) {
        allPages = new AllPages();
        allPages.getclLoginPage().password.sendKeys(ConfigReader.getProperty("PasswordForLogin"));
        ScenarioContext.set("password",ConfigReader.getProperty("PasswordForLogin"));
    }

    @When("enter email\\({string}) for login")
    public void enterEmailForLogin(String email) {
        allPages = new AllPages();
        allPages.getclLoginPage().email.sendKeys(email);
        ScenarioContext.set("email",email);
    }

    @And("enter password\\({string}) for login")
    public void enterPasswordForLogin(String pass) {
        allPages = new AllPages();
        allPages.getclLoginPage().password.sendKeys(pass);
        ScenarioContext.set("password",pass);
    }

    @When("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        allPages = new AllPages();
        allPages.getclLoginPage().submit.click();
    }

    @Then("assert that error message is contains {string} for login")
    public void assertThatErrorMessageIsContainsForLogin(String arg0) throws InterruptedException {
        Thread.sleep(1000);
        allPages = new AllPages();
        assert allPages.getclLoginPage().error.getText().contains(arg0);
    }
}
