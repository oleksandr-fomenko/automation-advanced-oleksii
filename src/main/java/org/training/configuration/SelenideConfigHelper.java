package org.training.configuration;

import org.apache.commons.lang3.StringUtils;
import org.training.utils.PropertiesHelper;

import java.io.IOException;

import static com.codeborne.selenide.Configuration.pageLoadTimeout;

public class SelenideConfigHelper {
    public SelenideConfigHelper() throws IOException {
        setUpSelenide();
    }

    public void setUpSelenide() {
        String currentEnv = System.getProperty("env", "local");
        PropertiesHelper propertiesHelper = new PropertiesHelper(getClass().getClassLoader(), StringUtils.join("./", currentEnv, "/selenide.properties"));

        pageLoadTimeout = Long.parseLong(propertiesHelper.getPropertyValue("page.load.timeout"));
    }
}
