package com.exness.core.listener;

import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;
import static com.exness.core.BaseTest.getDriver;
import static com.exness.utils.AttachmentUtils.attachLog;
import static com.exness.utils.AttachmentUtils.attachScreenshot;
import static java.util.Objects.nonNull;
import static org.openqa.selenium.OutputType.BYTES;
import static org.openqa.selenium.logging.LogType.BROWSER;

public class AllureReportListener extends TestListenerAdapter {

    /**
     * Returns string list with browser console log
     * @return List<String> without duplicates
     */
    private List<String> getListBrowserConsoleLog() {
        return getWebDriverLogs(BROWSER, Level.ALL)
                .parallelStream().distinct().collect(Collectors.toList());
    }

    private byte[] takeScreenshot() {
        return ((TakesScreenshot) getDriver()).getScreenshotAs(BYTES);
    }

    @Override
    public void onTestFailure(ITestResult failingTest) {
        List<String> listBrowserConsoleLog = getListBrowserConsoleLog();
        if (nonNull(listBrowserConsoleLog)) attachLog("Browser console log", listBrowserConsoleLog);

        byte[] screenshot = takeScreenshot();
        if (nonNull(screenshot)) attachScreenshot(takeScreenshot(),
                failingTest.getMethod().getMethodName() + "_" + LocalDate.now());
    }

}
