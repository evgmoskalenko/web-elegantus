package com.exness.utils;

import org.testng.Assert;

import java.util.Objects;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.executeJavaScript;
import static com.codeborne.selenide.Selenide.sleep;

public class JSExecutor {

    public JSExecutor(){
        if(!Objects.equals(baseUrl, "http://localhost:8080")) {
            executeJavaScript("$(document).ready()");
        } else {
            Assert.fail("Base url is equals 'http://localhost:8080'");
        }
    }

    public void POSTWithParams(final String requestUrl, final String param){
        executeJavaScript(String.format("$.post('%s%s', %s).done()", baseUrl, requestUrl, param));
        sleep(300);
    }

    public void GETWithParam(final String requestUrl, final String param){
        executeJavaScript(String.format("$.get('%s', %s).done()", requestUrl, param));
        sleep(300);
    }

    /**
     * Make GET request to baseUrl
     * @param request
     * request with params
     */
    public void GETRequest(final String request){
        executeJavaScript(String.format("$.get('%s%s').done()", baseUrl, request));
    }

}
