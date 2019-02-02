package com.projetcinema.dto;

import com.projetcinema.entity.Personnage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonnageDTO {
    private ActeurShortDTO acteur;
    private FilmShortDTO film;
    private String nomPers;

    public PersonnageDTO(Personnage personnage) {
        acteur = new ActeurShortDTO(personnage.getPersonnageId().getActeur());
        film = new FilmShortDTO(personnage.getPersonnageId().getFilm());
        nomPers = personnage.getNomPers();
    }
}
