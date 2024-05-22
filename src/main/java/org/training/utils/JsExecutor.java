package org.training.utils;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JsExecutor {
    private final JavascriptExecutor executor;
    private String jSscriptArguments = "arguments[0]";

    public JsExecutor(WebDriver driver) {
        this.executor = (JavascriptExecutor) driver;
    }

    public void scrollTo(WebElement element) {
        executor.executeScript(StringUtils.join(jSscriptArguments, ".scrollIntoView();"), element);
    }

    public void click(WebElement element) {
        executor.executeScript(StringUtils.join(jSscriptArguments, ".click();"), element);
    }

    public boolean isElementInViewPort(WebElement element) {
        return (Boolean) executor.executeScript(
                StringUtils.join(
                        "var rect = ", jSscriptArguments, ".getBoundingClientRect();",
                        "return (",
                        "rect.top >= 0 &&",
                        "rect.left >= 0 &&",
                        "rect.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&",
                        "rect.right <= (window.innerWidth || document.documentElement.clientWidth)",
                        ");"), element);
    }
}
