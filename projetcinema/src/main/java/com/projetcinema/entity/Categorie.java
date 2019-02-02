package com.projetcinema.entity;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorie")
@Data
@NoArgsConstructor
public class Categorie {
    @Id
    @Column(name = "CodeCat")
    @NonNull
    private String codeCat;

    @Column(name = "LibelleCat")
    @NonNull
    private String libelleCat;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "categorie")
    private List<Film> films;
}
