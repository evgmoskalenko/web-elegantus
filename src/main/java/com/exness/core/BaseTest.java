package com.exness.core;

import com.codeborne.selenide.WebDriverRunner;
import com.exness.core.internal.GenericPage;
import com.exness.core.internal.PageObjectsSupplier;
import com.exness.core.internal.testcases.TestCase;
import com.exness.core.listener.*;
import com.exness.rest.AbstractRest;
import com.exness.rest.listener.RestAssuredLogListener;
import com.exness.utils.report.AllurePropertiesUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.WebDriverRunner.addListener;
import static com.exness.utils.AttachmentUtils.attachLog;
import static org.apache.commons.collections.MapUtils.isEmpty;

@Listeners({
        AllureReportListener.class,
        VideoRecordingListener.class,
        RestAssuredLogListener.class,
        TestListener.class
})
public abstract class BaseTest extends AbstractRest implements PageObjectsSupplier, TestCase {

    private static final Logger LOGGER = Logger.getLogger(BaseTest.class);

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        addListener(new EventListener());
        addListener(new Highlighter());
        configureRestAssured();
    }

    /**
     * Retrieves the user agent from the browser
     * @return - String of the user agent
     */
    public void userAgent() {
        String ua;
        try {
            ua = executeJavaScript("return navigator.userAgent;");
        } catch (Exception e) {
            ua = "Unable to fetch UserAgent";
        }
        LOGGER.debug("User agent is: '" + ua + "'");
        attachLog("User agent", ua);
    }

    /**
     * Returns the webdriver object for that given thread
     * @return - WebDriver object
     */
    public static WebDriver getDriver() {
        return WebDriverRunner.getWebDriver();
    }

    /**
     * Thread-safe container in which are stored values as page instances
     */
    private static final ThreadLocal<Map<GenericPage, BasePage>> PAGES = ThreadLocal.withInitial(HashMap::new);

    public static Map<GenericPage, BasePage> getPages() {
        return PAGES.get();
    }

    /**
     * Cleaning collection Pages
     */
    private void cleanUpPages() {
        if (!isEmpty(getPages())) {
            PAGES.remove();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        cleanUpPages();
    }

    /**
     * Creates the allure properties for the report, after the test run
     */
    @AfterSuite(alwaysRun = true)
    public static void createAllureProperties() {
        AllurePropertiesUtil.create();
    }

}



