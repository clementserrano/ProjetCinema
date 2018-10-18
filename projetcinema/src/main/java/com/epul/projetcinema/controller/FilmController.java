package com.epul.projetcinema.controller;

import com.epul.projetcinema.dao.FilmRepository;
import com.epul.projetcinema.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/film")
public class FilmController {

    @Autowired
    private FilmRepository repository;

    @GetMapping("/getFilms")
    public List<Film> getFilms() {
        return repository.findAll();
    }
}
