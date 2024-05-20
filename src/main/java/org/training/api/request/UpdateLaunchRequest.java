package org.training.api.request;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.api.ServiceUrlHelper;
import org.training.api.ServiceUrls;
import org.training.configuration.ConfigHelper;

public class UpdateLaunchRequest extends BaseRequest {
    static final protected Logger LOGGER = LogManager.getLogger(UpdateLaunchRequest.class);

    public UpdateLaunchRequest(ConfigHelper configHelper, int launchId, String requestBody) {
        super(configHelper);
        method = "PUT";
        url += ServiceUrlHelper.constructServicePathWithId(ServiceUrls.LAUNCH_UPDATE_PUT.getUrl(), launchId);
        body = requestBody;

        LOGGER.info(StringUtils.join("Service Url: [", method, " ", url, "]"));
    }
}
