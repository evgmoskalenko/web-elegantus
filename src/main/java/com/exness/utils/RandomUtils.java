package com.exness.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;

public class RandomUtils {

    private static final Logger LOGGER = Logger.getLogger(RandomUtils.class);

    private static final AtomicInteger count = new AtomicInteger(0);
    private static final Random rand = new Random();

    private static int generateAutoIncrement() {
        return count.incrementAndGet();
    }

    private static String getCapitalsCriteria(boolean conditionCapitalsCriteria) {
        if (!conditionCapitalsCriteria) return "abcdefghjklmnopqrstuvwxyz1234567890";
        else return "abcdefghjklmnopqrstuvwxyz1234567890".toUpperCase();
    }

    public static int generateRandomInt(int min, int max) {
        rand.setSeed(System.currentTimeMillis());
        return min + rand.nextInt(max - min + 1);
    }

    public static String generateRandomString() {
        return RandomStringUtils.random(8, "abcdefghjklmnopqrstuvwxyz");
    }

    @Deprecated
    public static String generateRandomString(String firstPart) {
        return firstPart+RandomStringUtils.random(8, "abcdefghjklmnopqrstuvwxyz");
    }

    @Deprecated
    public static String generateRandomString(String firstPart, String secondPart) {
        return firstPart+RandomStringUtils.random(8, "abcdefghjklmnopqrstuvwxyz")+secondPart;
    }

    public static String generateRandomString(int count, boolean conditionCapitalsCriteria) {
        return RandomStringUtils.random(count, getCapitalsCriteria(conditionCapitalsCriteria));
    }

    public static String generateRandomString(int count, String firstPart, boolean conditionCapitalsCriteria) {
        return firstPart+RandomStringUtils.random(count, getCapitalsCriteria(conditionCapitalsCriteria));
    }

    public static String generateRandomString(int count, String firstPart, String secondPart, boolean conditionCapitalsCriteria) {
        return firstPart+"-"+RandomStringUtils.random(count, getCapitalsCriteria(conditionCapitalsCriteria))+"-"+secondPart;
    }

    public static String generateRandomEmail() {
        String email = "test_"+generateRandomString()+"@"+generateRandomString()+".com";
        LOGGER.info(format("Generate random 'email': %s", email));
        return email;
    }

    public static String generateRandomEmail(String emailDomainCriteria) {
        return "test_"+generateRandomString()+"@"+emailDomainCriteria;
    }

    public static String generateRandomEmailWithAutoIncrement(String emailDomainCriteria) {
        return "test-"+generateAutoIncrement()+"@"+emailDomainCriteria;
    }

}
