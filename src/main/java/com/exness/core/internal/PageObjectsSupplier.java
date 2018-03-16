package com.exness.core.internal;

import com.exness.core.BasePage;
import com.exness.core.pages.tools.ConverterToolPage;
import com.exness.core.pages.HomePage;

import static com.exness.core.internal.GenericPage.getPageObject;
import static com.exness.core.internal.PageObjectsSupplier.PageObject.CONVERTER_TOOL_PAGE;
import static com.exness.core.internal.PageObjectsSupplier.PageObject.HOME_PAGE;

public interface PageObjectsSupplier<T extends PageObjectsSupplier<T>> {

    enum PageObject implements GenericPage {

        HOME_PAGE {
            public BasePage create() {
                return new HomePage();
            }
        },
        CONVERTER_TOOL_PAGE {
            public BasePage create() {
                return new ConverterToolPage();
            }
        };

    }

    default HomePage homePage() {
        return (HomePage) getPageObject(HOME_PAGE);
    }

    default ConverterToolPage converterToolPage() {
        return (ConverterToolPage) getPageObject(CONVERTER_TOOL_PAGE);
    }

}
