package org.training.ui.pages.dashboadres;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.training.ui.pages.BaseLoggedInPage;
import org.training.ui.pages.PageUrls;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class DashboardsPage extends BaseLoggedInPage {

    public DashboardsPage(String baseUrl, String projectName) {
        super(baseUrl, projectName);
    }

    private final SelenideElement pageTitle = $(By.cssSelector("span[title='All Dashboards']"));

    public String getUrl() {
        return super.getUrl(PageUrls.DASHBOARDS_PAGE.getUrl());
    }
}
