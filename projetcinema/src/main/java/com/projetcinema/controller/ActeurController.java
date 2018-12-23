package com.projetcinema.controller;

import com.projetcinema.dao.ActeurRepository;
import com.projetcinema.entity.Acteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("acteur")
public class ActeurController {

    private @Autowired
    ActeurRepository acteurRepository;

    @GetMapping("getActeurs")
    public ResponseEntity<List<Acteur>> getActeurs() {
        return new ResponseEntity<>(acteurRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("getActeur/{id}")
    public ResponseEntity<Acteur> getActeur(@PathVariable Integer id) {
        return new ResponseEntity<>(acteurRepository.findById(id).get(), HttpStatus.OK);
    }

    @PostMapping("addActeur")
    public ResponseEntity<Acteur> addActeur(@RequestBody Map<String, String> body) {
        Acteur acteur = new Acteur();
        acteur.setNomAct(body.get("nomAct"));
        acteur.setPrenAct(body.get("prenAct"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            acteur.setDateDeces(sdf.parse(body.get("dateDeces")));
            acteur.setDateNaiss(sdf.parse(body.get("dateNaiss")));
        } catch (ParseException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mauvais format date", ex);
        }
        return new ResponseEntity<>(acteur, HttpStatus.CREATED);
    }

    @PostMapping("updateActeur/{id}")
    public ResponseEntity<Acteur> updateActeur(@PathVariable Integer id, @RequestBody Map<String, String> body) {
        Acteur acteur = acteurRepository.findById(id).get();
        if (body.get("nomAct") != null) acteur.setNomAct(body.get("nomAct"));
        if (body.get("prenAct") != null) acteur.setPrenAct(body.get("prenAct"));

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            if (body.get("dateNaiss") != null) acteur.setDateNaiss(sdf.parse(body.get("dateNaiss")));
            if (body.get("dateDeces") != null) acteur.setDateDeces(sdf.parse(body.get("dateDeces")));
        } catch (ParseException ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Mauvais format date", ex);
        }
        return new ResponseEntity<>(acteur, HttpStatus.OK);
    }
}