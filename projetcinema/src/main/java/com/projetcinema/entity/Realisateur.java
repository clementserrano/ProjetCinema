package com.projetcinema.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "realisateur")
@Data
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","realisateur"})
public class Realisateur {
    @Id
    @Column(name = "NoRea")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "realisateur_generator")
    @SequenceGenerator(name = "realisateur_generator", sequenceName = "realisateur_seq", allocationSize = 1, initialValue = 5)
    @NonNull
    private Integer noRea;

    @Column(name = "NomRea")
    @NonNull
    private String nomRea;

    @Column(name = "PrenRea")
    @NonNull
    private String prenRea;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "realisateur")
    private List<Film> films;
}
