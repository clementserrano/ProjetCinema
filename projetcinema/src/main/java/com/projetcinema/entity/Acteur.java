package com.projetcinema.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "acteur")
@Data
@NoArgsConstructor
public class Acteur {
    @Id
    @Column(name = "NoAct")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acteur_generator")
    @SequenceGenerator(name = "acteur_generator", sequenceName = "acteur_seq", allocationSize = 1, initialValue = 20)
    @NonNull
    private Integer noAct;

    @Column(name = "NomAct")
    @NonNull
    private String nomAct;

    @Column(name = "PrenAct")
    private String prenAct;

    @Column(name = "DateNaiss")
    private Date dateNaiss;

    @Column(name = "DateDeces")
    private Date dateDeces;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "personnageId.acteur")
    private List<Personnage> personnages;
}
