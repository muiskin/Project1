package base_url;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.BeforeMethod;

public class CLBaseUrl {

    public static RequestSpecification spec;


    static {
        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://thinking-tester-contact-list.herokuapp.com")
                .build();
    }
}
