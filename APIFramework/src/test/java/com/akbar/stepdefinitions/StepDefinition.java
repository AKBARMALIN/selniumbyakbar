package com.akbar.stepdefinitions;

import com.akbar.pojo.AddPlace;
import com.akbar.pojo.Location;
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

public class StepDefinition {

    ResponseSpecification res;
    RequestSpecification resSpec;
    Response response;

    @Given("Add place payload")
    public void add_place_payload() {
        RestAssured.baseURI = "http://216.10.245.166";

        Location location = new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);

        AddPlace addPlace = new AddPlace();
        addPlace.setAccuracy(50);
        addPlace.setAddress("29, side layout, cohen 09");
        addPlace.setLanguage("French-IN");
        addPlace.setName("Frontline house");
        addPlace.setPhone_number("(+91) 983 893 3937");
        addPlace.setWebsite("http://google.com");
        addPlace.setTypes(Arrays.asList("shoe park", "shop"));
        addPlace.setLocation(location);

        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("http://216.10.245.166")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .build();

        res = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();


        resSpec = given().spec(req).body(addPlace);
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
