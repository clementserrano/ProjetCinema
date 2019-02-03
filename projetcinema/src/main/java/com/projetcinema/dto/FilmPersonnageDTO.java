package com.projetcinema.dto;

import com.projetcinema.entity.Personnage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmPersonnageDTO {
    private ActeurShortDTO acteur;
    private String nomPers;

    public FilmPersonnageDTO(Personnage personnage) {
        acteur = new ActeurShortDTO(personnage.getPersonnageId().getActeur());
        nomPers = personnage.getNomPers();
    }
}
