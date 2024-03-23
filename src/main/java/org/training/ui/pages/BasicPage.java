package org.training.ui.pages;

import lombok.Getter;

@Getter
public class BasicPage {
    public BasicPage(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected String baseUrl;
}
