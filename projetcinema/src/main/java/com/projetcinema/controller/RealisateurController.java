package com.projetcinema.controller;

import com.projetcinema.dao.RealisateurRepository;
import com.projetcinema.entity.Realisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("realisateur")
public class RealisateurController {

    private @Autowired
    RealisateurRepository realisateurRepository;

    @GetMapping
    public ResponseEntity<List<Realisateur>> getRealisateurs() {
        return new ResponseEntity<>(realisateurRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Realisateur> getRealisateur(@PathVariable Integer id) {
        Optional<Realisateur> optionalRealisateur = realisateurRepository.findById(id);
        if (!optionalRealisateur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(optionalRealisateur.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Realisateur> addRealisateur(@RequestBody Realisateur realisateur) {
        realisateurRepository.save(realisateur);
        return new ResponseEntity(realisateur, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Realisateur> updateActeur(@RequestBody Realisateur realisateur) {
        Optional<Realisateur> optionalRealisateur = realisateurRepository.findById(realisateur.getNoRea());
        if (!optionalRealisateur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        realisateurRepository.save(realisateur);
        return new ResponseEntity(realisateur, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteRealisateur(@RequestBody Realisateur realisateur) {
        Optional<Realisateur> optionalRealisateur = realisateurRepository.findById(realisateur.getNoRea());
        if (!optionalRealisateur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        realisateurRepository.delete(optionalRealisateur.get());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteRealisateur(@PathVariable Integer id) {
        Optional<Realisateur> optionalRealisateur = realisateurRepository.findById(id);
        if (!optionalRealisateur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        realisateurRepository.delete(optionalRealisateur.get());
        return new ResponseEntity(HttpStatus.OK);
    }
}