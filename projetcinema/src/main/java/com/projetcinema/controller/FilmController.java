package com.projetcinema.controller;

import com.projetcinema.dao.FilmRepository;
import com.projetcinema.dto.FilmDTO;
import com.projetcinema.entity.Film;
import com.projetcinema.entity.Personnage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("film")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:8100"})
public class FilmController {

    private @Autowired
    FilmRepository filmRepository;

    @GetMapping
    public ResponseEntity<List<FilmDTO>> getFilms() {
        return new ResponseEntity<>(filmRepository.findAll().stream()
                .map(f -> new FilmDTO(f)).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity<FilmDTO> getFilm(@PathVariable Integer id) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (!optionalFilm.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(new FilmDTO(optionalFilm.get()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FilmDTO> addFilm(@RequestBody Film film) {
        List<Personnage> personnages = film.getPersonnages();
        film.setPersonnages(null);
        Film newFilm = filmRepository.save(film);
        personnages.stream().forEach(p -> p.getPersonnageId().setFilm(newFilm));
        newFilm.setPersonnages(personnages);
        Film returnFilm = filmRepository.save(newFilm);
        return new ResponseEntity<>(new FilmDTO(returnFilm), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<FilmDTO> updateFilm(@RequestBody Film film) {
        Optional<Film> optionalFilm = filmRepository.findById(film.getNoFilm());
        if (!optionalFilm.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        List<Personnage> personnages = optionalFilm.get().getPersonnages();
        personnages.clear();
        film.getPersonnages().forEach(p -> p.getPersonnageId().setFilm(optionalFilm.get()));
        personnages.addAll(film.getPersonnages());
        film.setPersonnages(personnages);
        Film updatedFilm = filmRepository.save(film);
        return new ResponseEntity<>(new FilmDTO(updatedFilm), HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFilm(@PathVariable Integer id) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (!optionalFilm.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        filmRepository.delete(optionalFilm.get());
        return new ResponseEntity(HttpStatus.OK);
    }
}
