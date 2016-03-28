package com.twair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Price {
    public int calculate(Flight flight, int numberOfSeats) {
        return flight.getBasePrice() * numberOfSeats;
    }

    public Map<String, Integer> calculate(List<Flight> flights, int numberOfSeats) {
        Map<String, Integer> priceMap = new HashMap<>();
        for(Flight flight : flights) {
            priceMap.put(flight.getNumber(), calculate(flight, numberOfSeats));
        }
        return priceMap;
    }
}
