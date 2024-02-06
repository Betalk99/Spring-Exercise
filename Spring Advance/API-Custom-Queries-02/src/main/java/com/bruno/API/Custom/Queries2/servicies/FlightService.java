package com.bruno.API.Custom.Queries2.servicies;

import com.bruno.API.Custom.Queries2.entities.Status;
import com.bruno.API.Custom.Queries2.entities.Flight;
import com.bruno.API.Custom.Queries2.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class FlightService {
    @Autowired
    private FlightRepository flightRepository;

    public List<Flight> findAll() {
        return flightRepository.findFlights();
    }

    public List<Flight> findAllProvision(int n) {
        Random random = new Random();
        List<Flight> flights = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            Flight flight = new Flight();
            flight.setDescription("Flight " + i);
            flight.setFromAirport(generateRandomString(random));
            flight.setToAirport(generateRandomString(random));
            flight.setStatus(generateRandomStatus());
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

    private Status generateRandomStatus() {
        return Status.values()[new Random().nextInt(Status.values().length)];
    }

    public List<Flight> findOnTimeFlights() {
        return flightRepository.findOnTimeFlights(Status.ONTIME);
    }

    public Page<Flight> getPagedFlights(int page, int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return flightRepository.findAllPaged(pageable);
    }

    public List<Flight> getDelayedOrCancelledFlights() {
        return flightRepository.findDelayedOrCancelledFlights(Status.DELAYED, Status.CANCELLED);
    }


    public List<Flight> getCustomStatusFlights(Status p1, Status p2) {
        return flightRepository.findCustomStatusFlights(p1.name().toString(), p2.name().toString());
    }







}

