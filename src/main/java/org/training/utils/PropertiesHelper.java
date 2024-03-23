package org.training.utils;

import java.io.InputStream;
import java.util.Properties;

public class PropertiesHelper {
    public PropertiesHelper(ClassLoader classLoader, String filePath) {
        this.classLoader = classLoader;
        this.filePath = filePath;
    }

    private final ClassLoader classLoader;

    private final String filePath;
    private String propertyValue;

    public String getPropertyValue(String propertyName) {

        try (InputStream fileInputStream = classLoader.getResourceAsStream(filePath)) {
            Properties props = new Properties();
            props.load(fileInputStream);

            propertyValue = (String) props.get(propertyName);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return propertyValue;
    }

    public String getDecodedPropertyValue(String propertyName) {
        String encodedValue = getPropertyValue(propertyName);

        return StringDecoder.decodeBase64(encodedValue);
    }
}
