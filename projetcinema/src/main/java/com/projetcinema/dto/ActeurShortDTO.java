package com.projetcinema.dto;

import com.projetcinema.entity.Acteur;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActeurShortDTO {
    private Integer noAct;
    private String nomAct;
    private String prenAct;

    public ActeurShortDTO(Acteur acteur) {
        noAct = acteur.getNoAct();
        nomAct = acteur.getNomAct();
        prenAct = acteur.getPrenAct();
    }
}
