package com.hemendra.config;

import java.util.List;

/**
 * @author Hemendra
 */
public class HeaderConfig {
    private String mapToEntity;
    private List<HeaderMappingRule> mappingRules;

    public String getMapToEntity() {
        return mapToEntity;
    }

    public void setMapToEntity(String mapToEntity) {
        this.mapToEntity = mapToEntity;
    }

    public List<HeaderMappingRule> getMappingRules() {
        return mappingRules;
    }

    public void setMappingRules(List<HeaderMappingRule> mappingRules) {
        this.mappingRules = mappingRules;
    }
}
