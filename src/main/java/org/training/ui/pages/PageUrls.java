package org.training.ui.pages;

import lombok.Getter;

@Getter
public enum PageUrls {
    LOGIN_PAGE("/ui/#login"),
    LAUNCHES_PAGE("/ui/#test_automation_advanced//launches/all");

    private String pageUrl;

    PageUrls(String urlPath) {
        this.pageUrl = urlPath;
    }
}
