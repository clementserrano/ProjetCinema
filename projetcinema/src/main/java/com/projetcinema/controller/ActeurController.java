package com.projetcinema.controller;

import com.projetcinema.dao.ActeurRepository;
import com.projetcinema.entity.Acteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("acteur")
public class ActeurController {

    private @Autowired
    ActeurRepository acteurRepository;

    @GetMapping("getActeurs")
    public List<Acteur> getActeurs() {
        return acteurRepository.findAll();
    }
}