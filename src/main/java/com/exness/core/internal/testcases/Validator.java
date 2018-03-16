package com.exness.core.internal.testcases;

import com.exness.core.BaseTest;
import io.qameta.allure.Step;
import org.apache.log4j.Logger;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public interface Validator {

    Logger LOGGER = Logger.getLogger(BaseTest.class);

    @Step("Verify characters count in string")
    default void verifyStringCount(String s, int expectedLength) {
        int actualLength = s.length();
        if (actualLength <= expectedLength) {
            LOGGER.info("Current characters: " +
                    actualLength + ", and expected length: " + expectedLength);
        } else {
            throw new ExceptionInInitializerError("Current characters: " +
                    actualLength + ", and expected length: " + expectedLength);
        }
    }

    @Step("Verify that \"{expected}\" = \"{actual}\"")
    default void verifyEquals(final String actual, final String expected, final String message) {
        assertEquals(actual, expected, message);
    }

    @Step("Verify that \"{expected}\" = \"{actual}\"")
    default void verifyEquals(final String actual, final String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify that \"{expected}\" = \"{actual}\"")
    default void verifyEquals(final double actual, final double expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify that \"{actual}\" not contains \"{containsString}\"")
    default void verifyTextNotContains(final String actual, final String containsString) {
        assertTrue(!actual.contains(containsString));
    }

    @Step("Verify that url \"{actual}\" contains \"{containsString}\"")
    default void verifyUrlContains(final String actual, final String containsString) {
        assertTrue(actual.contains(containsString));
    }

}

