package com.exness.rest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuotesList {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("bid")
    @Expose
    private String bid;
    @SerializedName("ask")
    @Expose
    private String ask;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getAsk() {
        return ask;
    }

    public void setAsk(String ask) {
        this.ask = ask;
    }

}