package org.training.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.training.BaseTest;
import org.training.model.TestUser;
import org.training.model.TestUserHelper;
import org.training.ui.steps.TestSteps;

public class BaseUiTest extends BaseTest {
    static final protected Logger LOGGER = LogManager.getLogger(BaseUiTest.class);
    protected TestSteps testSteps;
    protected static final TestUserHelper testUserHelper = new TestUserHelper(configHelper);
    protected TestUser testUser;

    @BeforeClass
    public void setUp() {
        configHelper.setUpSelenide();
        LOGGER.info("Set up successfully.");
    }
}
