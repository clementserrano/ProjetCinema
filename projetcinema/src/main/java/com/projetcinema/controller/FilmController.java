package com.projetcinema.controller;

import com.projetcinema.dao.FilmRepository;
import com.projetcinema.entity.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("film")
public class FilmController {

    private @Autowired
    FilmRepository filmRepository;

    @GetMapping("getFilms")
    public List<Film> getFilms() {
        return filmRepository.findAll();
    }
}
