package org.training.ui.pages.login;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.training.ui.pages.AbstractPage;
import org.training.ui.pages.PageUrls;

@Getter
public class LoginPageSelenium extends AbstractPage {

    public LoginPageSelenium(WebDriver driver, String baseUrl) {
        super(baseUrl);
        super.driver = driver;
        initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "input[placeholder='Login']")
    private WebElement loginInput;

    @FindBy(how = How.CSS, using = "input[placeholder='Password']")
    private WebElement passwordInput;

    @FindBy(how = How.CSS, using = "button[title]")
    private WebElement loginButton;

    public String getUrl() {
        return super.getUrl(PageUrls.LOGIN_PAGE.getUrl());
    }

    public WebElement waitForLoginInput() {
        return waitForElement(loginInput);
    }
}
