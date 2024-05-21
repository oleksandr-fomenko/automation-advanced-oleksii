package org.training.ui.steps;

import org.training.model.TestUser;

public interface TestSteps {
    void logIn(TestUser testUser);
    void openAllLaunchesPage();
    void checkLaunchesExist();
    void logOut();
    void checkCurrentUrlsContainsText(String text);
    void selectLaunchInfoText(int launchNumber);
    void closeDriver();
}
