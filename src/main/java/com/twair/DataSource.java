package com.twair;

import java.util.*;

public class DataSource {
    final private static DataSource dataSource = new DataSource();
    public static DataSource instance() {
        return dataSource;
    }

    public List<String> fetchLocations() {
        List<String> locations = new ArrayList<String>();
        locations.add("Hyderabad");
        locations.add("Bangalore");
        return locations;
    }

    public List<Plane> fetchPlanes() {
        List<Plane> planes = new ArrayList<Plane>();
        Map<ClassType, Integer> classTypeMap = new HashMap<>();
        classTypeMap.put(ClassType.ECONOMY, 195);
        classTypeMap.put(ClassType.BUSINESS, 35);
        classTypeMap.put(ClassType.FIRST, 8);
        planes.add(new Plane("Boeing777-200LR(77L)", classTypeMap));

        classTypeMap = new HashMap<>();
        classTypeMap.put(ClassType.ECONOMY, 144);
        planes.add(new Plane("Airbus A319 V2", classTypeMap));

        classTypeMap = new HashMap<>();
        classTypeMap.put(ClassType.ECONOMY, 152);
        classTypeMap.put(ClassType.BUSINESS, 20);
        planes.add(new Plane("Airbus A321", classTypeMap));
        return planes;
    }

    public FlightSearch fetchFlights() throws Exception {
        List<Flight> flightList = new ArrayList<>();
        List<Plane> planes = fetchPlanes();
        List<String> locations = fetchLocations();
        Map<ClassType, Double> basePriceMap = new HashMap<>();
        basePriceMap.put(ClassType.ECONOMY, 6000.0);
        basePriceMap.put(ClassType.BUSINESS, 13000.0);
        basePriceMap.put(ClassType.FIRST, 20000.0);
        Flight flight1 = new Flight("F001", locations.get(0), locations.get(1), planes.get(0), new GregorianCalendar(2016,3,10, 9, 10, 0), new GregorianCalendar(2016,3,10, 9, 12, 0), basePriceMap);
        flight1.book(ClassType.ECONOMY, 190);

        basePriceMap = new HashMap<>();
        basePriceMap.put(ClassType.ECONOMY, 4000.0);
        Flight flight2 = new Flight("F002", locations.get(0), locations.get(1), planes.get(1), new GregorianCalendar(2016,3,11, 9, 10, 0), new GregorianCalendar(2016,3,11, 9, 12, 0), basePriceMap);

        basePriceMap = new HashMap<>();
        basePriceMap.put(ClassType.ECONOMY, 5000.0);
        basePriceMap.put(ClassType.BUSINESS, 10000.0);
        Flight flight3 = new Flight("F003", locations.get(0), locations.get(1), planes.get(2), new GregorianCalendar(2016,3,12, 9, 10, 0), new GregorianCalendar(2016,3,12, 9, 12, 0), basePriceMap);

        flightList.add(flight1);
        flightList.add(flight2);
        flightList.add(flight3);
        FlightSearch allFlights = new FlightSearch(flightList);
        return allFlights;
    }
}
