package com.projetcinema.dto;

import com.projetcinema.entity.Categorie;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategorieDTO {
    private String codeCat;
    private String libelleCat;
    private List<FilmShortDTO> films;

    public CategorieDTO(Categorie categorie) {
        codeCat = categorie.getCodeCat();
        libelleCat = categorie.getLibelleCat();
        films = categorie.getFilms().stream()
                .map(f -> new FilmShortDTO(f)).collect(Collectors.toList());
    }
}
