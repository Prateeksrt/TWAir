package com.twair;

import java.util.Map;

public class Plane {
    private String type;
    private Map<ClassType, Integer> classTypeMap;

    public Plane(String type, Map<ClassType, Integer> classTypeMap) {
        this.type = type;
        this.classTypeMap = classTypeMap;
    }

    public String getType() {
        return type;
    }

    public Map<ClassType, Integer> getClassType() {
        return classTypeMap;
    }
}
