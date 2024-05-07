package org.training.api.request;

import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.configuration.ConfigHelper;

import java.util.Map;

public class GetLaunchesFilteredRequest<T> extends BaseRequest {
    static final protected Logger LOGGER = LogManager.getLogger(GetLaunchesFilteredRequest.class);

    public GetLaunchesFilteredRequest(ConfigHelper configHelper) {
        super(configHelper);
        method = "GET";

        LOGGER.info(StringUtils.join("Service Url: [", method, " ", url, "]"));
    }

    public Response execute(Map<String, T> parameters) {
        this.parameters = parameters;
        return super.execute();
    }
}
