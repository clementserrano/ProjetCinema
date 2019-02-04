import {Acteur} from './acteur';
import {Film} from './film';

export class Personnage {
  personnageId: {
    film: Film,
    acteur: Acteur
  };
  nomPers: String;
}
