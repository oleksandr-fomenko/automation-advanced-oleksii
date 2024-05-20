package org.training.api.request;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.apache.hc.client5.http.classic.methods.*;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.training.api.ServiceUrlHelper;
import org.training.api.ServiceUrls;
import org.training.configuration.ConfigHelper;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseRequest<T> {
    public BaseRequest(ConfigHelper configHelper) {
        this.configHelper = configHelper;
        url = ServiceUrlHelper.constructLaunchesServiceBasicUrlPath(configHelper, ServiceUrls.LAUNCHES_BASE_PATH.getUrl());
    }

    protected ConfigHelper configHelper;
    protected String method;
    protected String url;
    protected String body;
    protected Map<String, T> parameters = new HashMap<>();

    public Response execute() {
        RequestSpecification spec = given()
                .header("Accept", "*/*")
                .header("Content-Type", "application/json")
                .auth().oauth2(configHelper.getAccessToken());

        if (parameters != null) {
            spec.queryParams(parameters);
        }
        if (body != null) {
            spec.body(body);
        }
        return spec.request(method, url);
    }

    @SneakyThrows
    public CloseableHttpResponse executeHttpClient() {

        HttpUriRequestBase getRequest = switch (method) {
            case "PUT" -> new HttpPut(url);
            case "POST" -> new HttpPost(url);
            case "DELETE" -> new HttpDelete(url);
            default -> new HttpGet(url);
        };

        setClientRequestHeaders(getRequest);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            return httpClient.execute(getRequest);
        }
    }

    private void setClientRequestHeaders(HttpUriRequestBase request) {
        request.setHeader("Accept", "*/*");
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Authorization", StringUtils.join("Bearer ", configHelper.getAccessToken()));
    }
}
