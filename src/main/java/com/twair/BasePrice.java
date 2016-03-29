package com.twair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BasePrice {
    public int calculate(Flight flight, int numberOfSeats) {
        return flight.getBasePrice(ClassType.ECONOMY) * numberOfSeats;
    }

    public Map<String, Integer> calculate(List<Flight> flights, int numberOfSeats) {
        Map<String, Integer> priceMap = new HashMap<>();
        for(Flight flight : flights) {
            priceMap.put(flight.getNumber(), calculate(flight, numberOfSeats));
        }
        return priceMap;
    }
}
