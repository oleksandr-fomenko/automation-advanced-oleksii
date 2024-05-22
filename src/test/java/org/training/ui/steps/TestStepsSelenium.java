package org.training.ui.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.training.configuration.ConfigHelper;
import org.training.model.TestUser;
import org.training.ui.pages.dashboadres.DashboardsPageSelenium;
import org.training.ui.pages.launches.AllLaunchesPageSelenium;
import org.training.ui.pages.login.LoginPageSelenium;
import org.training.utils.DriverWithEvents;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStepsSelenium implements TestSteps {
    private final ConfigHelper configHelper;
    WebDriver driver;
    DriverWithEvents driverWithEvents;
    private final AllLaunchesPageSelenium allLaunchesPage;

    public TestStepsSelenium(WebDriver driver, ConfigHelper configHelper) {
        this.configHelper = configHelper;
        this.driver = driver;
        this.driverWithEvents = new DriverWithEvents(LOGGER, driver);
        this.allLaunchesPage = new AllLaunchesPageSelenium(driverWithEvents, configHelper.getBaseUrl(), configHelper.getProjectName());
    }

    static final Logger LOGGER = LogManager.getLogger(TestStepsSelenium.class);

    public void logIn(TestUser testUser) {
        String baseUrl = configHelper.getBaseUrl();

        LoginPageSelenium loginPage = new LoginPageSelenium(driverWithEvents, baseUrl);
        driver.get(loginPage.getUrl());

        WebElement loginInput = loginPage.waitForLoginInput();
        LOGGER.info("Login page is opened.");

        loginInput.sendKeys(testUser.username());
        loginPage.getPasswordInput().sendKeys(testUser.userPassword());
        loginPage.getLoginButton().click();

        DashboardsPageSelenium dashboardsPage = new DashboardsPageSelenium(driverWithEvents, baseUrl, configHelper.getProjectName());
        dashboardsPage.waitForPageTitle();
        LOGGER.info("Login successful.");
    }

    @Override
    public void openAllLaunchesPage() {
        driver.get(allLaunchesPage.getUrl());

        allLaunchesPage.waitForPageSwitchDropdownTitle();
        LOGGER.info("All Launches page is opened.");
    }

    @Override
    public void checkLaunchesExist() {
        allLaunchesPage.waitForFirstLaunch();

        int numberOfLaunches = allLaunchesPage.getLaunches().size();
        assertTrue(numberOfLaunches > 0, "No launches found in a project.");
        LOGGER.info("Launches existence check passed.");
    }

    @Override
    public void logOut() {
        int notificationDisappearDelay = 15;
        allLaunchesPage.waitForSignInSuccessNoteDisappear(notificationDisappearDelay);
        allLaunchesPage.getUserMenuIcon().click();
        allLaunchesPage.getUserMenu().waitForMenu();
        allLaunchesPage.getUserMenu().getLogOutLink().click();
        LOGGER.info("Logout successful.");
    }

    @Override
    public void checkCurrentUrlsContainsText(String text) {

    }

    @Override
    public void selectLaunchInfoText(int launchNumber) {
        allLaunchesPage.selectLaunchInfoText(launchNumber);
    }

    public void closeDriver() {
        driver.close();
    }
}
