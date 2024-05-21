package org.training.bdd.ui.hooks;

import io.cucumber.java.After;
import org.apache.commons.lang3.StringUtils;
import org.training.bdd.context.Context;
import org.training.bdd.context.Memory;
import org.training.model.TestUser;
import org.training.ui.steps.TestStepsSelenide;

public class AfterHooks {
    TestStepsSelenide testSteps;

    @After
    public void tearDown() {
        testSteps = new TestStepsSelenide(Context.getConfigHelper());
        testSteps.logOut();
        Context.getTestUserHelper().returnTestUser((TestUser) Memory.get(StringUtils.join(Thread.currentThread().getName(), "_user")));
    }
}
