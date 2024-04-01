package org.training.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.training.BaseTest;
import org.training.model.TestUser;
import org.training.model.TestUserHelper;
import org.training.ui.steps.TestSteps;

public class BaseUiTest extends BaseTest {
    static final protected Logger LOGGER = LogManager.getLogger(BaseUiTest.class);
    protected final TestSteps testSteps = new TestSteps(configHelper);
    protected final TestUserHelper testUserHelper = new TestUserHelper(configHelper);
    protected TestUser testUser;

    @BeforeClass
    public void setUp() {
        configHelper.setUpSelenide();
        LOGGER.info("Set up successfully.");
        testUser = testUserHelper.getTestUser();
        testSteps.logIn(testUser);
    }

    @AfterClass
    public void tearDown() {
        testUserHelper.returnTestUser(testUser);
        LOGGER.info("Tear down successful.");
    }
}
