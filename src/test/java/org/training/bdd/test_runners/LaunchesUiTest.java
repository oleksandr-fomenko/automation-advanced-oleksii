package org.training.bdd.test_runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/training/bdd/ui/features",
        glue = {"org/training/bdd/ui/step_definitions", "org/training/bdd/ui/hooks"},
        tags = "@Regression"
)
public class LaunchesUiTest {
}
