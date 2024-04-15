package org.training.bdd.api.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.training.api.ServiceUrlHelper;
import org.training.api.ServiceUrls;
import org.training.bdd.context.Context;
import org.training.bdd.context.Memory;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinitions {

    @Given("I send a Get Launches Service request")
    public void sendGetLaunchesRequest() {
        String serviceEndpoint = ServiceUrlHelper.constructServiceUrl(Context.getConfigHelper(), ServiceUrls.LAUNCHES_GET.getUrl());

        Response serviceResponse = given()
                .header("Accept", "*/*")
                .auth().oauth2(Context.getConfigHelper().getAccessToken())
                .when()
                .get(serviceEndpoint);

        Memory.set(StringUtils.join(Thread.currentThread().getName(), "_getLaunchesResponse"), serviceResponse);
    }

    @Given("I send a Get Launches Service request with result status filter {string}")
    public void sendGetLaunchesRequestWithFilter(String filter) {
        String serviceEndpoint = ServiceUrlHelper.constructServiceUrl(Context.getConfigHelper(), ServiceUrls.LAUNCHES_GET.getUrl());

        Response serviceResponse = given()
                .header("Accept", "*/*")
                .auth().oauth2(Context.getConfigHelper().getAccessToken())
                .param(StringUtils.join("filter.gte.statistics$executions$", filter), 1)
                .when()
                .get(serviceEndpoint);

        Memory.set(StringUtils.join(Thread.currentThread().getName(), "_getLaunchesResponse"), serviceResponse);
    }

    @Then("I should see service response status code {int}")
    public void validateServiceResponseStatusCode(int statusCode) {
        Response serviceResponse = (Response) Memory.get(StringUtils.join(Thread.currentThread().getName(), "_getLaunchesResponse"));
        int responseStatusCode = serviceResponse.getStatusCode();
        assertEquals(statusCode, responseStatusCode, "Service request failed.");
    }
}
