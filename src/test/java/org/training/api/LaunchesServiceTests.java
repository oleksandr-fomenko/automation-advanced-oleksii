package org.training.api;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import io.restassured.response.Response;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.training.configuration.ConfigHelper;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Listeners({ReportPortalTestNGListener.class})
public class LaunchesServiceTests {
    private final ConfigHelper configHelper;

    {
        try {
            configHelper = new ConfigHelper();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkGetLaunchesServiceResponse() {

        Response serviceResponse = given()
                .header("Accept", "*/*")
                .auth().oauth2(configHelper.getAccessToken())
                .when()
                .get();

        int responseStatusCode = serviceResponse.getStatusCode();
        assertEquals(responseStatusCode, 200, "Service request failed.");
    }
}
