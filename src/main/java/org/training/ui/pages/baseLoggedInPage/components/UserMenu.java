package org.training.ui.pages.baseLoggedInPage.components;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class UserMenu {
    private final SelenideElement menu = $(By.cssSelector("div[class*='userBlock__menu--']"));
    private final SelenideElement logOutLink = menu.$(By.xpath("div[contains(text(), 'Logout')]"));
}
