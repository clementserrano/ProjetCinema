package com.projetcinema.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Acteur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Integer noAct;

    @NonNull
    private String nomAct;

    private String prenAct;

    private Date dateNaiss;

    private Date dateDeces;
}
