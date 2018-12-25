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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("personnage")
public class PersonnageController {

    private @Autowired
    PersonnageRepository personnageRepository;
    private @Autowired
    ActeurRepository acteurRepository;
    private @Autowired
    FilmRepository filmRepository;


    @GetMapping
    public ResponseEntity<List<Personnage>> getPersonnages() {
        return new ResponseEntity<>(personnageRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{idFilm}/{idActeur}")
    public ResponseEntity<Personnage> getPersonnage(@PathVariable Integer idFilm, @PathVariable Integer idActeur) {
        Optional<Film> optionalFilm = filmRepository.findById(idFilm);
        if (!optionalFilm.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Optional<Acteur> optionalActeur = acteurRepository.findById(idActeur);
        if (!optionalActeur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        PersonnageId personnageId = new PersonnageId();
        personnageId.setActeur(optionalActeur.get());
        personnageId.setFilm(optionalFilm.get());

        Optional<Personnage> optionalPersonnage = personnageRepository.findById(personnageId);
        if (!optionalPersonnage.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(optionalPersonnage.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Personnage> addPersonnage(@RequestBody Personnage personnage) {
        personnageRepository.save(personnage);
        return new ResponseEntity(personnage, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Personnage> updatePersonnage(@RequestBody Personnage personnage) {
        Optional<Personnage> optionalPersonnage = personnageRepository.findById(personnage.getPersonnageId());
        if (!optionalPersonnage.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        personnageRepository.save(personnage);
        return new ResponseEntity<>(personnage, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deletePersonnage(@RequestBody Personnage personnage) {
        Optional<Personnage> optionalPersonnage = personnageRepository.findById(personnage.getPersonnageId());
        if (!optionalPersonnage.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        personnageRepository.delete(optionalPersonnage.get());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{idFilm}/{idActeur}")
    public ResponseEntity deletePersonnage(@PathVariable Integer idFilm, @PathVariable Integer idActeur) {
        Optional<Film> optionalFilm = filmRepository.findById(idFilm);
        if (!optionalFilm.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Optional<Acteur> optionalActeur = acteurRepository.findById(idActeur);
        if (!optionalActeur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        PersonnageId personnageId = new PersonnageId();
        personnageId.setActeur(optionalActeur.get());
        personnageId.setFilm(optionalFilm.get());

        Optional<Personnage> optionalPersonnage = personnageRepository.findById(personnageId);
        if (!optionalPersonnage.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        personnageRepository.delete(optionalPersonnage.get());
        return new ResponseEntity(HttpStatus.OK);
    }
}