package org.training.ui;

import com.codeborne.selenide.SelenideElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.configuration.ConfigHelper;
import org.training.ui.pages.dashboadres.DashboardsPage;
import org.training.ui.pages.launches.AllLaunchesPage;
import org.training.ui.pages.login.LoginPage;

import java.io.IOException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSteps {
    static final Logger LOGGER = LogManager.getLogger(TestSteps.class);
    private LoginPage loginPage;
    private DashboardsPage dashboardsPage;
    private AllLaunchesPage allLaunchesPage;
    private final ConfigHelper configHelper;

    {
        try {
            configHelper = new ConfigHelper();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void logIn() {
        String baseUrl = configHelper.getBaseUrl();
        loginPage = new LoginPage(baseUrl);
        open(loginPage.getUrl());
        SelenideElement loginInput = loginPage.getLoginInput();
        loginInput.shouldBe(visible);
        LOGGER.info("Login page is opened.");

        loginInput.setValue(configHelper.getTestUsername());
        loginPage.getPasswordInput().setValue(configHelper.getTestUserPassword());
        loginPage.getLoginButton().click();

        dashboardsPage = new DashboardsPage(baseUrl, configHelper.getProjectName());
        dashboardsPage.getPageTitle().shouldBe(visible);
        LOGGER.info("Login successful.");
    }

    public void openAllLaunchesPage() {
        allLaunchesPage = new AllLaunchesPage(configHelper.getBaseUrl(), configHelper.getProjectName());
        open(allLaunchesPage.getUrl());
        allLaunchesPage.getPageSwitchDropdownTitle().shouldBe(visible);
        LOGGER.info("All Launches page is opened.");
    }

    public void checkLaunchesExist() {
        allLaunchesPage = new AllLaunchesPage(configHelper.getBaseUrl(), configHelper.getProjectName());
        int numberOfLaunches = allLaunchesPage.getLaunches().size();
        assertTrue(numberOfLaunches > 0, "No launches found in a project.");
        LOGGER.info("Launches existence check passed.");
    }
}
