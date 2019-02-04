package com.projetcinema.controller;

import com.projetcinema.dao.ActeurRepository;
import com.projetcinema.dto.ActeurDTO;
import com.projetcinema.entity.Acteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("acteur")
@CrossOrigin(origins = "*")
public class ActeurController {

    private @Autowired
    ActeurRepository acteurRepository;

    @GetMapping
    public ResponseEntity<List<ActeurDTO>> getActeurs() {
        return new ResponseEntity<>(acteurRepository.findAll().stream()
                .map(a -> new ActeurDTO(a)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<ActeurDTO> getActeur(@PathVariable Integer id) {
        Optional<Acteur> optionalActeur = acteurRepository.findById(id);
        if (!optionalActeur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new ActeurDTO(optionalActeur.get()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ActeurDTO> addActeur(@RequestBody Acteur acteur) {
        Acteur newActeur = acteurRepository.save(acteur);
        return new ResponseEntity(new ActeurDTO(newActeur), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ActeurDTO> updateActeur(@RequestBody Acteur acteur) {
        Optional<Acteur> optionalActeur = acteurRepository.findById(acteur.getNoAct());
        if (!optionalActeur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Acteur newActeur = acteurRepository.save(acteur);
        return new ResponseEntity(new ActeurDTO(newActeur), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteActeur(@PathVariable Integer id) {
        Optional<Acteur> optionalActeur = acteurRepository.findById(id);
        if (!optionalActeur.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        acteurRepository.delete(optionalActeur.get());
        return new ResponseEntity(HttpStatus.OK);
    }
}
