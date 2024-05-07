package org.training.api.request;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.api.ServiceUrlHelper;
import org.training.api.ServiceUrls;
import org.training.configuration.ConfigHelper;

public class DeleteLaunchRequest extends BaseRequest {
    static final protected Logger LOGGER = LogManager.getLogger(DeleteLaunchRequest.class);

    public DeleteLaunchRequest(ConfigHelper configHelper, int launchId) {
        super(configHelper);
        method = "DELETE";
        url += ServiceUrlHelper.constructServicePathWithId(ServiceUrls.LAUNCH_DELETE.getUrl(), launchId);

        LOGGER.info(StringUtils.join("Service Url: [", method, " ", url, "]"));
    }
}