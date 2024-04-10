package org.training.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.configuration.ConfigHelper;

public class ServiceUrlHelper {
    static final protected Logger LOGGER = LogManager.getLogger(ServiceUrlHelper.class);

    public static String constructServiceUrl(ConfigHelper configHelper, String servicePath) {
        String baseUrl = configHelper.getBaseUrl();
        String servicePathUrl = servicePath.replace("{project_name}", configHelper.getProjectName());
        String serviceUrl = StringUtils.join(baseUrl, servicePathUrl);
        LOGGER.info(StringUtils.join("Service Url: [", serviceUrl, "]"));

        return serviceUrl;
    }
}
