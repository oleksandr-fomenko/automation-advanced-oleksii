package org.training.ui.pages.login;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;
import org.training.ui.pages.AbstractPage;
import org.training.ui.pages.PageUrls;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LoginPage extends AbstractPage {
    public LoginPage(String baseUrl) {
        super(baseUrl);
    }

    private final SelenideElement loginInput = $(By.cssSelector("input[placeholder='Login']"));
    private final SelenideElement passwordInput = $(By.cssSelector("input[placeholder='Password']"));
    private final SelenideElement loginButton = $(By.cssSelector("button[title]"));

    public String getUrl() {
        return super.getUrl(PageUrls.LOGIN_PAGE.getUrl());
    }
}
