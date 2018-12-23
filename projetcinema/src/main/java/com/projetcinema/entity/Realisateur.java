package com.projetcinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "realisateur")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Realisateur {
    @Id
    @Column(name = "NoRea")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Integer noRea;

    @Column(name = "NomRea")
    @NonNull
    private String nomRea;

    @Column(name = "PrenRea")
    @NonNull
    private String prenRea;
}
