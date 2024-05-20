package org.training.api.converted.requests;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.api.ServiceUrlHelper;
import org.training.api.ServiceUrls;
import org.training.configuration.ConfigHelper;

public class GetLaunchServiceRequest extends ServiceRequest {
    static final protected Logger LOGGER = LogManager.getLogger(GetLaunchServiceRequest.class);

    public GetLaunchServiceRequest(ConfigHelper configHelper, int launchId) {
        super(configHelper);
        method = "GET";
        url += ServiceUrlHelper.constructServicePathWithId(ServiceUrls.LAUNCH_GET.getUrl(), launchId);

        LOGGER.info(StringUtils.join("Service Url: [", method, " ", url, "]"));
    }
}
