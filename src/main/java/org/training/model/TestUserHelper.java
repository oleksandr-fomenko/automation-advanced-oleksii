package org.training.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.training.configuration.ConfigHelper;

import java.util.LinkedList;
import java.util.Queue;

public class TestUserHelper {
    private final Queue<TestUser> userQueue;

    static final protected Logger LOGGER = LogManager.getLogger(TestUserHelper.class);

    public TestUserHelper(ConfigHelper configHelper) {
        userQueue = new LinkedList<>() {{
            add(new TestUser(configHelper.getTestUsername1(), configHelper.getTestUserPassword1()));
            add(new TestUser(configHelper.getTestUsername2(), configHelper.getTestUserPassword2()));
            add(new TestUser(configHelper.getTestUsername3(), configHelper.getTestUserPassword3()));
        }};
    }

    public TestUser getTestUser() {
        return userQueue.poll();
    }

    public void returnTestUser(TestUser user) {
        userQueue.add(user);
        LOGGER.info(StringUtils.join("Test user [", user.username(), "] has been returned to a queue."));
    }
}
