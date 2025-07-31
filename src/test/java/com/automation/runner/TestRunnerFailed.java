package com.automation.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "report/failed-test/failed-scenario.txt",
        glue = "com.automation.steps",
        plugin = {"rerun:report/failed-test/failed-scenario.txt"}
)
public class TestRunnerFailed {
}
