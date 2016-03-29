package com.twair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasePrice {
    public int calculate(Flight flight, ClassType classType, int numberOfSeats) {
        return flight.getBasePrice(classType) * numberOfSeats;
    }

    public Map<String, Integer> calculate(List<Flight> flights, ClassType classType, int numberOfSeats) {
        Map<String, Integer> priceMap = new HashMap<>();
        for(Flight flight : flights) {
            priceMap.put(flight.getNumber(), calculate(flight, classType, numberOfSeats));
        }
        return priceMap;
    }
}
