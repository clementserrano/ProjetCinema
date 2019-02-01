package com.projetcinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","personnages"})
public class Personnage {
    @EmbeddedId
    private PersonnageId personnageId;

    @Column(name = "NomPers")
    @NonNull
    private String nomPers;
}
