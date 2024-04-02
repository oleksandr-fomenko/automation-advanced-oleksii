package org.training.api;

import lombok.Getter;

@Getter
public enum ServiceUrls {
    LAUNCHES_GET("api/v1/{project_name}/launch");

    private String url;

    ServiceUrls(String urlPath) {
        this.url = urlPath;
    }
}
