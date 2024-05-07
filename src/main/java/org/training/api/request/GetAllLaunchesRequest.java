package org.training.api.request;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.configuration.ConfigHelper;

public class GetAllLaunchesRequest extends BaseRequest {
    static final protected Logger LOGGER = LogManager.getLogger(GetAllLaunchesRequest.class);

    public GetAllLaunchesRequest(ConfigHelper configHelper) {
        super(configHelper);
        method = "GET";

        LOGGER.info(StringUtils.join("Service Url: [", method, " ", url, "]"));
    }
}
