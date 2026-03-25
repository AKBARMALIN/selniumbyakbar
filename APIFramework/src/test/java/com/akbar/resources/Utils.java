package com.akbar.resources;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {

    RequestSpecification req;

    public RequestSpecification requestSpecification() throws FileNotFoundException {
        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));

        req = new RequestSpecBuilder()
                .setBaseUri(getGlobalValues("baseUrl"))
                .addQueryParam("key", "qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(log))
                .addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON)
                .build();

        return req;
    }

    public static String getGlobalValues(String key) throws FileNotFoundException {
        Properties props = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/java/com/akbar/resources/global.properties");
        try {
            props.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return props.getProperty(key);
    }
}
