package org.training.ui;

import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class BaseTest {
    static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @Test
    public void smokeTest() {
        LOGGER.warn("Logger Test.");
    }
}
