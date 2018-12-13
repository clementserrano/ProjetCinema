package com.projetcinema.controller;

import com.projetcinema.dao.RealisateurRepository;
import com.projetcinema.entity.Realisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("realisateur")
public class RealisateurController {

    private @Autowired
    RealisateurRepository realisateurRepository;

    @GetMapping("getRealisateurs")
    public List<Realisateur> getRealisateurs() {
        return realisateurRepository.findAll();
    }
}