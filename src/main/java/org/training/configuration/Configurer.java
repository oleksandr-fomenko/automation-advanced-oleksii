package org.training.configuration;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.training.utils.PropertiesHelper;

import java.io.IOException;

@Getter
public class Configurer {

    private String url;

    public Configurer() throws IOException {
        initProperties();
    }

    public void initProperties() throws IOException {
        String currentEnv = System.getProperty("env", "local");
        PropertiesHelper propertiesHelper = new PropertiesHelper(getClass().getClassLoader(), StringUtils.join("./", currentEnv, "/application.properties"));

        url = propertiesHelper.getPropertyValue("env.url");
    }

}
