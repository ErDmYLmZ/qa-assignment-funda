package com.funda.tests.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.funda.tests",
        plugin = {"pretty", "json:target/cucumber-report.json"},
        tags = "@SmokeTest"
)
public class SmokeTestsRunner {
}

