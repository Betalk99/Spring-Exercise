package com.dev.Spring.Repositories.Exercise1.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "cars")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CarEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String modelName;
    @Column(nullable = false)
    private String serialNumber;
    @Column(nullable = true)
    private String currentPrice;

}
