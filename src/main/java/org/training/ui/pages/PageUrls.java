package org.training.ui.pages;

import lombok.Getter;

@Getter
public enum PageUrls {
    LOGIN_PAGE("ui/#login"),
    All_LAUNCHES_PAGE("ui/#{project_name}/launches/all"),
    DASHBOARDS_PAGE("ui/#{project_name}/dashboard");

    private String url;

    PageUrls(String urlPath) {
        this.url = urlPath;
    }
}
