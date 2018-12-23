package com.projetcinema.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "categorie")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categorie {
    @Id
    @Column(name = "CodeCat")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private String codeCat;

    @Column(name = "LibelleCat")
    @NonNull
    private String libelleCat;
}
