package com.bruno.API.Custom.Queries1.services;

import com.bruno.API.Custom.Queries1.entities.Flight;
import com.bruno.API.Custom.Queries1.entities.Status;
import com.bruno.API.Custom.Queries1.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Collectors;
@Service
public class FlightService {

    @Autowired
    private FlightRepository flightRepository;

    private static final int NUMBER_OF_FLIGHTS = 50;


    public List<Flight> findAll() {
        return flightRepository.findFlights();
    }

    public List<Flight> findAllProvision() {
        Random random = new Random();
        List<Flight> flights = new ArrayList<>();
        for(int i = 1; i <= NUMBER_OF_FLIGHTS; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + i);
            flight.setFromAirport(generateRandomString(random));
            flight.setToAirport(generateRandomString(random));
            flight.setStatus(Status.ONTIME);
            flights.add(flight);
        }
        flightRepository.saveAllAndFlush(flights);

        return flights;

    }

    private String generateRandomString(Random random) {
        return IntStream.range(0, 5)
                .mapToObj(i -> String.valueOf((char) ('A' + random.nextInt(26))))
                .collect(Collectors.joining());
    }




}
