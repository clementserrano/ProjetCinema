package com.projetcinema.dao;

import com.projetcinema.entity.Realisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource
@CrossOrigin
public interface RealisateurRepository extends JpaRepository<Realisateur, Integer> {
}