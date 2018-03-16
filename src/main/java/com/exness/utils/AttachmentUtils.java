package com.exness.utils;

import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

import java.util.List;

import static io.qameta.allure.Allure.addAttachment;
import static java.lang.String.join;

/**
 * Attachments processing class. Use it along with Allure annotations.
 */
@SuppressWarnings({"HideUtilityClassConstructor", "PMD.UseUtilityClass"})
@UtilityClass
public class AttachmentUtils {

    public static void attachUri(final String name, final String data) {
        addAttachment(name, "text/uri-list", data);
    }

    @Attachment(value = "{name}", type = "text/plain")
    public static String attachLog(final String name, final String data) {
        return data;
    }

    @Attachment(value = "{name}", type = "text/plain")
    public static String attachLog(final String name, List<String> dataList) {
        return join("\n", dataList);
    }

    @Attachment(value = "{name}", type = "image/png")
    public static byte[] attachScreenshot(final byte[] bytes, final String name) {
        return bytes;
    }
}
