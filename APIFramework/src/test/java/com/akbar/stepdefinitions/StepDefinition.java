package com.akbar.stepdefinitions;

import com.akbar.pojo.AddPlace;
import com.akbar.pojo.Location;
import com.akbar.resources.TestDataBuilder;
import com.akbar.resources.Utils;
import com.fasterxml.jackson.core.json.UTF8DataInputJsonParser;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Assert;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class StepDefinition extends Utils {

    ResponseSpecification res;
    RequestSpecification resSpec;
    Response response;
    TestDataBuilder data;

    @Given("Add place payload")
    public void add_place_payload() {


        res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();


        resSpec = given().spec(requestSpecification()).body(data.addPlacePayload());
    }

    @When("user calls {string} with POST http request")
    public void user_calls_with_post_http_request(String string) {
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
