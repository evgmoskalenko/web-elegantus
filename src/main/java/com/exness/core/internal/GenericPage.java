package com.exness.core.internal;

import com.exness.core.BasePage;

import static com.exness.core.BaseTest.getPages;

public interface GenericPage {

    static BasePage getPageObject(final GenericPage page) {
        getPages().putIfAbsent(page, page.create());
        return getPages().get(page);
    }

    BasePage create();
}
