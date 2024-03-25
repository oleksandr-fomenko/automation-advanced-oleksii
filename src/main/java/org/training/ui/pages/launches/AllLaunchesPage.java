package org.training.ui.pages.launches;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.training.ui.pages.BasicPage;
import org.training.ui.pages.Page;
import org.training.ui.pages.PageUrls;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class AllLaunchesPage extends BasicPage implements Page {
    private final String projectName;
    private final String url;
    public AllLaunchesPage(String baseUrl, String projectName) {
        super(baseUrl);
        this.projectName = projectName;
        this.url = StringUtils.join(baseUrl, PageUrls.All_LAUNCHES_PAGE.getUrl().replace("{project_name}", projectName));
    }

    private final SelenideElement pageSwitchDropdownTitle = $(By.xpath("//div[contains(text(), 'All launches')]"));
    private final ElementsCollection launches = $$(By.cssSelector("[class*='gridRow__grid-row-wrapper']"));
}
