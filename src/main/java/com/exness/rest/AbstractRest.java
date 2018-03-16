package com.exness.rest;

import com.exness.rest.listener.AllureRestAssuredListener;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import static com.exness.core.BaseConfig.BASE_CONFIG;
import static io.restassured.http.ContentType.*;

public abstract class AbstractRest {

    /**
     * Configure Rest-Assured http client
     */
    protected void configureRestAssured() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(BASE_CONFIG.url())
                .setBasePath(BASE_CONFIG.apiPath())
                .setContentType(JSON)
                .addFilter(new AllureRestAssuredListener())
                .build().accept(JSON).contentType(JSON);
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .build().contentType(BINARY);
        RestAssured.useRelaxedHTTPSValidation();
    }

}
