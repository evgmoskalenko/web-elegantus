package com.exness.rest.listener;

import io.restassured.RestAssured;
import io.restassured.filter.log.LogDetail;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RestAssuredLogListener implements ITestListener {

    private static final Logger LOGGER = Logger.getLogger(RestAssuredLogListener.class);

    private ByteArrayOutputStream request  = new ByteArrayOutputStream();
    private ByteArrayOutputStream response = new ByteArrayOutputStream();

    private PrintStream requestVar  = new PrintStream(request, true);
    private PrintStream responseVar = new PrintStream(response, true);


    public void onStart(ITestContext iTestContext) {
        RestAssured.filters(new ResponseLoggingFilter(LogDetail.ALL, responseVar),
                new RequestLoggingFilter(LogDetail.ALL, requestVar));
    }

    public void onTestSuccess(ITestResult iTestResult) {
        LOGGER.info(request);
        LOGGER.info(response);
    }

    public void onTestFailure(ITestResult iTestResult) {
        onTestSuccess(iTestResult);
    }

    public void onTestStart(ITestResult iTestResult) {
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onFinish(ITestContext iTestContext) {

    }

}