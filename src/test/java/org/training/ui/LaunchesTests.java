package org.training.ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.training.ui.steps.TestSteps;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LaunchesTests extends BaseUiTest {

    static final protected Logger LOGGER = LogManager.getLogger(LaunchesTests.class);

    @DataProvider(name = "launchesReportLinks")
    public static Object[][] launchesReportLinksClickMethods() {
        return new Object[][]{
                {"clickOnProductBugsReportLink", "Dpb"},
                {"clickOnAutomationBugsReportLink", "Dab"},
                {"clickOnSystemIssuesReportLink", "Dsi"},
                {"clickOnToInvestigateReportLink", "Dti"}
        };
    }

    @Test
    public void validateAllLaunchesList() {
        LOGGER.info(StringUtils.join("Running in thread #", Thread.currentThread().getName()));
        testSteps.openAllLaunchesPage();
        testSteps.checkLaunchesExist();
        LOGGER.info("All Launches list test passed.");
    }

    @Test(dataProvider = "launchesReportLinks")
    public void validateLaunchesReportsLinks(String linkClickMethodName, String expectedUrlText)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        testSteps.openAllLaunchesPage();

        LOGGER.info(StringUtils.join("Running in thread #", Thread.currentThread().getName()));
        Method launchReportLinkClick = TestSteps.class.getMethod(linkClickMethodName);
        launchReportLinkClick.invoke(testSteps);
        testSteps.checkCurrentUrlsContainsText(expectedUrlText);
        LOGGER.info("Launches reports links test passed.");
    }
}
