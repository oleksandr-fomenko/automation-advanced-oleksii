package org.training.ui.pages;

import lombok.Getter;

@Getter
public abstract class AbstractPage {
    public AbstractPage(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected String baseUrl;
    public abstract String getUrl();
}
