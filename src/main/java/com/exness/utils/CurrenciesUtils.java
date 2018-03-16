package com.exness.utils;

import java.util.stream.DoubleStream;

public class CurrenciesUtils {

    private double currencyBid;
    private double currencyAsk;

    public CurrenciesUtils(double currencyBid, double currencyAsk) {
        this.currencyBid = currencyBid;
        this.currencyAsk = currencyAsk;
    }

    private double getConvertCurrencyValue() {
        double[] numbers = {this.currencyBid, this.currencyAsk};
        return DoubleStream.of(numbers).average().getAsDouble();
    }

    public double convert(double currencyValue) {
        return currencyValue * getConvertCurrencyValue();
    }

}
