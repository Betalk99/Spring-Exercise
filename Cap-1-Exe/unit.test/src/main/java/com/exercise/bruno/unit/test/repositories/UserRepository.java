package com.exercise.bruno.unit.test.repositories;

import com.exercise.bruno.unit.test.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Long> {
}
