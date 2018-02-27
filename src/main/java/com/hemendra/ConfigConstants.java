package com.hemendra;

/**
 * @author Hemendra
 */
public interface ConfigConstants {
    String USER_MAPPING_JSON = "{\n" +
            "  \"mapToEntity\":\"user\",\n" +
            "  \"mappingRules\":[\n" +
            "    {\n" +
            "      \"property\":\"name\",\n" +
            "      \"header\":\"first_name\",\n" +
            "      \"defaultValue\":\"NA\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"property\":\"roll\",\n" +
            "      \"header\":\"roll_number\",\n" +
            "      \"defaultValue\":\"9999\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"property\":\"branch\",\n" +
            "      \"header\":\"branch\",\n" +
            "      \"defaultValue\":\"MCA\"\n" +
            "    }\n" +
            "    ]\n" +
            "}";
}
