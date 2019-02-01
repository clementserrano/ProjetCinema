package com.projetcinema.controller;

import com.projetcinema.dao.ActeurRepository;
import com.projetcinema.entity.Acteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("acteur")
@CrossOrigin(origins = "http://localhost:4200")
public class ActeurController {

    private @Autowired
    ActeurRepository acteurRepository;

    @GetMapping
    public ResponseEntity<List<Acteur>> getActeurs() {
        return new ResponseEntity<>(acteurRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Acteur> getActeur(@PathVariable Integer id) {
        Optional<Acteur> optionalActeur = acteurRepository.findById(id);
        if (!optionalActeur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(optionalActeur.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Acteur> addActeur(@RequestBody Acteur acteur) {
        acteurRepository.save(acteur);
        return new ResponseEntity(acteur, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Acteur> updateActeur(@RequestBody Acteur acteur) {
        Optional<Acteur> optionalActeur = acteurRepository.findById(acteur.getNoAct());
        if (!optionalActeur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        acteurRepository.save(acteur);
        return new ResponseEntity(acteur, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteActeur(@RequestBody Acteur acteur) {
        Optional<Acteur> optionalActeur = acteurRepository.findById(acteur.getNoAct());
        if (!optionalActeur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        acteurRepository.delete(optionalActeur.get());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteActeur(@PathVariable Integer id) {
        Optional<Acteur> optionalActeur = acteurRepository.findById(id);
        if (!optionalActeur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        acteurRepository.delete(optionalActeur.get());
        return new ResponseEntity(HttpStatus.OK);
    }
}