package com.hemendra;

import com.google.gson.Gson;
import com.hemendra.config.HeaderMappingRule;
import com.hemendra.model.User;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Hemendra
 */
public class Util {
    public static <T> T parseStringToJSON(String jsonString, Class<T> tClass) {
        Gson gson = new Gson();
        T t = gson.fromJson(jsonString, tClass);// Convert JSON String to Object
        return t;
    }

    /**
     * Finds the class name from the Map
     * @param className
     * @return
     */
    public static Object findClassFromName(String className) throws IllegalAccessException, InstantiationException {
        HashMap<String, Class> classHashMap = nameClassMapper();
        Class aClass = classHashMap.get(className);
        return aClass.newInstance();
    }

    /**
     * Keep all the mapping of the class-name and class as a map
     * @return
     */
    private static HashMap<String, Class> nameClassMapper() {
        HashMap<String, Class> classHashMap = new LinkedHashMap<String, Class>();
        classHashMap.put("user", User.class);
        return classHashMap;
    }

    /**
     * Generates Header Property Mapping required from the HeaderMappingRule
     * @param headerMappingRules
     * @return
     */
    public static Map<String, String> generateHeaderPropertyMapping(List<HeaderMappingRule> headerMappingRules) {
        Map<String, String> headerPropertyMap = headerMappingRules.stream()
                .collect(Collectors.toMap(HeaderMappingRule::getHeader, HeaderMappingRule::getProperty));
        return headerPropertyMap;
    }
}
