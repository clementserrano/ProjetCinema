package com.projetcinema.controller;

import com.projetcinema.dao.FilmRepository;
import com.projetcinema.dto.FilmDTO;
import com.projetcinema.entity.Film;
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
@CrossOrigin(origins = "http://localhost:4200")
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
    public ResponseEntity<Film> addFilm(@RequestBody Film film) {
        filmRepository.save(film);
        return new ResponseEntity<>(film, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Film> updateFilm(@RequestBody Film film) {
        Optional<Film> optionalFilm = filmRepository.findById(film.getNoFilm());
        if (!optionalFilm.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        filmRepository.save(film);
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity deleteFilm(@RequestBody Film film) {
        Optional<Film> optionalFilm = filmRepository.findById(film.getNoFilm());
        if (!optionalFilm.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        filmRepository.delete(optionalFilm.get());
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFilm(@PathVariable Integer id) {
        Optional<Film> optionalFilm = filmRepository.findById(id);
        if (!optionalFilm.isPresent()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        filmRepository.delete(optionalFilm.get());
        return new ResponseEntity(HttpStatus.OK);
    }
}
