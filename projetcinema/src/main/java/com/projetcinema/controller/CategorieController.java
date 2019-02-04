package com.projetcinema.controller;

import com.projetcinema.dao.CategorieRepository;
import com.projetcinema.dto.CategorieDTO;
import com.projetcinema.entity.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("categorie")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
public class CategorieController {

    private @Autowired
    CategorieRepository categorieRepository;

    @GetMapping
    public ResponseEntity<List<CategorieDTO>> getCategories() {
        return new ResponseEntity<>(categorieRepository.findAll().stream()
                .map(c -> new CategorieDTO(c)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<CategorieDTO> getCategorie(@PathVariable String id) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        if (!optionalCategorie.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new CategorieDTO(optionalCategorie.get()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategorieDTO> addCategorie(@RequestBody Categorie categorie) {
        Categorie newCategorie = categorieRepository.save(categorie);
        return new ResponseEntity<>(new CategorieDTO(newCategorie), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<CategorieDTO> updateCategorie(@RequestBody Categorie categorie) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(categorie.getCodeCat());
        if (!optionalCategorie.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Categorie newCategorie = categorieRepository.save(categorie);
        return new ResponseEntity<>(new CategorieDTO(newCategorie), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFilm(@PathVariable String id) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        if (!optionalCategorie.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        categorieRepository.delete(optionalCategorie.get());
        return new ResponseEntity(HttpStatus.OK);
    }
}
