package org.training.bdd.ui.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.StringUtils;
import org.training.bdd.context.Context;
import org.training.bdd.context.Memory;
import org.training.model.TestUser;
import org.training.ui.steps.TestStepsSelenide;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class StepDefinitions {
    TestStepsSelenide testSteps;

    @Given("I log in to Report Portal")
    public void logInToReportPortal() {
        testSteps = new TestStepsSelenide(Context.getConfigHelper());
        TestUser user = Context.getTestUserHelper().getTestUser();
        Memory.set(StringUtils.join(Thread.currentThread().getName(), "_user"), user);

        testSteps.logIn(user);
    }

    @When("I open All Launches page")
    public void openAllLaunchesPage() {
        testSteps.openAllLaunchesPage();
    }

    @When("I click on {string} report link")
    public void clickOnResultStatusLink(String resultStatus) {

        Map<String, String> methodsMap = new HashMap<>() {{
            put("Product Bugs", "clickOnProductBugsReportLink");
            put("Automation Bugs", "clickOnAutomationBugsReportLink");
            put("System Issues", "clickOnSystemIssuesReportLink");
            put("To Investigate", "clickOnToInvestigateReportLink");
        }};

        String methodName = methodsMap.get(resultStatus);

        if (methodName != null) {
            try {
                Method launchReportLinkClick = TestStepsSelenide.class.getMethod(methodName);
                launchReportLinkClick.invoke(testSteps);
            } catch (InvocationTargetException | NoSuchMethodException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        } else {
            throw new RuntimeException("Result Status is not provided of not specified.");
        }
    }

    @Then("I should see a list of launches")
    public void checkLaunchesExist() {
        testSteps.checkLaunchesExist();
    }

    @Then("opened page URL should contain text {string}")
    public void checkUrlContainsText(String urlText) {
        testSteps.checkCurrentUrlsContainsText(urlText);
    }
}
