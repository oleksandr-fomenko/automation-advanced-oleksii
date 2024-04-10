package org.training.ui;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.training.ui.steps.TestSteps;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LaunchesTests2 extends BaseUiTest {

    static final protected Logger LOGGER = LogManager.getLogger(LaunchesTests1.class);

    @BeforeMethod
    public void setUp() {
        testUser = testUserHelper.getTestUser();
        testSteps.logIn(testUser);
    }

    @DataProvider(name = "launchesReportLinks")
    public static Object[][] launchesReportLinksClickMethods() {
        return new Object[][]{
                {"clickOnProductBugsReportLink", "Dpb"},
                {"clickOnAutomationBugsReportLink", "Dab"},
                {"clickOnSystemIssuesReportLink", "Dsi"},
                {"clickOnToInvestigateReportLink", "Dti"}
        };
    }

    @Test(dataProvider = "launchesReportLinks")
    public void validateLaunchesReportsLinks(String linkClickMethodName, String expectedUrlText)
            throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        testSteps.openAllLaunchesPage();

        Method launchReportLinkClick = TestSteps.class.getMethod(linkClickMethodName);
        launchReportLinkClick.invoke(testSteps);
        testSteps.checkCurrentUrlsContainsText(expectedUrlText);
        LOGGER.info("Launches reports links test passed.");
    }

    @AfterMethod
    public void tearDown() {
        testSteps.logOut();
        testUserHelper.returnTestUser(testUser);
        LOGGER.info("Tear down successful.");
    }
}
