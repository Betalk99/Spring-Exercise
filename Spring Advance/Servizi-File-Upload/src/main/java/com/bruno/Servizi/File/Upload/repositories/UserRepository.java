package com.bruno.Servizi.File.Upload.repositories;

import com.bruno.Servizi.File.Upload.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
