package com.dev.Spring.Repositories.Exercise1.repositories;

import com.dev.Spring.Repositories.Exercise1.entities.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends JpaRepository<CarEntity, Long> {
}
