package com.bruno.API.Custom.Queries2.controllers;

import com.bruno.API.Custom.Queries2.entities.Flight;
import com.bruno.API.Custom.Queries2.entities.Status;
import com.bruno.API.Custom.Queries2.repositories.FlightRepository;
import com.bruno.API.Custom.Queries2.servicies.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightService flightService;

    @GetMapping("/show/list")
    public List<Flight> showList() {
        return flightService.findAll();
    }

    @GetMapping("/generate/list")
    public List<Flight> generateList(@RequestParam(name = "n", defaultValue = "100") int n) {
        return flightService.findAllProvision(n);
    }

    @GetMapping("/show/on-time")
    public List<Flight> showOnTime() {
        return flightService.findOnTimeFlights();
    }

    @GetMapping("/paged")
    public Page<Flight> getPagedFlights(@RequestParam(name = "page", defaultValue = "0") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int size) {
        return flightService.getPagedFlights(page, size);
    }

    @GetMapping("/show/delayedcancelled")
    public List<Flight> getDelayedOrCancelledFlights() {
        return flightService.getDelayedOrCancelledFlights();
    }

    @GetMapping("/show/customstatus")
    public List<Flight> getCustomStatusFlights(@RequestParam(name = "p1") Status p1,
                                               @RequestParam(name = "p2") Status p2) {
        return flightService.getCustomStatusFlights(p1, p2);
    }

}
