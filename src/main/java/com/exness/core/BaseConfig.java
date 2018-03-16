package com.exness.core;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;
import org.aeonbits.owner.Reloadable;

/**
 * Key interface for loading default project properties.
 */
@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources("classpath:config.properties")
public interface BaseConfig extends Config, Reloadable {

    BaseConfig BASE_CONFIG = ConfigFactory.create(BaseConfig.class, System.getenv(), System.getProperties());

    @Key("browser")
    String browser();

    @Key("browser.version")
    String browserVersion();

    @Key("selenide.baseUrl")
    String url();

    @Key("selenide.browser-size")
    String screenResolution();

    @Key("api.path")
    @DefaultValue("/api/")
    String apiPath();

    @Key("api.version")
    @DefaultValue("v2")
    String apiVersion();

    @Key("capabilities.enableVNC")
    String capabilitiesVNC();

    @Key("capabilities.enableVideo")
    String capabilitiesVideo();

    @Key("remote")
    String remote();

    @Key("env")
    String env();

    @Key("suite")
    String suite();

    @Key("threadCount")
    String threadCount();

    @Key("remoteStatus")
    String remoteStatus();

}
