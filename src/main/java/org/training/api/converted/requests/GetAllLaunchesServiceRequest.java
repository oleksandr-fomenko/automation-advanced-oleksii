package org.training.api.converted.requests;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.configuration.ConfigHelper;

public class GetAllLaunchesServiceRequest extends ServiceRequest {
    static final protected Logger LOGGER = LogManager.getLogger(GetAllLaunchesServiceRequest.class);

    public GetAllLaunchesServiceRequest(ConfigHelper configHelper) {
        super(configHelper);
        method = "GET";

        LOGGER.info(StringUtils.join("Service Url: [", method, " ", url, "]"));
    }
}
