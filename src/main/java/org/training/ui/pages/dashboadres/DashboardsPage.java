package org.training.ui.pages.dashboadres;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.training.ui.pages.BasicPage;
import org.training.ui.pages.Page;
import org.training.ui.pages.PageUrls;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class DashboardsPage extends BasicPage implements Page {
    private final String projectName;
    private final String url;
    public DashboardsPage(String baseUrl, String projectName) {
        super(baseUrl);
        this.projectName = projectName;
        this.url = StringUtils.join(baseUrl, PageUrls.DASHBOARDS_PAGE.getUrl().replace("{project_name}", projectName));
    }
    private final SelenideElement pageTitle = $(By.cssSelector("span[title='All Dashboards']"));
}
