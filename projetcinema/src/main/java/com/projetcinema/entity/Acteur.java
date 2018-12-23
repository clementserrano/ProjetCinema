package com.projetcinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "acteur")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Acteur {
    @Id
    @Column(name = "NoAct")
    @GeneratedValue(strategy = GenerationType.AUTO)
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
}
