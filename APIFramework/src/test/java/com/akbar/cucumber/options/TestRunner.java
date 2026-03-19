package com.akbar.cucumber.options;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = "src/test/java/com/akbar/features",
        glue = "com.akbar.stepdefinitions",
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports.json"},
        monochrome = false
)
@RunWith(Cucumber.class)
public class TestRunner {
}
