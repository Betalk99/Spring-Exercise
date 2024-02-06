package com.bruno.API.Custom.Queries2.repositories;

import com.bruno.API.Custom.Queries2.entities.Flight;
import com.bruno.API.Custom.Queries2.entities.Status;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@EnableJpaRepositories
@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

//    @Query(value = "SELECT * FROM Flight ", nativeQuery = true)
    List<Flight> findFlights();

    @Query(value = "SELECT * FROM Flight ", nativeQuery = true)
    Page<Flight> findAllPaged(Pageable pageable);

    @Query(value = "SELECT * FROM Flight WHERE status = :#{#status.toString()}", nativeQuery = true)
    List<Flight> findOnTimeFlights(@Param("status") Status statuto);

    @Query(value = "SELECT * FROM Flight WHERE status = :#{#madonna.toString()} OR status = :#{#statuss.toString()}", nativeQuery = true)
    List<Flight> findDelayedOrCancelledFlights(@Param("madonna") Status statuto, @Param("statuss") Status status1);

    @Query(value = "SELECT * FROM flight AS f WHERE f.status = :statuto OR f.status = :statuss", nativeQuery = true)
    List<Flight> findCustomStatusFlights(@Param("statuto") String statuto, @Param("statuss") String status1);

    @Query(value = "SELECT * FROM Flight AS f WHERE f.description LIKE '%:desc%'", nativeQuery = true)
    List<Flight> findFlightsByDescription(@Param("desc") String descriptionToSearch);


}
