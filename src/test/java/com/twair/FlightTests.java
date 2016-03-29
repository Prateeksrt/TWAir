package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class FlightTests {
    private String source;
    private String dest;
    private Plane plane;
    private Calendar departure;
    private Calendar arrival;
    private Map<ClassType, Double> basePriceMap;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        dest = "TestDestination";
        Map<ClassType, Integer> classMap = new HashMap<>();
        classMap.put(ClassType.ECONOMY, 30);
        basePriceMap = new HashMap<>();
        basePriceMap.put(ClassType.ECONOMY, 5000.0);
        plane = new Plane("type", classMap);
        departure = new GregorianCalendar(2016,3,10, 9, 10, 0);
        arrival = new GregorianCalendar(2016,3,10, 10, 10, 0);
    }

    @Test
    public void shouldHaveSourceDestination() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival, basePriceMap);
        Assert.assertEquals(source, flight.getSource());
        Assert.assertEquals(dest, flight.getDestination());
    }

    @Test
    public void shouldHaveArrivalAndDeparture() throws Exception {
        Calendar departure = new GregorianCalendar(2016,4,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,10, 11, 10, 0);
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival, basePriceMap);
        Assert.assertEquals(departure, flight.getDepartureTime());
        Assert.assertEquals(arrival, flight.getArrivalTime());
    }

    @Test(expected=Exception.class)
    public void DepartureDateCannotBeGreaterOrEqualToArrivalTime() throws Exception {
        Calendar departure = new GregorianCalendar(2016,5,10, 9, 10, 0);
        Calendar arrival = new GregorianCalendar(2016,4,10, 11, 10, 0);
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival, basePriceMap);
    }

    @Test
    public void shouldReturnTrueIfThereAreSeatsOfThatClass() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival, basePriceMap);
        Assert.assertTrue(flight.hasClass(ClassType.ECONOMY));
    }

    @Test
    public void shouldReturnFalseIfThereAreNoSeatsOfThatClass() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival, basePriceMap);
        Assert.assertFalse(flight.hasClass(ClassType.BUSINESS));
    }

    @Test
    public void shouldHaveBasePriceForSpecifiedClass() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival, basePriceMap);
        Assert.assertEquals(5000, flight.getBasePrice(ClassType.ECONOMY).intValue());
    }

    @Test
    public void shouldReturnZeroIfBasePriceIsNotAvailableForTheClassType() throws Exception {
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival, basePriceMap);
        Assert.assertEquals(0, flight.getBasePrice(ClassType.BUSINESS).intValue());
    }

    @Test
    public void shouldReturnFalseIfNoTravelCallForTheFlight() throws Exception {
        Integer numberOfSeats = 5;
        Flight flight = new Flight("F001", source, dest, plane, departure, arrival, basePriceMap);
        Assert.assertFalse(flight.canBook(ClassType.BUSINESS, numberOfSeats));
    }
}
