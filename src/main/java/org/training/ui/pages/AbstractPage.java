package org.training.ui.pages;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Getter
public abstract class AbstractPage extends PageFactory {
    protected WebDriver driver;
    protected Actions actions;

    public AbstractPage(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected String baseUrl;

    public String getUrl(String pageUrlPath) {
        return StringUtils.join(baseUrl, pageUrlPath);
    }

    protected WebElement waitForElement(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOf(element));
    }
}