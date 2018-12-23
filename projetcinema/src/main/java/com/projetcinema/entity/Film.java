package com.projetcinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "film")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Film {
    @Id
    @Column(name ="NoFilm")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Integer noFilm;

    @Column(name ="Titre")
    @NonNull
    private String titre;

    @Column(name ="Duree")
    @NonNull
    private Integer duree;

    @Column(name ="DateSortie")
    @NonNull
    private Date dateSortie;

    @Column(name ="Budget")
    @NonNull
    private Integer budget;

    @NonNull
    @Column(name ="MontantRecette")
    private Integer montantRecette;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "NoRea", nullable = false)
    private Realisateur realisateur;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "CodeCat", nullable = false)
    private Categorie categorie;
}
