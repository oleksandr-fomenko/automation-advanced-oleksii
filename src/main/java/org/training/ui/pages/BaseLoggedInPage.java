package org.training.ui.pages;

import org.apache.commons.lang3.StringUtils;

public class BaseLoggedInPage extends AbstractPage {
    private final String projectName;

    protected BaseLoggedInPage(String baseUrl, String projectName) {
        super(baseUrl);
        this.projectName = projectName;
    }

    @Override
    public String getUrl(String pageUrlPath) {
        return StringUtils.join(baseUrl, pageUrlPath.replace("{project_name}", projectName));
    }
}
