package com.twair;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FlightsTests {
    private String source;
    private String destination;
    private Calendar departure;
    private Calendar arrival;
    private Flights allFlights;

    @Before
    public void setUp() throws Exception {
        source = "TestSource";
        destination = "TestDestination";
        departure = new GregorianCalendar(2016,3,10, 9, 10, 0);
        arrival = new GregorianCalendar(2016,3,10, 10, 10, 0);

        Plane plane1 = new Plane("type1", 30);
        Flight flight1 = new Flight(source, destination, plane1, new GregorianCalendar(2016,3,10, 9, 10, 0), new GregorianCalendar(2016,3,10, 11, 10, 0));
        Flight flight2 = new Flight(source, destination, plane1, new GregorianCalendar(2016,4,10, 9, 10, 0), new GregorianCalendar(2016,4,10, 11, 10, 0));

        allFlights = new Flights();
        allFlights.addFlight(flight1);
        allFlights.addFlight(flight2);
    }

    @Test
    public void shouldReturnListOfFlightsForSourceDestination() throws Exception {
        Plane plane1 = new Plane("type1", 30);
        Plane plane2 = new Plane("type2", 60);
        Flight flight1 = new Flight(source, destination, plane1, departure, arrival);
        Flight flight2 = new Flight("TestSource1", destination, plane2, departure, arrival);
        Flight flight3 = new Flight(source, destination, plane1, departure, arrival);
        Flights allFlights = new Flights();
        allFlights.addFlight(flight1);
        allFlights.addFlight(flight2);
        allFlights.addFlight(flight3);

        List<Flight> flights = allFlights.searchByLocation(source, destination).getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(source, flights.get(1).getSource());
        Assert.assertEquals(destination, flights.get(1).getDestination());
        Assert.assertEquals(2, flights.size());
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateSource() throws Exception {
        allFlights.searchByLocation(null, destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void sourceCannotBeEmpty() throws Exception {
        allFlights.searchByLocation("", destination);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldMandateDestination() throws Exception {
        allFlights.searchByLocation(source, null);
    }

    @Test(expected=IllegalArgumentException.class)
    public void destinationCannotBeEmpty() throws Exception {
        allFlights.searchByLocation(source, "");
    }

    @Test
    public void shouldReturnMatchingFlightsBasedOnDepartureDate() throws Exception {
        Calendar departureDate = new GregorianCalendar(2016,3,10);
        List<Flight> flights = allFlights.searchByDeparture(departureDate).getFlightList();
        Assert.assertEquals(source, flights.get(0).getSource());
        Assert.assertEquals(destination, flights.get(0).getDestination());
        Assert.assertEquals(1, flights.size());
    }

    @Test
    public void shouldNotConsiderDepartureDateIfNull() throws Exception {
        List<Flight> flights = allFlights.searchByDeparture(null).getFlightList();
        Assert.assertEquals(2, flights.size());
    }
}
