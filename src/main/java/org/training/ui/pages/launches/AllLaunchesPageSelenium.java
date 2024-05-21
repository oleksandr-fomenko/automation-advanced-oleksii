package org.training.ui.pages.launches;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.training.ui.pages.PageUrls;
import org.training.ui.pages.baseLoggedInPage.BaseLoggedInPageSelenium;
import org.training.utils.DriverWithEvents;

import java.util.List;

@Getter
public class AllLaunchesPageSelenium extends BaseLoggedInPageSelenium {

    public AllLaunchesPageSelenium(WebDriver driver, String baseUrl, String projectName) {
        super(((DriverWithEvents) driver).getDriver(), baseUrl, projectName);
        super.driver = driver;
        initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[contains(text(), 'All launches')]")
    private WebElement pageSwitchDropdownTitle;

    @FindAll(@FindBy(css = "[class*='gridRow__grid-row-wrapper']"))
    private List<WebElement> launches;

    @FindAll(@FindBy(css = "[class*=hamburger__hamburger--]"))
    private List<WebElement> launchesHamburgerMenu;


    public String getUrl() {
        return super.getUrl(PageUrls.All_LAUNCHES_PAGE.getUrl());
    }

    public WebElement waitForPageSwitchDropdownTitle() {
        return waitForElement(pageSwitchDropdownTitle);
    }

    public WebElement waitForFirstLaunch() {

        if (launches.isEmpty()) {
            launches = driver.findElements(new By.ByCssSelector("[class*='gridRow__grid-row-wrapper']"));
        }
        return waitForElement(launches.get(0));
    }

    public void selectLaunchInfoText(int launchNumber) {
        actions.dragAndDrop(launchesHamburgerMenu.get(launchNumber - 1), launchesHamburgerMenu.get(launchNumber)).perform();
    }
}
