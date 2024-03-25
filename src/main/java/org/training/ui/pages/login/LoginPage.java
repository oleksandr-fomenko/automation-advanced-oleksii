package org.training.ui.pages.login;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.training.ui.pages.BasicPage;
import org.training.ui.pages.Page;
import org.training.ui.pages.PageUrls;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class LoginPage extends BasicPage implements Page {
    public LoginPage(String baseUrl) {
        super(baseUrl);
    }

    private final String url = StringUtils.join(baseUrl, PageUrls.LOGIN_PAGE.getUrl());

    private final SelenideElement loginInput = $(By.cssSelector("input[placeholder='Login']"));
    private final SelenideElement passwordInput = $(By.cssSelector("input[placeholder='Password']"));
    private final SelenideElement loginButton = $(By.cssSelector("button[title]"));
}
