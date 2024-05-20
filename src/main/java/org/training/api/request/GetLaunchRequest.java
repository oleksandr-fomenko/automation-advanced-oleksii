package org.training.api.request;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.api.ServiceUrlHelper;
import org.training.api.ServiceUrls;
import org.training.configuration.ConfigHelper;

public class GetLaunchRequest extends BaseRequest {
    static final protected Logger LOGGER = LogManager.getLogger(GetLaunchRequest.class);

    public GetLaunchRequest(ConfigHelper configHelper, int launchId) {
        super(configHelper);
        method = "GET";
        url += ServiceUrlHelper.constructServicePathWithId(ServiceUrls.LAUNCH_GET.getUrl(), launchId);

        LOGGER.info(StringUtils.join("Service Url: [", method, " ", url, "]"));
    }
}
