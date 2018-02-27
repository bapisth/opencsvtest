package com.hemendra.config;

/**
 * @author Hemendra
 */
public class HeaderMappingRule {
    private String property;
    private String header;
    private String defaultValue;
    private String condition;

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    @Override
    public String toString() {
        return "HeaderMappingRule{" +
                "property='" + property + '\'' +
                ", header='" + header + '\'' +
                ", defaultValue='" + defaultValue + '\'' +
                ", condition='" + condition + '\'' +
                '}';
    }
}
