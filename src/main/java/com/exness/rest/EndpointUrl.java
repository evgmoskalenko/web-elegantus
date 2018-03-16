package com.exness.rest;

public enum EndpointUrl {

    QUOTES("/quotes/full_new.tnt"),
    CALCULATOR_FORMS("/api/calculator/forms/");

    private String resourcePath;

    EndpointUrl(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public String path() {
        return this.resourcePath;
    }

    public String path(String data) {
        return this.resourcePath + data;
    }

}
