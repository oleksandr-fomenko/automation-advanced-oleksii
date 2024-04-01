package org.training.api;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.training.BaseTest;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LaunchesServiceTests extends BaseTest {
    static final protected Logger LOGGER = LogManager.getLogger(LaunchesServiceTests.class);

    @Test
    public void checkGetLaunchesServiceResponse() {

        Response serviceResponse = given()
                .header("Accept", "*/*")
                .auth().oauth2(configHelper.getAccessToken())
                .when()
                .get();

        int responseStatusCode = serviceResponse.getStatusCode();
        assertEquals(responseStatusCode, 200, "Service request failed.");

        LOGGER.info("Get Launches Service test passed.");
    }
}
