package com.exness.core.internal;

import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.title;
import static com.codeborne.selenide.WebDriverRunner.source;
import static com.codeborne.selenide.WebDriverRunner.url;

public interface SelenidePages {

    Logger LOGGER = Logger.getLogger(SelenidePages.class);

    /**
     * @return Returns the current url of the web page
     */
    default String getPageUrl() {
        LOGGER.info("Current url: "+url()+" of the web page");
        return url();
    }

    /**
     * @return Returns the title of the web page
     */
    default String getPageTitle() {
        return title();
    }

    /**
     * @return Returns the source code of the current page
     */
    default String getPageSource() {
        return source();
    }

}
