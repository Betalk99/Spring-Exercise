package com.exercise.bruno.CRUD.Test.repositories;

import com.exercise.bruno.CRUD.Test.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
