package org.training.ui.pages.baseLoggedInPage.components;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public class UserMenuSelenium extends PageFactory {

    private final WebDriver driver;

    public UserMenuSelenium(WebDriver driver) {
        this.driver = driver;
        initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "div[class*='userBlock__menu--']")
    private WebElement menu;

    @FindBy(how = How.XPATH, using = ".//div[contains(text(), 'Logout')]")
    private WebElement logOutLink;

    public WebElement waitForMenu() {
        return new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOf(menu));
    }
}
