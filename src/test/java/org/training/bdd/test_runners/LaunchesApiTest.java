package org.training.bdd.test_runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/training/bdd/api/features",
        glue = {"org/training/bdd/api/step_definitions"},
        tags = "@Regression"
)
public class LaunchesApiTest {
}
