package com.dev.Spring.Repositories.Exercise2.repositories;

import com.dev.Spring.Repositories.Exercise2.entities.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestMapping;

@RepositoryRestResource
public interface ProgrammingLanguageRepository extends JpaRepository<ProgrammingLanguage, Long> {
}
