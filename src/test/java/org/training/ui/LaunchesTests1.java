package org.training.ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.training.ui.steps.TestStepsSelenium;
import org.training.utils.ScreenshotUtil;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

@Execution(ExecutionMode.CONCURRENT)
public class LaunchesTests1 extends BaseUiTest {

    private ScreenshotUtil screenshotUtil;
    static final protected Logger LOGGER = LogManager.getLogger(LaunchesTests1.class);

    @BeforeClass
    public void preSetUp() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        testSteps = new TestStepsSelenium(driver, configHelper);
        screenshotUtil = new ScreenshotUtil(driver);
    }

    @BeforeMethod
    @BeforeEach
    public void setUp() {
        testUser = testUserHelper.getTestUser();
        testSteps.logIn(testUser);
    }

    @org.testng.annotations.Test
    @org.junit.jupiter.api.Test
    public void validateAllLaunchesList() {
        testSteps.openAllLaunchesPage();
        testSteps.checkLaunchesExist();
        testSteps.selectLaunchInfoText(1);
        LOGGER.info("All Launches list test passed.");
    }

    @AfterMethod
//    @AfterEach
    public void tearDown(ITestResult result) {
        testSteps.logOut();
        testUserHelper.returnTestUser(testUser);

        if (ITestResult.FAILURE == result.getStatus()) {
            screenshotUtil.takeScreenshot(result.getName());
        }
        testSteps.closeDriver();
        LOGGER.info("Tear down successful.");
    }

    @SneakyThrows
    private RemoteWebDriver getSauceLabsDriver() {
        ChromeOptions browserOptions = new ChromeOptions();
        browserOptions.setPlatformName("Windows 11");
        browserOptions.setBrowserVersion("latest");
        Map<String, Object> sauceOptions = new HashMap<>();
        sauceOptions.put("username", System.getenv("SAUCE_LABS_USERNAME"));
        sauceOptions.put("accessKey", System.getenv("SAUCE_LABS_ACCESS_KEY"));
        sauceOptions.put("build", "selenium-build-DXQGM");
        sauceOptions.put("name", "All Launches Test");
        browserOptions.setCapability("sauce:options", sauceOptions);
        URL url = new URL(configHelper.getSauceLabsUrl());

        return new RemoteWebDriver(url, browserOptions);
    }
}
