package com.projetcinema.controller;

import com.projetcinema.dao.ActeurRepository;
import com.projetcinema.dao.FilmRepository;
import com.projetcinema.dao.PersonnageRepository;
import com.projetcinema.dto.ActeurPersonnageDTO;
import com.projetcinema.dto.PersonnageDTO;
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
import java.util.stream.Collectors;

@RestController
@RequestMapping("personnage")
@CrossOrigin(origins = "http://localhost:4200")
public class PersonnageController {

    private @Autowired
    PersonnageRepository personnageRepository;
    private @Autowired
    ActeurRepository acteurRepository;
    private @Autowired
    FilmRepository filmRepository;


    @GetMapping
    public ResponseEntity<List<PersonnageDTO>> getPersonnages() {
        return new ResponseEntity<>(personnageRepository.findAll().stream()
                .map(p -> new PersonnageDTO(p)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("{idFilm}/{idActeur}")
    public ResponseEntity<PersonnageDTO> getPersonnage(@PathVariable Integer idFilm, @PathVariable Integer idActeur) {
        Optional<Film> optionalFilm = filmRepository.findById(idFilm);
        if (!optionalFilm.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Optional<Acteur> optionalActeur = acteurRepository.findById(idActeur);
        if (!optionalActeur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        PersonnageId personnageId = new PersonnageId();
        personnageId.setActeur(optionalActeur.get());
        personnageId.setFilm(optionalFilm.get());

        Optional<Personnage> optionalPersonnage = personnageRepository.findById(personnageId);
        if (!optionalPersonnage.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(new PersonnageDTO(optionalPersonnage.get()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PersonnageDTO> addPersonnage(@RequestBody Personnage personnage) {
        Personnage newPersonnage = personnageRepository.save(personnage);
        return new ResponseEntity(new PersonnageDTO(newPersonnage), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<PersonnageDTO> updatePersonnage(@RequestBody Personnage personnage) {
        Optional<Personnage> optionalPersonnage = personnageRepository.findById(personnage.getPersonnageId());
        if (!optionalPersonnage.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Personnage newPersonnage = personnageRepository.save(personnage);
        return new ResponseEntity<>(new PersonnageDTO(newPersonnage), HttpStatus.OK);
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