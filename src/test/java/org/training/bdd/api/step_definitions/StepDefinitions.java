package org.training.bdd.api.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.training.api.controller.LaunchesController;
import org.training.bdd.context.Context;
import org.training.bdd.context.Memory;

public class StepDefinitions {
    private final LaunchesController launches = new LaunchesController(Context.getConfigHelper());

    @Given("I send a Get Launches Service request")
    public void sendGetLaunchesRequest() {
        Response serviceResponse = launches.getAll();
        Memory.set(StringUtils.join(Thread.currentThread().getName(), "_getLaunchesResponse"), serviceResponse);
    }

    @Given("I send a Get Launches Service request with result status filter {string}")
    public void sendGetLaunchesRequestWithFilter(String filter) {
        Response serviceResponse = launches.getFiltered(StringUtils.join("filter.gte.statistics$executions$", filter), 1);
        Memory.set(StringUtils.join(Thread.currentThread().getName(), "_getLaunchesResponse"), serviceResponse);
    }

    @Then("I should see service response status code {int}")
    public void validateServiceResponseStatusCode(int statusCode) {
        Response serviceResponse = (Response) Memory.get(StringUtils.join(Thread.currentThread().getName(), "_getLaunchesResponse"));
        serviceResponse.then().statusCode(statusCode);
    }
}
