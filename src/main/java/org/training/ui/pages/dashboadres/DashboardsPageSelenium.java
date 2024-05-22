package org.training.ui.pages.dashboadres;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.training.ui.pages.PageUrls;
import org.training.ui.pages.baseLoggedInPage.BaseLoggedInPageSelenium;

@Getter
public class DashboardsPageSelenium extends BaseLoggedInPageSelenium {

    public DashboardsPageSelenium(WebDriver driver, String baseUrl, String projectName) {
        super(driver, baseUrl, projectName);
        super.driver = driver;
        initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "span[title='All Dashboards']")
    private WebElement pageTitle;

    public String getUrl() {
        return super.getUrl(PageUrls.DASHBOARDS_PAGE.getUrl());
    }

    public WebElement waitForPageTitle() {
        return waitForElement(pageTitle);
    }
}
