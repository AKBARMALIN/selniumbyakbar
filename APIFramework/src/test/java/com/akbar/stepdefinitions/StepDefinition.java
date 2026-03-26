package com.akbar.stepdefinitions;

import com.akbar.resources.TestDataBuilder;
import com.akbar.resources.Utils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {

    ResponseSpecification res;
    RequestSpecification resSpec;
    Response response;
    TestDataBuilder data;

    public StepDefinition() {
        data = new TestDataBuilder();
    }

    @Given("Add place payload with {string} {string} {string}")
    public void add_place_payload_with(String name, String language, String address) throws FileNotFoundException {
        resSpec = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
    }

    @When("user calls {string} with POST http request")
    public void user_calls_with_post_http_request(String string) {
        res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        response = resSpec.when().post("/maps/api/place/add/json")
                .then().spec(res)
                .extract().response();
    }

    @Then("the API call is successful with status code {int}")
    public void the_api_call_is_successful_with_status_code(Integer int1) {
        Assert.assertEquals(response.getStatusCode(), int1.intValue());
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        Assert.assertEquals(response.jsonPath().get(key).toString(), value);
    }
}
