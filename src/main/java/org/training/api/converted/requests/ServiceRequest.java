package org.training.api.converted.requests;

import lombok.Getter;
import lombok.Setter;
import org.training.api.ServiceUrlHelper;
import org.training.api.ServiceUrls;
import org.training.configuration.ConfigHelper;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
public class ServiceRequest<T> {
    public ServiceRequest(ConfigHelper configHelper) {
        this.url = ServiceUrlHelper.constructLaunchesServiceBasicUrlPath(configHelper, ServiceUrls.LAUNCHES_BASE_PATH.getUrl());
    }

    protected String method;
    protected String url;
    protected Map<String, T> headers;
    protected String body;
    protected Map<String, T> parameters = new HashMap<>();
}
