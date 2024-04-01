package org.training.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.training.BaseTest;
import org.training.model.TestUserHelper;

public class BaseUiTest extends BaseTest {
    static final protected Logger LOGGER = LogManager.getLogger(BaseUiTest.class);
    protected final TestUserHelper testUserHelper = new TestUserHelper();

    @BeforeClass
    public void setUp() {
        configHelper.setUpSelenide();
        LOGGER.info("Set up successfully.");
    }
}
