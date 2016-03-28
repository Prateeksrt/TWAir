package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

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

        Plane plane1 = new Plane("type1", 30);
        Plane plane2 = new Plane("type1", 5);
        Flight flight1 = new Flight("F001", source, destination, plane1, new GregorianCalendar(2016,3,10, 9, 10, 0), new GregorianCalendar(2016,3,10, 11, 10, 0));
        flight1.setBasePrice(6000);
        Flight flight2 = new Flight("F002", source, destination, plane2, new GregorianCalendar(2016,4,10, 9, 10, 0), new GregorianCalendar(2016,4,10, 11, 10, 0));
        flight2.setBasePrice(4000);

        flightList = new ArrayList<>();
        flightList.add(flight1);
        flightList.add(flight2);

    }

    @Test
    public void shouldGiveTotalPriceForNumberOfSeats() throws Exception {
        Price price = new Price();
        when(flight.getBasePrice()).thenReturn(6000);
        int totalCost = price.calculate(flight, numberOfSeats);
        Assert.assertEquals(30000, totalCost);
    }

    @Test
    public void shouldCalculatePriceForListOfFlights() throws Exception {
        Price price = new Price();
        Map<String, Integer> priceMap = price.calculate(flightList, numberOfSeats);
        Assert.assertEquals(new Integer(30000), priceMap.get("F001"));
        Assert.assertEquals(new Integer(20000), priceMap.get("F002"));
    }
}
