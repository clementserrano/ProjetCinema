package com.projetcinema.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Personnage {
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "noFilm", nullable = false)
    private Film film; // TODO

    @NonNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "noAct", nullable = false)
    private Acteur acteur; // TODO

    @NonNull
    private String nomPers;
}
