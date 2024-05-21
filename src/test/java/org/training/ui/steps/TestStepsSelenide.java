package org.training.ui.steps;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.configuration.ConfigHelper;
import org.training.model.TestUser;
import org.training.ui.pages.dashboadres.DashboardsPage;
import org.training.ui.pages.launches.AllLaunchesPage;
import org.training.ui.pages.login.LoginPage;

import java.time.Duration;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestStepsSelenide implements TestSteps {
    private final ConfigHelper configHelper;
    private AllLaunchesPage allLaunchesPage;

    public TestStepsSelenide(ConfigHelper configHelper) {
        this.configHelper = configHelper;
        allLaunchesPage = new AllLaunchesPage(configHelper.getBaseUrl(), configHelper.getProjectName());
    }

    static final Logger LOGGER = LogManager.getLogger(TestStepsSelenide.class);

    public void logIn(TestUser testUser) {
        String baseUrl = configHelper.getBaseUrl();
        LoginPage loginPage = new LoginPage(baseUrl);
        open(loginPage.getUrl());
        SelenideElement loginInput = loginPage.getLoginInput();
        loginInput.shouldBe(visible);
        LOGGER.info("Login page is opened.");

        loginInput.setValue(testUser.username());
        loginPage.getPasswordInput().setValue(testUser.userPassword());
        loginPage.getLoginButton().click();

        DashboardsPage dashboardsPage = new DashboardsPage(baseUrl, configHelper.getProjectName());
        dashboardsPage.getPageTitle().shouldBe(visible);
        LOGGER.info("Login successful.");
    }

    public void logOut() {
        int notificationDisappearDelay = 15;
        allLaunchesPage.getSignInSuccessNote().should(disappear, Duration.ofSeconds(notificationDisappearDelay));
        allLaunchesPage.getUserMenuIcon().click();
        allLaunchesPage.getUserMenu().getMenu().shouldBe(visible);
        allLaunchesPage.getUserMenu().getLogOutLink().click();
        LOGGER.info("Logout successful.");
    }

    public void openAllLaunchesPage() {
        open(allLaunchesPage.getUrl());
        allLaunchesPage.getPageSwitchDropdownTitle().shouldBe(visible);
        LOGGER.info("All Launches page is opened.");
    }

    public void clickOnLaunchProductBugsReportLink(int launchIndex) {
        allLaunchesPage.getLaunchProductBugsReportLink(launchIndex).click();
    }

    public void clickOnLaunchAutomationBugsReportLink(int launchIndex) {
        allLaunchesPage.getLaunchAutomationBugsReportLink(launchIndex).click();
    }

    public void clickOnLaunchSystemIssuesReportLink(int launchIndex) {
        allLaunchesPage.getLaunchSystemIssuesReportLink(launchIndex).click();
    }

    public void clickOnLaunchToInvestigateReportLink(int launchIndex) {
        allLaunchesPage.getLaunchToInvestigateReportLink(launchIndex).click();
    }

    public void clickOnProductBugsReportLink() {
        allLaunchesPage.getProductBugsReportLink().click();
    }

    public void clickOnAutomationBugsReportLink() {
        allLaunchesPage.getAutomationBugsReportLink().click();
    }

    public void clickOnSystemIssuesReportLink() {
        allLaunchesPage.getSystemIssuesReportLink().scrollIntoView(true).click();
    }

    public void clickOnToInvestigateReportLink() {
        allLaunchesPage.getToInvestigateReportLink().click();
    }

    public void checkLaunchesExist() {
        allLaunchesPage = new AllLaunchesPage(configHelper.getBaseUrl(), configHelper.getProjectName());
        int numberOfLaunches = allLaunchesPage.getLaunches().size();
        assertTrue(numberOfLaunches > 0, "No launches found in a project.");
        LOGGER.info("Launches existence check passed.");
    }

    public void checkCurrentUrlsContainsText(String urlText) {
        assertTrue(url().contains(urlText), "Current url doesn't contain provided text.");
        LOGGER.info("Current URL check passed.");
    }

    @Override
    public void selectLaunchInfoText(int launchNumber) {

    }

    @Override
    public void closeDriver() {

    }
}
