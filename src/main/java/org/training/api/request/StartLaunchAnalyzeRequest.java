package org.training.api.request;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.api.ServiceUrls;
import org.training.configuration.ConfigHelper;

public class StartLaunchAnalyzeRequest extends BaseRequest {
    static final protected Logger LOGGER = LogManager.getLogger(StartLaunchAnalyzeRequest.class);

    public StartLaunchAnalyzeRequest(ConfigHelper configHelper, int launchId) {
        super(configHelper);
        method = "POST";
        url += ServiceUrls.LAUNCHES_START_ANALYZE_POST.getUrl();
        body = String.format("""
                {
                  "analyzeItemsMode": [
                    "TO_INVESTIGATE"
                  ],
                  "analyzerMode": "ALL",
                  "analyzerTypeName": "autoAnalyzer",
                  "launchId": %s
                }
                """, launchId);

        LOGGER.info(StringUtils.join("Service Url: [", method, " ", url, "]"));
    }
}
