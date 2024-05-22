package org.training.ui.pages.baseLoggedInPage;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.training.ui.pages.AbstractPage;
import org.training.ui.pages.baseLoggedInPage.components.UserMenuSelenium;

import java.time.Duration;

@Getter
public class BaseLoggedInPageSelenium extends AbstractPage {
    private final String projectName;
    private final UserMenuSelenium userMenu;

    protected BaseLoggedInPageSelenium(WebDriver driver, String baseUrl, String projectName) {
        super(baseUrl);
        super.driver = driver;
        super.actions = new Actions(driver);
        this.projectName = projectName;
        this.userMenu = new UserMenuSelenium(driver);
        initElements(driver, this);
    }

    @FindBy(how = How.CSS, using = "div[class*='userBlock__tooltip-trigger']")
    private WebElement userMenuIcon;

    @FindBy(how = How.XPATH, using = "//p[contains(text(), 'Signed in successfully')]")
    private WebElement signInSuccessNote;

    @Override
    public String getUrl(String pageUrlPath) {
        return StringUtils.join(baseUrl, pageUrlPath.replace("{project_name}", projectName));
    }

    public void waitForSignInSuccessNoteDisappear(int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.invisibilityOf(signInSuccessNote));
    }
}
