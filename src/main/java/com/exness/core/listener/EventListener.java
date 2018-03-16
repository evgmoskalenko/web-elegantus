package com.exness.core.listener;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EventListener implements WebDriverEventListener {

    private static final Logger LOGGER = Logger.getLogger(EventListener.class);

    @Override
    //@Step("Click on element: {0}")
    public void afterClickOn(WebElement element, WebDriver driver) {
        LOGGER.info("clicked element with " + getLocatorFromElement(element));
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        LOGGER.info("change value of element with " + getLocatorFromElement(webElement));
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        LOGGER.info("changed value of element with " + getLocatorFromElement(webElement));
    }

    @Override
    public void afterFindBy(By by, WebElement arg1, WebDriver arg2) {
        LOGGER.info("found element " + by);
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        LOGGER.info("after back");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        LOGGER.info("after forward");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        LOGGER.info("before navigation refresh");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        LOGGER.info("after navigation refresh");
    }

    @Override
    @Step("Navigate to: {url}")
    public void afterNavigateTo(String url, WebDriver driver) {
        //AllureReport.browserConsoleLogEntryToReport();
        LOGGER.info("navigated to " + url);
    }

    @Override
    public void afterScript(String script, WebDriver driver) {
        //LOGGER.info("execute script " + script);
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOGGER.info("click element with " + getLocatorFromElement(element));
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver arg2) {
        LOGGER.info("find element " + by);
    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        LOGGER.info("before back");
    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        LOGGER.info("before forward");
    }

    @Override
    public void beforeAlertAccept(WebDriver webDriver) {
        LOGGER.info("");
    }

    @Override
    public void afterAlertAccept(WebDriver webDriver) {
        LOGGER.info("");
    }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) {
        LOGGER.info("");
    }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) {
        LOGGER.info("");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        LOGGER.info("navigate to " + url);
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {
        //LOGGER.info("running script " + script);
    }

    @Override
    public void onException(Throwable thrw, WebDriver driver) {
        LOGGER.info(thrw.getMessage());
    }

    private String getLocatorFromElement(WebElement element) {
        String str = element.toString();
        Pattern p = Pattern.compile("->\\s(.*)(?=\\])");
        Matcher m = p.matcher(str);
        return m.find() && m.groupCount() > 0 ? m.group(1) : str;
    }
}

