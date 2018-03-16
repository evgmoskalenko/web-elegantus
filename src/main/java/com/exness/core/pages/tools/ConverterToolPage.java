package com.exness.core.pages.tools;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.exness.core.BasePage;
import com.exness.utils.CurrenciesUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.openqa.selenium.By.cssSelector;
import static org.openqa.selenium.By.id;

public class ConverterToolPage extends BasePage<ConverterToolPage> {

    private static final By CONVERTER_TAB_ITEM = cssSelector(".converter-tabItem");
    private static final By SELECTED_CONVERTER_TAB_ITEM = cssSelector(".converter-tabItem__selected");
    private static final By CONVERTER_TAB_CURRENCY_NAME = cssSelector(".converter-tabCurrencyName");
    private static final By CONVERTER_TAB_ITEM_INPUT = cssSelector(".ui-input");
    private static final By CONVERTER_CURRENCIES_ITEM = cssSelector(".converter-currenciesItem");
    private static final By SELECTED_CONVERTER_CURRENCIES_ITEM = cssSelector(".converter-currenciesItem__selected");
    private static final By CONVERTER_CURRENCIES_SYMBOL = cssSelector(".converter-currenciesSymbol");
    private static final By CONVERTER_CURRENCIES_NAME = cssSelector(".converter-currenciesName");
    private static final By CONVERTER_POPULAR_FILTER_CURRENCIES_ITEM = cssSelector(".converter-popularItem");
    private static final By SELECTED_CONVERTER_POPULAR_FILTER_CURRENCIES_ITEM = cssSelector(
            ".converter-popularItem__selected");
    private static final By SEARCH_CURRENCIES_FIELD = id("find-currencies");
    private static final By CONVERTER_SUBMIT_BUTTON = cssSelector(".ui-btnTxt");

    @Override
    protected String getUrl() {
        return baseUrl+"/intl/ru/tools/converter/";
    }

    public enum CurrenciesTabs {
        CURR_TAB_FROM, CURR_TAB_TO
    }

    private ElementsCollection converterTabItems() {
        return $$(CONVERTER_TAB_ITEM);
    }

    public ElementsCollection getCurrenciesFromCommonList() {
        return $$(CONVERTER_CURRENCIES_ITEM);
    }

    public ElementsCollection getCurrenciesFromPopularList() {
        return $$(CONVERTER_POPULAR_FILTER_CURRENCIES_ITEM);
    }

    @Step("Choose currencies converter tab: \"{tab}\"")
    public ConverterToolPage chooseCurrencyConverterTab(CurrenciesTabs tab) {
        switch (tab) {
            case CURR_TAB_FROM:
                converterTabItems().get(0).click();
                break;
            case CURR_TAB_TO:
                converterTabItems().get(1).click();
                break;
        }
        return this;
    }

    public double getTabCurrencyValue() {
        String value = $(SELECTED_CONVERTER_TAB_ITEM).$(CONVERTER_TAB_ITEM_INPUT).attr("value");
        return Double.parseDouble(value);
    }

    public double getConvertedCurrencyValue(double currencyValue, double currencyBid, double currencyAsk) {
        CurrenciesUtils currenciesUtils = new CurrenciesUtils(currencyBid, currencyAsk);
        double convertedValue = currenciesUtils.convert(currencyValue);
        return new BigDecimal(convertedValue).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    @Step("Fill currencies value \"{currencyValue}\"")
    public ConverterToolPage setTabCurrencyValue(String currencyValue) {
        $(SELECTED_CONVERTER_TAB_ITEM).$(CONVERTER_TAB_ITEM_INPUT).val(currencyValue);
        return this;
    }

    @Step("Select currency: \"{popularCurrencyShortProps}\" from popular list")
    public ConverterToolPage chooseCurrencyFromPopularList(String popularCurrencyShortProps) {
        getCurrenciesFromPopularList().find(matchesText(popularCurrencyShortProps)).click();
        return this;
    }

    @Step("Select currency: \"{converterCurrenciesValue}\" from common list")
    public ConverterToolPage setCurrencyFromCommonList(String converterCurrenciesValue) {
        getCurrenciesFromCommonList().find(matchesText(converterCurrenciesValue)).click();
        return this;
    }

    public SelenideElement converterTabCurrencyName() {
        return $(CONVERTER_TAB_CURRENCY_NAME);
    }

    public SelenideElement converterPopularItemCurrencyName() {
        return $(SELECTED_CONVERTER_POPULAR_FILTER_CURRENCIES_ITEM);
    }

    private SelenideElement converterCurrenciesSelectedItemFromCommonList() {
        return $(SELECTED_CONVERTER_CURRENCIES_ITEM);
    }

    public SelenideElement converterCurrencySymbolFromCommonList() {
        return converterCurrenciesSelectedItemFromCommonList().$(CONVERTER_CURRENCIES_SYMBOL);
    }

    public SelenideElement converterCurrencyNameFromCommonList() {
        return converterCurrenciesSelectedItemFromCommonList().$(CONVERTER_CURRENCIES_NAME);
    }

    @Step("Clear converter tabs")
    public ConverterToolPage cleanConverterTabByButton() {
        $(CONVERTER_SUBMIT_BUTTON).shouldHave(matchesText("Очистить")).click();
        return this;
    }

    @Step("Find currency \"{currencyShortProps}\"")
    public ConverterToolPage findCurrencyFor(String currencyShortProps) {
        $(SEARCH_CURRENCIES_FIELD).val(currencyShortProps);
        return this;
    }

    @Step("Choose currencies from search result")
    public ConverterToolPage chooseCurrencyFromSearchResult() {
        getCurrenciesFromCommonList().get(0).click();
        return this;
    }

    public SelenideElement getTextNothingFound() {
        return $$(".converter-container").get(1).$(".txt-h3");
    }

}
