package org.training.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.training.ui.steps.TestSteps;

public class LaunchesTests extends BaseUiTest {

    static final protected Logger LOGGER = LogManager.getLogger(LaunchesTests.class);

    @Test
    public void validateAllLaunchesList() {
        TestSteps testSteps = new TestSteps();
        testSteps.logIn(testUserHelper.getTestUser(configHelper));
        testSteps.openAllLaunchesPage();
        testSteps.checkLaunchesExist();
        LOGGER.info("All Launches list test passed.");
    }
}
