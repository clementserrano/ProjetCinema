package com.projetcinema.controller;

import com.projetcinema.dao.CategorieRepository;
import com.projetcinema.entity.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("categorie")
public class CategorieController {

    private @Autowired
    CategorieRepository categorieRepository;

    @GetMapping
    public ResponseEntity<List<Categorie>> getCategories() {
        return new ResponseEntity<>(categorieRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<Categorie> getCategorie(@PathVariable String id) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        if (!optionalCategorie.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(optionalCategorie.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie) {
        categorieRepository.save(categorie);
        return new ResponseEntity<>(categorie, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie categorie) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(categorie.getCodeCat());
        if (!optionalCategorie.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        categorieRepository.save(categorie);
        return new ResponseEntity<>(categorie, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteFilm(@RequestBody Categorie categorie) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(categorie.getCodeCat());
        if (!optionalCategorie.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        categorieRepository.delete(optionalCategorie.get());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFilm(@PathVariable String id) {
        Optional<Categorie> optionalCategorie = categorieRepository.findById(id);
        if (!optionalCategorie.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        categorieRepository.delete(optionalCategorie.get());
        return new ResponseEntity(HttpStatus.OK);
    }
}