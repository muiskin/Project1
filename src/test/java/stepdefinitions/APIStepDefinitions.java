package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import utilities.ScenarioContext;

import java.util.HashMap;
import java.util.Map;

import static base_url.CLBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static stepdefinitions.RegistrationStepDefinitions.*;

public class APIStepDefinitions {

    @Then("assert that the user login via API")
    public void assert_that_the_user_login_via_api() {

        spec.pathParams("first", "users", "second", "login");

        Map<String,String> expectedData= new HashMap<>();
        expectedData.put("email", ScenarioContext.get("email"));
        expectedData.put("password",ScenarioContext.get("password"));

        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.then().statusCode(200);

    }

    @And("assert that the user cannot login via API")
    public void assertThatTheUserCannotLoginViaAPI() {
        spec.pathParams("first", "users", "second", "login");

        Map<String,String> expectedData= new HashMap<>();
        expectedData.put("email",ScenarioContext.get("email"));
        expectedData.put("password",ScenarioContext.get("password"));

        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.then().statusCode(401);
    }
}