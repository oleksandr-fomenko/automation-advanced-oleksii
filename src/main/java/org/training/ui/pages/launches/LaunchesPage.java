package org.training.ui.pages.launches;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.training.ui.pages.BasicPage;
import org.training.ui.pages.Page;
import org.training.ui.pages.PageUrls;

@Getter
public class LaunchesPage extends BasicPage implements Page {
    public LaunchesPage(String baseUrl, String projectName) {
        super(baseUrl);
    }

    private final String url = StringUtils.join(baseUrl, PageUrls.LAUNCHES_PAGE.getPageUrl());
}
