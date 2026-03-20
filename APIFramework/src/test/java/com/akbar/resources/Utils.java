package com.akbar.resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {

    RequestSpecification req;

    public RequestSpecification requestSpecification() {
        RestAssured.baseURI = "http://216.10.245.166";
        req = new RequestSpecBuilder()
                .setBaseUri("http://216.10.245.166")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .build();

        return req;
    }
}
