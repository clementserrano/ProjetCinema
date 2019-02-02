package com.projetcinema.dto;

import com.projetcinema.entity.Personnage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActeurPersonnageDTO {
    private FilmShortDTO film;
    private String nomPers;

    public ActeurPersonnageDTO(Personnage personnage) {
        film = new FilmShortDTO(personnage.getPersonnageId().getFilm());
        nomPers = personnage.getNomPers();
    }
}