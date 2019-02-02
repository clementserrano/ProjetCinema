import { Component, OnInit } from '@angular/core';
import { FilmService } from '../service/film.service';
import {ActivatedRoute} from '@angular/router';
import {MatTableDataSource} from '@angular/material';
import {Film} from '../model/film';
import {RealisateurService} from '../service/realisateur.service';
import {Realisateur} from '../model/realisateur';

@Component({
  selector: 'app-film-item',
  templateUrl: './film-item.component.html',
  styleUrls: ['./film-item.component.css']
})
export class FilmItemComponent implements OnInit {
  film: Film;
  realisateur: Realisateur;
  public noFilm;
  constructor(private filmService: FilmService, private realisateurService: RealisateurService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.noFilm = this.route.snapshot.paramMap.get('noFilm');
    this.getFilm();
  }
  /*TODO faire comme dans film-list.component pour récup les infos du film et les afficher ensuite*/
  getFilm(): void {
    this.filmService.getFilm(this.noFilm).subscribe(film => {
      this.film = film;
    });
    console.log(this.film.realisateur.noRea);
    this.realisateurService.getRealisateur(this.film.realisateur.noRea).subscribe(realisateur => {
      this.realisateur = realisateur;
    });
  }

}
