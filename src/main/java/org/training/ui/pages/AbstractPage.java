package org.training.ui.pages;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public abstract class AbstractPage {
    public AbstractPage(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected String baseUrl;

    public String getUrl(String pageUrlPath) {
        return StringUtils.join(baseUrl, pageUrlPath);
    }
}