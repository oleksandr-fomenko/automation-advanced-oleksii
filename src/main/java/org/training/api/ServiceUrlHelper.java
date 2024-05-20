package org.training.api;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.configuration.ConfigHelper;

public class ServiceUrlHelper {

    public static String constructLaunchesServiceBasicUrlPath(ConfigHelper configHelper, String servicePath) {
        String baseUrl = configHelper.getBaseUrl();
        String servicePathUrl = servicePath.replace("{project_name}", configHelper.getProjectName());
        String serviceUrl = StringUtils.join(baseUrl, servicePathUrl);

        return serviceUrl;
    }

    public static String constructServicePathWithId(String servicePath, int launchId) {
        servicePath = servicePath.replace("{launch_id}", String.valueOf(launchId));

        return servicePath;
    }
}
