package com.projetcinema.dto;

import com.projetcinema.entity.Realisateur;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class RealisateurDTO {
    private Integer noRea;
    private String nomRea;
    private String prenRea;
    private List<FilmShortDTO> films;

    public RealisateurDTO(Realisateur r) {
        noRea = r.getNoRea();
        nomRea = r.getNomRea();
        prenRea = r.getPrenRea();
        if(r.getFilms() != null){
            films = r.getFilms().stream().map(f -> new FilmShortDTO(f)).collect(Collectors.toList());
        }
    }
}
