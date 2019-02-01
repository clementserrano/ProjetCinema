package com.projetcinema.dao;

import com.projetcinema.entity.Personnage;
import com.projetcinema.entity.PersonnageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@RepositoryRestResource
@CrossOrigin
public interface PersonnageRepository extends JpaRepository<Personnage, PersonnageId> {
    List<Personnage> findByPersonnageId_Acteur_NoAct(Integer noAct);
}
