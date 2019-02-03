package com.projetcinema.dto;

import com.projetcinema.entity.Film;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FilmShortDTO {
    private Integer noFilm;
    private String titre;
    private Date dateSortie;

    public FilmShortDTO(Film film) {
        noFilm = film.getNoFilm();
        titre = film.getTitre();
        dateSortie = film.getDateSortie();
    }
}
