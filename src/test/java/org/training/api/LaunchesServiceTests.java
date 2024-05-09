package org.training.api;

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
import org.training.api.controller.LaunchesController;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.*;

@Execution(ExecutionMode.CONCURRENT)
public class LaunchesServiceTests extends BaseTest {
    static final protected Logger LOGGER = LogManager.getLogger(LaunchesServiceTests.class);
    private final LaunchesController launches = new LaunchesController(configHelper);

    @Test
    @DisplayName("Launches Service basic Get request check")
    public void checkGetLaunchesServiceResponse() {
        launches.getAll()
                .then()
                .statusCode(200);

        LOGGER.info("Get Launches Service test passed.");
    }

    @Test
    @DisplayName("Launches Service basic Get request check (Http Client)")
    public void checkGetLaunchesServiceResponseHttpClient() {
        int responseCode = launches.getAllByClient().getCode();

        assertEquals(200, responseCode);

        LOGGER.info("Get Launches Service test passed.");
    }

    @ParameterizedTest
    @DisplayName("Launches Service Get request with filters check")
    @ValueSource(strings = {"passed", "failed", "skipped", "total"})
    public void checkGetLaunchesServiceRequestWithFilters(String testResult) {
        launches.getFiltered(StringUtils.join("filter.gte.statistics$executions$", testResult), 1)
                .then()
                .statusCode(200);

        LOGGER.info("Get Launches service filtered response test passed.");
    }

    @Test
    @DisplayName("Launches Service Get request with invalid filter check")
    public void checkGetLaunchesServiceRequestWithInvalidFilter() {
        String filterValue = "one";

        launches.getFiltered("filter.gte.statistics$executions$passed", filterValue)
                .then()
                .statusCode(400)
                .body("message", equalTo(String.format("Incorrect filtering parameters. Cannot convert '%s' to valid number", filterValue)));

        LOGGER.info("Get Launches service filtered bad request test passed.");
    }

    @Test
    @DisplayName("Launches Service Delete request check")
    public void checkDeleteLaunchesServiceRequest() {
        int launchId = launches.getAll().then().extract().path("content[0].id");
        LOGGER.info(String.format("Launch id to delete: [%s] %n", launchId));

        launches.delete(launchId)
                .then()
                .statusCode(200)
                .body("message", equalTo(String.format("Launch with ID = '%s' successfully deleted.", launchId)));

        List<Integer> launchIds = launches.getAll().then().extract().path("content.id");

        assertFalse(launchIds.contains(launchId), "Launch has not been deleted.");

        LOGGER.info("Delete Launches service test passed.");
    }

    @Test
    @DisplayName("Launches Service Delete request with invalid id check")
    public void checkDeleteLaunchesServiceRequestWithInvalidId() {
        int launchId = getInvalidLaunchId();
        LOGGER.info(String.format("Launch id to be used: [%s] %n", launchId));

        launches.delete(launchId)
                .then()
                .statusCode(404)
                .body("message", equalTo(String.format("Launch '%s' not found. Did you use correct Launch ID?", launchId)));

        LOGGER.info("Delete Launches service error test passed.");
    }

    @Test
    @DisplayName("Launches Service Start Analyze request check")
    public void checkStartLaunchAnalyzeServiceRequest() {
        int launchId = launches.getAll()
                .then()
                .extract()
                .path("content[0].id");
        LOGGER.info(String.format("Launch id to analyze: [%s] %n", launchId));

        launches.startAnalyze(launchId)
                .then()
                .statusCode(200)
                .body("message", equalTo(String.format("autoAnalyzer analysis for launch with ID='%s' started.", launchId)));

        LOGGER.info("Start Launch Analyze service test passed.");
    }

    @Test
    @DisplayName("Launches Service Start Analyze request with invalid id check")
    public void checkStartLaunchAnalyzeServiceRequestWithInvalidId() {
        int launchId = getInvalidLaunchId();
        LOGGER.info(String.format("Launch id to be used: [%s] %n", launchId));

        launches.startAnalyze(launchId)
                .then()
                .statusCode(404)
                .body("message", equalTo(String.format("Launch '%s' not found. Did you use correct Launch ID?", launchId)));

        LOGGER.info("Start Launch Analyze service error test passed.");
    }

    @Test
    @DisplayName("Launches Service Update request check")
    public void checkUpdateLaunchServiceRequest() {
        int launchId = launches.getAll()
                .then()
                .extract()
                .path("content[0].id");
        LOGGER.info(String.format("Launch id to update: [%s] %n", launchId));

        String launchData = launches.get(launchId).getBody().asPrettyString();
        String newLaunchDescription = "New Launch Description";

        String launchDataUpdated = launchData.replaceFirst("(?<=\"description\": \")([^\"]+)", newLaunchDescription);

        launches.update(launchId, launchDataUpdated)
                .then()
                .statusCode(200)
                .body("message", equalTo(String.format("Launch with ID = '%s' successfully updated.", launchId)));

        String launchDescriptionActual = launches.get(launchId)
                .then()
                .extract()
                .path("description");

        assertTrue(newLaunchDescription.contains(launchDescriptionActual));

        LOGGER.info("Update Launch service test passed.");
    }

    @Test
    @DisplayName("Launches Service Update request with invalid id check")
    public void checkUpdateLaunchServiceRequestWithInvalidId() {
        int launchId = getInvalidLaunchId();
        LOGGER.info(String.format("Launch id to be used: [%s] %n", launchId));

        String launchData = "{}";

        launches.update(launchId, launchData)
                .then()
                .statusCode(404)
                .body("message", equalTo(String.format("Launch '%s' not found. Did you use correct Launch ID?", launchId)));

        LOGGER.info("Update Launch service error test passed.");
    }

    private int getInvalidLaunchId() {
        int launchId = 1;
        List<Integer> launchIds = launches.getAll().then().extract().path("content.id");

        while (launchIds.contains(launchId)) {
            launchId++;
        }
        return launchId;
    }
}
