package com.projetcinema.controller;

import com.projetcinema.dao.PersonnageRepository;
import com.projetcinema.entity.Personnage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("personnage")
public class PersonnageController {

    private @Autowired
    PersonnageRepository personnageRepository;

    @GetMapping("getPersonnages")
    public List<Personnage> getPersonnages() {
        return personnageRepository.findAll();
    }
}