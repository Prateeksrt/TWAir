package com.twair;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@EnableAutoConfiguration
public class TwAirApplication {
	@RequestMapping("/")
	public String home(Model model) {
        model.addAttribute("locations", DataSource.locations);
		return "FlightSearch";
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public String search(@ModelAttribute(value="searchForm") SearchForm searchForm, Model model) {
		Flights matchingFlights = DataSource.flights.searchByLocation(searchForm.getFrom(), searchForm.getTo());
		matchingFlights = matchingFlights.searchByDeparture(searchForm.getDepartureDate());
		model.addAttribute("flights", matchingFlights.getFlightList());
		model.addAttribute("locations", DataSource.locations);
		return "FlightSearch";
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(TwAirApplication.class, args);
	}
}
