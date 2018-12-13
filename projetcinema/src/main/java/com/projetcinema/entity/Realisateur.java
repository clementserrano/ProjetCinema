package com.projetcinema.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Realisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Integer noRea;

    @NonNull
    private String nomRea;

    @NonNull
    private String prenRea;
}
