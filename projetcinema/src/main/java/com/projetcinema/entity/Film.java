package com.projetcinema.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Integer nofilm;

    @NonNull
    private String titre;

    @NonNull
    private Integer duree;

    @NonNull
    private Date datesortie;

    @NonNull
    private Integer budget;

    @NonNull
    private Integer montantrecette;

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "norea", nullable = false)
    private Realisateur realisateur; // TODO

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "codeCat", nullable = false)
    private Categorie categorie;
}
