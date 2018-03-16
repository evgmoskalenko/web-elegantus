package com.exness.core;

import com.exness.core.internal.BrowserWindow;
import com.exness.core.internal.Cookies;
import com.exness.core.internal.PageObjectsSupplier;
import com.exness.core.internal.SelenidePages;
import org.apache.log4j.Logger;

import static com.codeborne.selenide.Selenide.open;
import static com.exness.core.BaseConfig.BASE_CONFIG;

public abstract class BasePage<T> implements PageObjectsSupplier, BrowserWindow, Cookies, SelenidePages {

    private static final Logger LOGGER = Logger.getLogger(BasePage.class);

    protected static final String baseUrl = BASE_CONFIG.url();
    abstract protected String getUrl();

    public T openPage() {
        open(getUrl());
        return get();
    }

    public T openPage(String customUrlPage) {
        open(customUrlPage);
        return get();
    }

    public T openPageWithTab(String navTab) {
        open(getUrl() + navTab);
        return get();
    }

    public T openPageWithTab(String customUrlPage, String navTab) {
        open(customUrlPage + navTab);
        return get();
    }

    @SuppressWarnings("unchecked")
    private T get() {
        return (T) this;
    }

//    @SuppressWarnings("unchecked")
//    public T thenGoTo(Class<T> clazz) {
//        return init(clazz);
//    }
//
//    @SuppressWarnings("unchecked")
//    public T thenGoToWithUrl(Class<T> clazz, String url) {
//        return init(clazz, url);
//    }

}
