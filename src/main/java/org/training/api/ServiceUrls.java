package org.training.api;

import lombok.Getter;

@Getter
public enum ServiceUrls {
    LAUNCHES_BASE_PATH("api/v1/{project_name}/launch"),
    LAUNCH_GET("/{launch_id}"),
    LAUNCH_DELETE("/{launch_id}"),
    LAUNCHES_START_ANALYZE_POST("/analyze"),
    LAUNCH_UPDATE_PUT("/{launch_id}/update");

    private String url;

    ServiceUrls(String urlPath) {
        this.url = urlPath;
    }
}
