import {Realisateur} from './realisateur';
import {Categorie} from './categorie';
import {Personnage} from './personnage';

export class Film {
  noFilm: number;
  titre: String;
  duree: number;
  dateSortie: Date;
  budget: number;
  montantRecette: number;
  realisateur: Realisateur;
  categorie: Categorie;
  peronnsages: Personnage[];
}
