package com.projetcinema.dto;

import com.projetcinema.entity.Acteur;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ActeurDTO {
    private Integer noAct;
    private String nomAct;
    private String prenAct;
    private Date dateNaiss;
    private Date dateDeces;
    private List<ActeurPersonnageDTO> personnages;

    public ActeurDTO(Acteur acteur) {
        noAct = acteur.getNoAct();
        nomAct = acteur.getNomAct();
        prenAct = acteur.getPrenAct();
        dateNaiss = acteur.getDateNaiss();
        dateDeces = acteur.getDateDeces();
        personnages = acteur.getPersonnages().stream()
                .map(p -> new ActeurPersonnageDTO(p)).collect(Collectors.toList());
    }
}
