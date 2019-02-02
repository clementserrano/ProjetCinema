import {Component, OnInit} from '@angular/core';
import {FilmService} from '../service/film.service';
import {Film} from '../model/film';
import {Categorie} from '../model/categorie';
import {Realisateur} from '../model/realisateur';
import {Personnage} from '../model/personnage';

@Component({
  selector: 'app-film-add-update',
  templateUrl: './film-add-update.component.html',
  styleUrls: ['./film-add-update.component.css']
})
export class FilmAddUpdateComponent implements OnInit {

  film: Film;
  categories: Categorie[];
  realisateurs: Realisateur[];
  personnages: Personnage[];
  datasource;
  displayedColumns: string[] = ['acteur', 'role'];

  constructor(filmService: FilmService) {
  }

  ngOnInit() {
  }

}
