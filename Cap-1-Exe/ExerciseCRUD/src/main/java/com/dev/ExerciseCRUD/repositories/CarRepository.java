package com.dev.ExerciseCRUD.repositories;

import com.dev.ExerciseCRUD.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
