package org.training.model;

import org.training.configuration.ConfigHelper;

public class TestUserHelper {
    public TestUser getTestUser(ConfigHelper configHelper) {
        return new TestUser(configHelper.getTestUsername(), configHelper.getTestUserPassword());
    }
}
