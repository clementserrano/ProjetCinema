package com.projetcinema.controller;

import com.projetcinema.dao.ActeurRepository;
import com.projetcinema.dao.FilmRepository;
import com.projetcinema.dao.PersonnageRepository;
import com.projetcinema.entity.Acteur;
import com.projetcinema.entity.Film;
import com.projetcinema.entity.Personnage;
import com.projetcinema.entity.PersonnageId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("personnage")
public class PersonnageController {

    private @Autowired
    PersonnageRepository personnageRepository;

    private @Autowired
    FilmRepository filmRepository;

    private @Autowired
    ActeurRepository acteurRepository;

    @GetMapping("getPersonnages")
    public ResponseEntity<List<Personnage>> getPersonnages() {
        return new ResponseEntity<>(personnageRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping("addPersonnage")
    public ResponseEntity<Personnage> addPersonnage(Map<String, String> body) {
        Film film = filmRepository.findById(Integer.parseInt(body.get("idFilm"))).get();
        Acteur acteur = acteurRepository.findById(Integer.parseInt(body.get("idActeur"))).get();
        PersonnageId personnageId = new PersonnageId(film, acteur);
        Personnage personnage = new Personnage();
        personnage.setPersonnageId(personnageId);
        personnage.setNomPers("Coco");
        personnageRepository.save(personnage);
        return new ResponseEntity(personnage, HttpStatus.CREATED);
    }
}