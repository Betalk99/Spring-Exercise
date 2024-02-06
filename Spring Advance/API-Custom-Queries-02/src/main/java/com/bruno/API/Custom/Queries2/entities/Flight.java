package com.bruno.API.Custom.Queries2.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Table
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor



@NamedNativeQueries({
        @NamedNativeQuery(
                name = "Flight.findFlights",
                query = "SELECT * FROM Flight ",
                resultClass = Flight.class

        )
})




public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String fromAirport;
    private String toAirport;

    @Enumerated(value = EnumType.STRING)
    private Status status;

}