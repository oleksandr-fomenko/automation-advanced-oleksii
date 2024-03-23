package org.training.ui;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

@Listeners({ReportPortalTestNGListener.class})
public class BaseTest {
    static final Logger LOGGER = LogManager.getLogger(BaseTest.class);

    @Test
    public void smokeTest() {
        LOGGER.warn("Logger Test.");
    }
}
