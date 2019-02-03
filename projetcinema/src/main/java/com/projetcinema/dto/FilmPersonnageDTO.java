package com.projetcinema.dto;

import com.projetcinema.entity.Personnage;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmPersonnageDTO {
    private FilmPersonnageIdDTO personnageId;
    private String nomPers;

    public FilmPersonnageDTO(Personnage personnage) {
        personnageId = new FilmPersonnageIdDTO(personnage.getPersonnageId());
        nomPers = personnage.getNomPers();
    }
}
