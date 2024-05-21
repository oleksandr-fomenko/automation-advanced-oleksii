package org.training.utils;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;

@Getter
public class DriverWithEvents implements WebDriver {

    private final Logger logger;
    private final WebDriver driver;

    public DriverWithEvents(Logger logger, WebDriver driver) {
        this.logger = logger;
        this.driver = driver;
    }

    @Override
    public void get(String url) {
        driver.get(url);
    }

    @Override
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Override
    public String getTitle() {
        return driver.getTitle();
    }

    @Override
    public List findElements(By locator) {
        logger.info(StringUtils.join("Looking for elements by [", locator, "]..."));
        List elements = driver.findElements(locator);
        logger.info("Elements found");
        return elements;
    }

    public WebElement findElement(By locator) {
        logger.info(StringUtils.join("Looking for element by [", locator, "]..."));
        WebElement element = driver.findElement(locator);
        logger.info("Element found");
        return element;
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public Options manage() {
        return driver.manage();
    }
}
