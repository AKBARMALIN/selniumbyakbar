package com.akbar.stepdefinitions;

import com.akbar.pojo.AddPlace;
import com.akbar.pojo.Location;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import java.util.Arrays;

public class StepDefinition {

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
    }

    @When("user calls {string} with POST http request")
    public void user_calls_with_post_http_request(String string) {
    }

    @Then("the API call is successful with status code {int}")
    public void the_api_call_is_successful_with_status_code(Integer int1) {
    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String string, String string2) {
    }
}
