package org.training.ui.pages.launches;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.AccessLevel;
import lombok.Getter;
import org.openqa.selenium.By;
import org.training.ui.pages.BaseLoggedInPage;
import org.training.ui.pages.PageUrls;
import org.training.ui.pages.launches.components.Launch;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

@Getter
public class AllLaunchesPage extends BaseLoggedInPage {

    public AllLaunchesPage(String baseUrl, String projectName) {
        super(baseUrl, projectName);
    }

    private final SelenideElement pageSwitchDropdownTitle = $(By.xpath("//div[contains(text(), 'All launches')]"));

    @Getter(AccessLevel.NONE)
    private final Launch launch = new Launch();
    private final ElementsCollection launches = $$(By.cssSelector(launch.getSelector()));

    public SelenideElement getLaunchProductBugsReportLink(int launchIndex) {
        return launches.get(launchIndex).$(By.cssSelector(launch.getProductBugsReportLinkSelector()));
    }

    public SelenideElement getLaunchAutomationBugsReportLink(int launchIndex) {
        return launches.get(launchIndex).$(By.cssSelector(launch.getAutomationBugsReportLinkSelector()));
    }

    public SelenideElement getLaunchSystemIssuesReportLink(int launchIndex) {
        return launches.get(launchIndex).$(By.cssSelector(launch.getSystemIssuesReportLinkSelector()));
    }

    public SelenideElement getLaunchToInvestigateReportLink(int launchIndex) {
        return launches.get(launchIndex).$(By.cssSelector(launch.getToInvestigateReportLinkSelector()));
    }

    public SelenideElement getProductBugsReportLink() {
        return $(By.cssSelector(launch.getProductBugsReportLinkSelector()));
    }

    public SelenideElement getAutomationBugsReportLink() {
        return $(By.cssSelector(launch.getAutomationBugsReportLinkSelector()));
    }

    public SelenideElement getSystemIssuesReportLink() {
        return $(By.cssSelector(launch.getSystemIssuesReportLinkSelector()));
    }

    public SelenideElement getToInvestigateReportLink() {
        return $(By.cssSelector(launch.getToInvestigateReportLinkSelector()));
    }

    public String getUrl() {
        return super.getUrl(PageUrls.All_LAUNCHES_PAGE.getUrl());
    }
}
