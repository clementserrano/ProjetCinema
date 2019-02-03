import { Component, OnInit } from '@angular/core';
import { FilmService } from '../service/film.service';
import {ActivatedRoute} from '@angular/router';
import {MatTableDataSource} from '@angular/material';
import {Film} from '../model/film';
import {RealisateurService} from '../service/realisateur.service';
import {Realisateur} from '../model/realisateur';
import {Categorie} from '../model/categorie';
import {CategorieService} from '../service/categorie.service';

@Component({
  selector: 'app-film-item',
  templateUrl: './film-item.component.html',
  styleUrls: ['./film-item.component.css']
})
export class FilmItemComponent implements OnInit {
  film: Film;
  public noFilm;
  // films = [{id: 'test1', titre: 'test1titre'}, {id: 'test2', titre: 'test2titre'}];

  constructor(private filmService: FilmService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.noFilm = this.route.snapshot.paramMap.get('noFilm');
    this.getFilm();
  }

  getFilm(): void {
    this.filmService.getFilm(this.noFilm).subscribe(film => {
      this.film = film;
    });
  }

}
