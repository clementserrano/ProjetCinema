package com.projetcinema.dto;

import com.projetcinema.entity.Film;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class FilmDTO {
    private Integer noFilm;
    private String titre;
    private Integer duree;
    private Date dateSortie;
    private Integer budget;
    private Integer montantRecette;
    private RealisateurShortDTO realisateur;
    private CategorieShortDTO categorie;
    private List<FilmPersonnageDTO> personnages;

    public FilmDTO(Film film) {
        noFilm = film.getNoFilm();
        titre = film.getTitre();
        duree = film.getDuree();
        dateSortie = film.getDateSortie();
        budget = film.getBudget();
        montantRecette = film.getMontantRecette();
        realisateur = new RealisateurShortDTO(film.getRealisateur());
        categorie = new CategorieShortDTO(film.getCategorie());
        if(film.getPersonnages() != null){
            personnages = film.getPersonnages().stream()
                    .map(p -> new FilmPersonnageDTO(p)).collect(Collectors.toList());
        }
    }
}
