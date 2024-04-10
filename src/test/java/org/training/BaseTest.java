package org.training;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.Listeners;
import org.training.configuration.ConfigHelper;

@Listeners({ReportPortalTestNGListener.class})
public class BaseTest {
    protected static ConfigHelper configHelper = new ConfigHelper();
}
