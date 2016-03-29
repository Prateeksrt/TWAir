package com.twair;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class PlaneTests {

    @Test
    public void shouldHaveTypeAndCapacity() {
        String type = "testType";
        Integer numSeats = 30;
        Map<ClassType, Integer> classMap = new HashMap<>();
        classMap.put(ClassType.ECONOMY, 30);
        Plane plane = new Plane(type, classMap);
        Assert.assertEquals(type, plane.getType());
        Assert.assertEquals(numSeats, plane.getClassType().get(ClassType.ECONOMY));
    }
}
