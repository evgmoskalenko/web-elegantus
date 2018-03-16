package com.exness.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Quotes {

    @SerializedName("base")
    @Expose
    private List<QuotesList> quotesList = null;

    public List<QuotesList> getQuotesList() {
        return quotesList;
    }

    public void setBase(List<QuotesList> quotesList) {
        this.quotesList = quotesList;
    }

}