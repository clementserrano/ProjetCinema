package com.projetcinema.dto;

import com.projetcinema.entity.Realisateur;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RealisateurShortDTO {
    private Integer noRea;
    private String nomRea;
    private String prenRea;

    public RealisateurShortDTO(Realisateur realisateur) {
        noRea = realisateur.getNoRea();
        nomRea = realisateur.getNomRea();
        prenRea = realisateur.getPrenRea();
    }
}
