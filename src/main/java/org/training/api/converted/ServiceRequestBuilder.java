package org.training.api.converted;

import org.apache.commons.lang3.StringUtils;
import org.training.api.converted.requests.ServiceRequest;
import org.training.configuration.ConfigHelper;

import java.util.Map;

public class ServiceRequestBuilder {

    public ServiceRequestBuilder(ConfigHelper configHelper, ServiceRequest request) {
        this.configHelper = configHelper;
        this.request = request;
    }

    private final ConfigHelper configHelper;
    private final ServiceRequest request;

    public ServiceRequestBuilder body(String body) {
        request.setBody(body);
        return this;
    }

    public ServiceRequestBuilder parameters(Map parameters) {
        request.setParameters(parameters);
        return this;
    }

    public ServiceRequest build() {
        request.setHeaders(Map.of(
                "Accept", "*/*",
                "Content-Type", "application/json",
                "Authorization", StringUtils.join("Bearer ", configHelper.getAccessToken())));

        return request;
    }
}
