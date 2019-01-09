import {Acteur} from './acteur';
import {Film} from './film';

export class Personnage {
  perosnnageId: {
    film: Film,
    acteur: Acteur
  };
  nomPers: String;
}
