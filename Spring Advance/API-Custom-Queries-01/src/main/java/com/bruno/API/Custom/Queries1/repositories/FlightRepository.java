package com.bruno.API.Custom.Queries1.repositories;

import com.bruno.API.Custom.Queries1.entities.Flight;
import com.bruno.API.Custom.Queries1.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FlightRepository extends JpaRepository <Flight, Long> {

    @Query(value = "SELECT * FROM Flight WHERE status = 'ONTIME'", nativeQuery = true)
    public List<Flight> findFlights();




}
