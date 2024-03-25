package org.training.configuration;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.training.utils.PropertiesHelper;

import java.io.IOException;

@Getter
public class ConfigHelper {

    private String baseUrl;
    private String projectName;
    private String testUsername;
    private String testUserPassword;

    public ConfigHelper() throws IOException {
        initProperties();
    }

    public void initProperties() throws IOException {
        String currentEnv = System.getProperty("env", "local");
        PropertiesHelper propertiesHelper = new PropertiesHelper(getClass().getClassLoader(), StringUtils.join("./", currentEnv, "/application.properties"));

        baseUrl = propertiesHelper.getPropertyValue("env.url");
        projectName = propertiesHelper.getPropertyValue("env.project.name");
        testUsername = propertiesHelper.getPropertyValue("env.username");
        testUserPassword = propertiesHelper.getDecodedPropertyValue("env.user.password");
    }
}
