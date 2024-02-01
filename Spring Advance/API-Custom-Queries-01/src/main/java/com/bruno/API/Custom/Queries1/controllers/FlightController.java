package com.bruno.API.Custom.Queries1.controllers;

import com.bruno.API.Custom.Queries1.entities.Flight;
import com.bruno.API.Custom.Queries1.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/show/provision")
    public List<Flight> showListProvision() {
        return flightService.findAllProvision();
    }







}
