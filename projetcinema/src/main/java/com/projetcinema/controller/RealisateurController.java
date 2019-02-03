package com.projetcinema.controller;

import com.projetcinema.dao.RealisateurRepository;
import com.projetcinema.dto.RealisateurDTO;
import com.projetcinema.entity.Realisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("realisateur")
@CrossOrigin(origins = "http://localhost:4200")
public class RealisateurController {

    private @Autowired
    RealisateurRepository realisateurRepository;

    @GetMapping
    public ResponseEntity<List<RealisateurDTO>> getRealisateurs() {
        return new ResponseEntity<>(realisateurRepository.findAll().stream()
                .map(r -> new RealisateurDTO(r)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<RealisateurDTO> getRealisateur(@PathVariable Integer id) {
        Optional<Realisateur> optionalRealisateur = realisateurRepository.findById(id);
        if (!optionalRealisateur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new RealisateurDTO(optionalRealisateur.get()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RealisateurDTO> addRealisateur(@RequestBody Realisateur realisateur) {
        Realisateur newRealisateur = realisateurRepository.save(realisateur);
        return new ResponseEntity(new RealisateurDTO(newRealisateur), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<RealisateurDTO> updateActeur(@RequestBody Realisateur realisateur) {
        Optional<Realisateur> optionalRealisateur = realisateurRepository.findById(realisateur.getNoRea());
        if (!optionalRealisateur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Realisateur newRealisateur = realisateurRepository.save(realisateur);
        return new ResponseEntity(new RealisateurDTO(newRealisateur), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteRealisateur(@PathVariable Integer id) {
        Optional<Realisateur> optionalRealisateur = realisateurRepository.findById(id);
        if (!optionalRealisateur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        realisateurRepository.delete(optionalRealisateur.get());
        return new ResponseEntity(HttpStatus.OK);
    }
}