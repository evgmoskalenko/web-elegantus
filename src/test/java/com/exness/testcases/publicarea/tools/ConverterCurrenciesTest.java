package com.exness.testcases.publicarea.tools;

import com.exness.core.BaseTest;
import com.exness.core.pages.tools.ConverterToolPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import static com.exness.core.model.Currencies.*;
import static com.exness.core.pages.tools.ConverterToolPage.CurrenciesTabs.CURR_TAB_FROM;
import static com.exness.core.pages.tools.ConverterToolPage.CurrenciesTabs.CURR_TAB_TO;


@Feature("Convert currency")
public class ConverterCurrenciesTest extends BaseTest {

    @Story("User should be able to convert currency")
    @Issue("5")
    @TmsLink("15")
    @Severity(SeverityLevel.BLOCKER)
    @Test()
    public void userShouldBeAbleToConvertCurrency() {
        // --------------------- Test Data ----------------------//
        double currencyBid = 1.28914;
        double currencyAsk = 1.28966;

        // --------------------- Test Case ----------------------//
        ConverterToolPage results = converterToolPage().openPage()
                .chooseCurrencyConverterTab(CURR_TAB_FROM)
                    .findCurrencyFor(GBP.getShortProps())
                    .chooseCurrencyFromSearchResult()
                    .setTabCurrencyValue("150");

        double actualResult = results
                .chooseCurrencyConverterTab(CURR_TAB_TO)
                    .findCurrencyFor(USD.getShortProps())
                    .chooseCurrencyFromSearchResult()
                    .getTabCurrencyValue();

        double expectedResult = results
                .getConvertedCurrencyValue(150, currencyBid, currencyAsk);

        verifyEquals(actualResult, expectedResult);
    }

    @Story("Currency rounding")
    @Issue("6")
    @TmsLink("16")
    @Severity(SeverityLevel.BLOCKER)
    @Test()
    public void currencyRoundingOff() {
        // --------------------- Test Data ----------------------//
        double currencyBid = 1.28914;
        double currencyAsk = 1.28966;

        // --------------------- Test Case ----------------------//
        ConverterToolPage results = converterToolPage().openPage();

        double actualResult = results
                .chooseCurrencyConverterTab(CURR_TAB_FROM)
                    .findCurrencyFor(GBP.getShortProps())
                    .chooseCurrencyFromSearchResult()
                    .setTabCurrencyValue("1")
                .chooseCurrencyConverterTab(CURR_TAB_TO)
                    .findCurrencyFor(USD.getShortProps())
                    .chooseCurrencyFromSearchResult()
                .getTabCurrencyValue();

        double expectedResult = results
                .getConvertedCurrencyValue(1, currencyBid, currencyAsk);

        verifyEquals(actualResult, expectedResult);
    }

    @Story("User should be able to convert currency with double value")
    @Issue("7")
    @TmsLink("17")
    @Severity(SeverityLevel.CRITICAL)
    @Test()
    public void userShouldBeAbleToConvertCurrencyWithDoubleValue() {
        // --------------------- Test Data ----------------------//
        double currencyBid = 1.12816;
        double currencyAsk = 1.12836;

        // --------------------- Test Case ----------------------//
        ConverterToolPage results = converterToolPage().openPage()
                .chooseCurrencyConverterTab(CURR_TAB_FROM)
                    .chooseCurrencyFromPopularList(EUR.getShortProps())
                    .setTabCurrencyValue("150.500");

        double actualResult = results
                .chooseCurrencyConverterTab(CURR_TAB_TO)
                    .chooseCurrencyFromPopularList(USD.getShortProps())
                    .getTabCurrencyValue();

        double expectedResult = results
                .getConvertedCurrencyValue(150.500, currencyBid, currencyAsk);

        verifyEquals(actualResult, expectedResult);
    }

    @Story("User should be able to convert currency with semicolon value")
    @Issue("8")
    @TmsLink("18")
    @Severity(SeverityLevel.MINOR)
    @Test()
    public void userShouldBeAbleToConvertCurrencyWithSemicolonValue() {
        // --------------------- Test Data ----------------------//
        double currencyBid = 1.28914;
        double currencyAsk = 1.28966;

        // --------------------- Test Case ----------------------//
        ConverterToolPage results = converterToolPage().openPage();

        double actualResult = results
                .chooseCurrencyConverterTab(CURR_TAB_FROM)
                    .findCurrencyFor(GBP.getShortProps())
                    .chooseCurrencyFromSearchResult()
                    .setTabCurrencyValue("15,55")
                .chooseCurrencyConverterTab(CURR_TAB_TO)
                    .findCurrencyFor(USD.getShortProps())
                    .chooseCurrencyFromSearchResult()
                .getTabCurrencyValue();

        double expectedResult = results
                .getConvertedCurrencyValue(15.55, currencyBid, currencyAsk);

        verifyEquals(actualResult, expectedResult);
    }

