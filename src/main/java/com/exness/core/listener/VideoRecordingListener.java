package com.exness.core.listener;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ITestResult;

import javax.annotation.CheckReturnValue;

/**
 * Video recording listener, which allows .mp4 attachments for each test case.
 */
public class VideoRecordingListener implements IInvokedMethodListener {

    @Override
    public void beforeInvocation(final IInvokedMethod method, final ITestResult testResult) {
        // not implemented
    }

    @Override
    @CheckReturnValue
    public void afterInvocation(final IInvokedMethod method, final ITestResult testResult) {

        //TODO: implement RemoteWebDriver sessionId

//        if (method.isTestMethod() && BASE_CONFIG.remote() != null) {
//            final String fileName = format("http://localhost:4444/video/%s.mp4",
//                    testResult.getAttribute("sessionId"));
//
//            SessionId session = ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId();
//
//            ((RemoteWebDriver) WebDriverRunner.getWebDriver()).getSessionId().toString();
//
//            System.out.println("__________________________________________________"+fileName);
//            System.out.println("__________________________________________________"+testResult.getAttribute("sessionId"));
//            System.out.println("__________________________________________________"+session);
//            attachUri("Video", fileName);
//        }
    }
}