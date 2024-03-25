package org.training.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LaunchesTests extends BaseTest {

    static final Logger LOGGER = LogManager.getLogger(LaunchesTests.class);

    @Test
    public void validateAllLaunchesList() {
        TestSteps testSteps = new TestSteps();
        testSteps.logIn();
        testSteps.openAllLaunchesPage();
        testSteps.checkLaunchesExist();
        LOGGER.info("All Launches list test passed.");
    }
}
