package com.auto.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin={
                "pretty"
//                        "html:target/cucumber",
//                        "json:target/cucumber.json"
                },
                features="src/test/resources/scenarios",
                glue={"com.auto.steps","Hooks"},
                tags="@Test"
                )
public class TestRunner {

}

