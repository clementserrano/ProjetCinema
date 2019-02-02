package com.projetcinema.dto;

import com.projetcinema.entity.Categorie;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategorieShortDTO {
    private String codeCat;
    private String libelleCat;

    public CategorieShortDTO(Categorie categorie) {
        codeCat = categorie.getCodeCat();
        libelleCat = categorie.getLibelleCat();
    }
}
