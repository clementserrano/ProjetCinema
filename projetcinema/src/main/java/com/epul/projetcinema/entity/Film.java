package com.epul.info.projetcinema.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private @NonNull
    Long noFilm;
    private @NonNull
    String titre;
    private Integer duree;
    private Date dateSortie;
    private Long budget;
    private Long montantRecette;
    private Long noRea;
    private Long codeCat;
}
