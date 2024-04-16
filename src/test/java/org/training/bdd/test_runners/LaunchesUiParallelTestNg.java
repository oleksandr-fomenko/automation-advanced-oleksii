package org.training.bdd.test_runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/org/training/bdd/ui/features",
        glue = {"org/training/bdd/ui/step_definitions", "org/training/bdd/ui/hooks"},
        tags = "@Regression"
)

public class LaunchesUiParallelTestNg extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
