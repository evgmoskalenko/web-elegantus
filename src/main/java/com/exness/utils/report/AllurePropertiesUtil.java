package com.exness.utils.report;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import static com.exness.core.BaseConfig.BASE_CONFIG;
import static java.lang.System.getProperty;
import static java.lang.System.getenv;

public class AllurePropertiesUtil {

    private static final Logger LOGGER = Logger.getLogger(AllurePropertiesUtil.class);

    private static final File file = new File("target/allure-results/environment.properties");

    public static void create() {

        if (!file.exists()) {

            FileOutputStream fos = null;

            try {
                fos = new FileOutputStream(file);

                Properties props = new Properties();
                props.setProperty("Browser", BASE_CONFIG.browser());
                props.setProperty("Browser version", BASE_CONFIG.browserVersion());
                props.setProperty("Base url", BASE_CONFIG.url());
                props.setProperty("Browser size", BASE_CONFIG.screenResolution());
                props.setProperty("Environment", BASE_CONFIG.env());
                props.setProperty("Suite", BASE_CONFIG.suite());
                props.setProperty("Thread count", BASE_CONFIG.threadCount());
                props.setProperty("Selenoid HUB", BASE_CONFIG.remote());
                props.setProperty("VNC", BASE_CONFIG.capabilitiesVNC());
                props.setProperty("Video recording", BASE_CONFIG.capabilitiesVideo());
                props.setProperty("Jenkins Build", getEnvironmentValue("BUILD_URL"));
                props.store(fos, "See https://github.com/allure-framework/allure-app/wiki/Environment");

                fos.close();
            } catch (IOException e) {
                System.out.println("IO problem when writing allure properties file: " + e);
            } finally {
                IOUtils.closeQuietly(fos);
            }
        }
    }

    private static String getPropertiesValue(String propKey) {
        String propertyValue = getProperty(propKey);
        if (propertyValue != null) {
            return propertyValue;
        } else {
            return "Property value is empty";
        }
    }

    private static String getEnvironmentValue(String envKey) {
        String environmentValue = getenv(envKey);
        if (environmentValue != null) {
            return environmentValue;
        } else {
            return "Environment value is empty";
        }
    }


}
