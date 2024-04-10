package org.training.ui.pages.baseLoggedInPage;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.training.ui.pages.AbstractPage;
import org.training.ui.pages.baseLoggedInPage.components.UserMenu;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class BaseLoggedInPage extends AbstractPage {
    private final String projectName;

    private final UserMenu userMenu = new UserMenu();
    private final SelenideElement userMenuIcon = $(By.cssSelector("div[class*='userBlock__tooltip-trigger']"));

    private final SelenideElement signInSuccessNote = $(By.xpath("//p[contains(text(), 'Signed in successfully')]"));

    protected BaseLoggedInPage(String baseUrl, String projectName) {
        super(baseUrl);
        this.projectName = projectName;
    }

    @Override
    public String getUrl(String pageUrlPath) {
        return StringUtils.join(baseUrl, pageUrlPath.replace("{project_name}", projectName));
    }
}
