package org.training.api;

import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.training.BaseTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Execution(ExecutionMode.CONCURRENT)
public class LaunchesServiceTests extends BaseTest {
    static final protected Logger LOGGER = LogManager.getLogger(LaunchesServiceTests.class);

    @Test
    @DisplayName("Launches Service basic request check")
    public void checkGetLaunchesServiceResponse() {
        String serviceEndpoint = ServiceUrlHelper.constructServiceUrl(configHelper, ServiceUrls.LAUNCHES_GET.getUrl());

        Response serviceResponse = given()
                .header("Accept", "*/*")
                .auth().oauth2(configHelper.getAccessToken())
                .when()
                .get(serviceEndpoint);

        int responseStatusCode = serviceResponse.getStatusCode();
        assertEquals(responseStatusCode, 200, "Service request failed.");

        LOGGER.info("Get Launches Service test passed.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"passed", "failed", "skipped", "total"})
    @DisplayName("Launches Service request with filters check")
    public void checkGetLaunchesServiceRequestWithFilters(String testResult) {
        String serviceEndpoint = ServiceUrlHelper.constructServiceUrl(configHelper, ServiceUrls.LAUNCHES_GET.getUrl());

        Response serviceResponse = given()
                .header("Accept", "*/*")
                .auth().oauth2(configHelper.getAccessToken())
                .param(StringUtils.join("filter.gte.statistics$executions$", testResult), 1)
                .when()
                .get(serviceEndpoint);

        int responseStatusCode = serviceResponse.getStatusCode();
        assertEquals(responseStatusCode, 200, "Service request failed.");

        LOGGER.info("Get Launches Service filtered response test passed.");
    }
}