    @Story("User should be able to choose currencies from popular list")
    @Issue("9")
    @TmsLink("19")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void userShouldBeAbleToChooseCurrenciesFromPopularList() {
        // --------------------- Test Case ----------------------//
        ConverterToolPage results = converterToolPage().openPage()
                .chooseCurrencyConverterTab(CURR_TAB_FROM)
                    .chooseCurrencyFromPopularList(AUD.getShortProps());

        verifyEquals(results.converterTabCurrencyName().text(), AUD.getShortProps());
        verifyEquals(results.converterPopularItemCurrencyName().text(), AUD.getShortProps());
        verifyEquals(results.converterCurrencySymbolFromCommonList().text(), AUD.getShortProps());
        verifyEquals(results.converterCurrencyNameFromCommonList().text(), AUD.getLongProps());
    }

    @Story("User should be able to choose currencies from common list")
    @Issue("10")
    @TmsLink("20")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void userShouldBeAbleToChooseCurrenciesFromCommonList() {
        // --------------------- Test Case ----------------------//
        ConverterToolPage results = converterToolPage().openPage()
                .chooseCurrencyConverterTab(CURR_TAB_FROM)
                    .setCurrencyFromCommonList(AUD.getLongProps());

        verifyEquals(results.converterTabCurrencyName().text(), AUD.getShortProps());
        verifyEquals(results.converterPopularItemCurrencyName().text(), AUD.getShortProps());
        verifyEquals(results.converterCurrencySymbolFromCommonList().text(), AUD.getShortProps());
        verifyEquals(results.converterCurrencyNameFromCommonList().text(), AUD.getLongProps());
    }

    @Story("User should be able to clean converter tabs")
    @Issue("9")
    @TmsLink("19")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void userShouldBeAbleToCleanConverterTabs() {
        // --------------------- Test Case ----------------------//
        ConverterToolPage results = converterToolPage().openPage()
                .chooseCurrencyConverterTab(CURR_TAB_FROM)
                    .chooseCurrencyFromPopularList(AUD.getShortProps())
                    .setTabCurrencyValue("15.55")
                .chooseCurrencyConverterTab(CURR_TAB_TO)
                    .chooseCurrencyFromPopularList(EUR.getShortProps())
                .cleanConverterTabByButton();

        verifyEquals(results.chooseCurrencyConverterTab(CURR_TAB_FROM).getTabCurrencyValue(), 0);
        verifyEquals(results.chooseCurrencyConverterTab(CURR_TAB_TO).getTabCurrencyValue(), 0);

    }

    @Story("User should be able to find popular currencies by short props")
    @Issue("11")
    @TmsLink("21")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void userShouldBeAbleToFindPopularCurrencyByShortProps() {
        // --------------------- Test Case ----------------------//
        ConverterToolPage results = converterToolPage().openPage()
                .chooseCurrencyConverterTab(CURR_TAB_FROM)
                    .setTabCurrencyValue("125")
                    .findCurrencyFor(AUD.getShortProps())
                .chooseCurrencyFromSearchResult();

        results.getCurrenciesFromCommonList().shouldHaveSize(1);
        results.getCurrenciesFromPopularList().shouldHaveSize(1);

        verifyEquals(results.converterPopularItemCurrencyName().text(), AUD.getShortProps());
        verifyEquals(results.converterTabCurrencyName().text(), AUD.getShortProps());
        verifyEquals(results.converterCurrencySymbolFromCommonList().text(), AUD.getShortProps());
        verifyEquals(results.converterCurrencyNameFromCommonList().text(), AUD.getLongProps());
    }

    @Story("User should be able to find currency by long props")
    @Issue("12")
    @TmsLink("22")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void userShouldBeAbleToFindCurrencyByLongProps() {
        // --------------------- Test Case ----------------------//
        ConverterToolPage results = converterToolPage().openPage()
                .chooseCurrencyConverterTab(CURR_TAB_FROM)
                    .setTabCurrencyValue("125")
                    .findCurrencyFor(AUD.getLongProps())
                    .chooseCurrencyFromSearchResult();

        results.getCurrenciesFromCommonList().shouldHaveSize(1);

        verifyEquals(results.converterTabCurrencyName().text(), AUD.getShortProps());
        verifyEquals(results.converterCurrencySymbolFromCommonList().text(), AUD.getShortProps());
        verifyEquals(results.converterCurrencyNameFromCommonList().text(), AUD.getLongProps());
    }

    @Story("User should not find currency which is not in the list")
    @Issue("15")
    @TmsLink("25")
    @Severity(SeverityLevel.NORMAL)
    @Test()
    public void userShouldNotFindCurrencyWhichIsNotInTheList() {
        // --------------------- Test Case ----------------------//
        ConverterToolPage results = converterToolPage().openPage()
                .chooseCurrencyConverterTab(CURR_TAB_FROM)
                    .findCurrencyFor("USH");

        results.getCurrenciesFromCommonList().shouldHaveSize(0);
        results.getCurrenciesFromPopularList().shouldHaveSize(0);

        verifyEquals(results.getTextNothingFound().text(), "Nothing found");
    }

}
