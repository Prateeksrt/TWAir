package com.twair;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

public class DataSource {
    public static ArrayList<String> locations = new ArrayList<String>() {{
        add("Hyderabad");
        add("Bangalore");
    }};

    public static ArrayList<Plane> planes = new ArrayList<Plane>(){{
        add(new Plane("Boeing777-200LR(77L)", 195));
        add(new Plane("Airbus A319 V2", 144));
        add(new Plane("Airbus A321", 152));
    }};

    public static FlightSearch fetchFlights() throws Exception {
        List<Flight> flightList = new ArrayList<>();
        Flight flight1 = new Flight(locations.get(0), locations.get(1), planes.get(0), new GregorianCalendar(2016,3,10, 9, 10, 0), new GregorianCalendar(2016,3,10, 9, 12, 0));
        Flight flight2 = new Flight(locations.get(0), locations.get(1), planes.get(1), new GregorianCalendar(2016,3,11, 9, 10, 0), new GregorianCalendar(2016,3,11, 9, 12, 0));
        Flight flight3 = new Flight(locations.get(0), locations.get(1), planes.get(2), new GregorianCalendar(2016,3,12, 9, 10, 0), new GregorianCalendar(2016,3,12, 9, 12, 0));

        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        FlightSearch allFlights = new FlightSearch(flightList);
        return allFlights;
    }
}
