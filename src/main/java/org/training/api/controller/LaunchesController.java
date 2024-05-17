package org.training.api.controller;

import io.restassured.response.Response;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.training.api.request.*;
import org.training.configuration.ConfigHelper;

import java.util.Map;

public class LaunchesController {
    private final ConfigHelper configHelper;

    public LaunchesController(ConfigHelper configHelper) {
        this.configHelper = configHelper;
    }

    public Response getAll() {
        return new GetAllLaunchesRequest(configHelper).execute();
    }

    public CloseableHttpResponse getAllByClient() {
        return new GetAllLaunchesRequest(configHelper).executeHttpClient();
    }

    public Response get(int launchId) {
        return new GetLaunchRequest(configHelper, launchId).execute();
    }

    public <T> Response getFiltered(String filter, T value) {
        return new GetLaunchesFilteredRequest(configHelper).execute(Map.of(filter, value));
    }

    public Response delete(int launchId) {
        return new DeleteLaunchRequest(configHelper, launchId).execute();
    }

    public Response startAnalyze(int launchId) {
        return new StartLaunchAnalyzeRequest(configHelper, launchId).execute();
    }

    public Response update(int launchId, String launchData) {
        return new UpdateLaunchRequest(configHelper, launchId, launchData).execute();
    }
}
