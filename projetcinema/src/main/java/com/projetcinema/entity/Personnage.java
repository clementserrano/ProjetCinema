package com.projetcinema.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "personnage")
@Data
@NoArgsConstructor
public class Personnage {
    @EmbeddedId
    private PersonnageId personnageId;

    @Column(name = "NomPers")
    @NonNull
    private String nomPers;
}
