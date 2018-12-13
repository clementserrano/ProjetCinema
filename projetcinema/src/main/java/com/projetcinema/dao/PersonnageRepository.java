package com.projetcinema.dao;

import com.projetcinema.entity.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin
public interface PersonnageRepository extends JpaRepository<Personnage, Integer> {
}
