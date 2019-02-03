package com.projetcinema.dto;

import com.projetcinema.entity.PersonnageId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmPersonnageIdDTO {
    private ActeurShortDTO acteur;

    public FilmPersonnageIdDTO(PersonnageId personnageId) {
        acteur = new ActeurShortDTO(personnageId.getActeur());
    }
}
