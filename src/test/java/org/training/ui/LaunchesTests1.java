package org.training.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@Execution(ExecutionMode.CONCURRENT)
public class LaunchesTests1 extends BaseUiTest {

    static final protected Logger LOGGER = LogManager.getLogger(LaunchesTests1.class);

    @BeforeMethod
    @BeforeEach
    public void setUp() {
        testUser = testUserHelper.getTestUser();
        testSteps.logIn(testUser);
    }

    @org.testng.annotations.Test
    @org.junit.jupiter.api.Test
    public void validateAllLaunchesList() {
        testSteps.openAllLaunchesPage();
        testSteps.checkLaunchesExist();
        LOGGER.info("All Launches list test passed.");
    }

    @AfterMethod
    @AfterEach
    public void tearDown() {
        testSteps.logOut();
        testUserHelper.returnTestUser(testUser);
        LOGGER.info("Tear down successful.");
    }
}
