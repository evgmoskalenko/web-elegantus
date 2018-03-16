package com.exness.core.model;

public enum Currencies {

    USD("USD", "Американский доллар"),
    EUR("EUR", "Евро"),
    CHF("CHF", "Швейцарский франк"),
    JPY("JPY", "Японская иена"),
    AUD("AUD", "Австралийский доллар"),
    CAD("CAD", "Канадский доллар"),

    GBP("GBP", "Фунт стерлингов"),
    UAH("UAH", "Украинская гривна"),
    RUB("RUB", "Российский рубль");

    private String currencyShortProps;
    private String currencyLongProps;

    Currencies(final String currencyShortProps, final String currencyLongProps) {
        this.currencyShortProps = currencyShortProps;
        this.currencyLongProps = currencyLongProps;
    }

    public String getShortProps() {
        return currencyShortProps;
    }

    public String getLongProps() {
        return currencyLongProps;
    }

}
