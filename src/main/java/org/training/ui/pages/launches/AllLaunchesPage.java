package org.training.ui.pages.launches;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.training.ui.pages.BaseLoggedInPage;
import org.training.ui.pages.PageUrls;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class AllLaunchesPage extends BaseLoggedInPage {

    public AllLaunchesPage(String baseUrl, String projectName) {
        super(baseUrl, projectName);
    }

    private final SelenideElement pageSwitchDropdownTitle = $(By.xpath("//div[contains(text(), 'All launches')]"));
    private final ElementsCollection launches = $$(By.cssSelector("[class*='gridRow__grid-row-wrapper']"));

    public String getUrl() {
        return super.getUrl(PageUrls.All_LAUNCHES_PAGE.getUrl());
    }
}
