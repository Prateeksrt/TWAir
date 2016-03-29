package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PriceTests {
    private int numberOfSeats;
    private Flight flight = mock(Flight.class);
    private String source;
    private List<Flight> flightList;

    @Before
    public void setUp() throws Exception {
        numberOfSeats = 5;
        source = "TestSource";
        String destination = "TestDestination";

        Map<ClassType, Integer> classTypeMap1 = new HashMap<ClassType, Integer>();
        classTypeMap1.put(ClassType.ECONOMY, 30);
        Plane plane1 = new Plane("type1", classTypeMap1);
        Map<ClassType, Integer> classTypeMap2 = new HashMap<ClassType, Integer>();
        classTypeMap2.put(ClassType.ECONOMY, 30);
        Plane plane2 = new Plane("type1", classTypeMap2);
        Flight flight1 = new Flight("F001", source, destination, plane1, new GregorianCalendar(2016,3,10, 9, 10, 0), new GregorianCalendar(2016,3,10, 11, 10, 0));
        flight1.setBasePrice(ClassType.ECONOMY, 6000);
        Flight flight2 = new Flight("F002", source, destination, plane2, new GregorianCalendar(2016,4,10, 9, 10, 0), new GregorianCalendar(2016,4,10, 11, 10, 0));
        flight2.setBasePrice(ClassType.ECONOMY, 4000);

        flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);

    }

    @Test
    public void shouldGiveTotalPriceForNumberOfSeats() throws Exception {
        BasePrice basePrice = new BasePrice();
        when(flight.getBasePrice(ClassType.ECONOMY)).thenReturn(6000);
        int totalCost = basePrice.calculate(flight, numberOfSeats);
        Assert.assertEquals(30000, totalCost);
    }

    @Test
    public void shouldCalculatePriceForListOfFlights() throws Exception {
        BasePrice basePrice = new BasePrice();
        Map<String, Integer> priceMap = basePrice.calculate(flightList, numberOfSeats);
        Assert.assertEquals(new Integer(30000), priceMap.get("F001"));
        Assert.assertEquals(new Integer(20000), priceMap.get("F002"));
    }
}
