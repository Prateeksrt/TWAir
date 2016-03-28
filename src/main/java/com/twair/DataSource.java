package com.twair;

import java.util.ArrayList;
import java.util.GregorianCalendar;

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

    public static Flights flights = new Flights(){{
        try {
            Flight flight1 = new Flight(locations.get(0), locations.get(1), planes.get(0));
            flight1.setScheduleTime(new GregorianCalendar(2016,4,10, 9, 10, 0), new GregorianCalendar(2016,4,10, 9, 12, 0));
            addFlight(flight1);

            Flight flight2 = new Flight(locations.get(0), locations.get(1), planes.get(1));
            flight2.setScheduleTime(new GregorianCalendar(2016,4,11, 9, 10, 0), new GregorianCalendar(2016,4,11, 9, 12, 0));
            addFlight(flight2);

            Flight flight3 = new Flight(locations.get(0), locations.get(1), planes.get(2));
            flight3.setScheduleTime(new GregorianCalendar(2016,4,12, 9, 10, 0), new GregorianCalendar(2016,4,12, 9, 12, 0));
            addFlight(flight3);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }};
}
