package org.training.bdd.context;

import org.training.configuration.ConfigHelper;
import org.training.model.TestUserHelper;

public class Context {
    private static ConfigHelper configHelper = new ConfigHelper();
    private static TestUserHelper testUserHelper = new TestUserHelper(configHelper);

    public static synchronized ConfigHelper getConfigHelper() {
        return configHelper;
    }

    public static synchronized TestUserHelper getTestUserHelper() {
        return testUserHelper;
    }
}
