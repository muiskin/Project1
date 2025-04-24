package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static base_url.CLBaseUrl.spec;
import static io.restassured.RestAssured.given;
import static stepdefinitions.RegistrationStepDefinitions.*;

public class APIStepDefinitions {

    @Then("assert that the user create via API")
    public void assert_that_the_user_create_via_api() {

        spec.pathParams("first", "users", "second", "login");

        Map<String,String> expectedData= new HashMap<>();
        expectedData.put("email",email);
        expectedData.put("password",password);

        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.then().statusCode(200);

    }

    @And("assert that the user cannot created via API")
    public void assertThatTheUserCannotCreatedViaAPI() {
        spec.pathParams("first", "users", "second", "login");

        Map<String,String> expectedData= new HashMap<>();
        expectedData.put("email",email);
        expectedData.put("password",password);

        Response response = given(spec).body(expectedData).post("{first}/{second}");
        response.then().statusCode(401);
    }
}