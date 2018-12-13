package com.projetcinema.controller;

import com.projetcinema.dao.CategorieRepository;
import com.projetcinema.entity.Categorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("categorie")
public class CategorieController {

    private @Autowired
    CategorieRepository categorieRepository;

    @GetMapping("getCategories")
    public List<Categorie> getCategories() {
        return categorieRepository.findAll();
    }
}