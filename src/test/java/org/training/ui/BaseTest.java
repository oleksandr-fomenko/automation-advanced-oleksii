package org.training.ui;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Listeners;
import org.training.configuration.SelenideConfigHelper;

import java.io.IOException;

@Listeners({ReportPortalTestNGListener.class})
public class BaseTest {
    static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    SelenideConfigHelper selenideConfigHelper;

    {
        try {
            selenideConfigHelper = new SelenideConfigHelper();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
