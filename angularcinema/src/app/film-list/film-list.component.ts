import {Component, OnInit} from '@angular/core';
import {FilmService} from '../service/film.service';
import {Film} from '../model/film';

@Component({
  selector: 'app-film-list',
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.css'],
  providers: [FilmService]
})
export class FilmListComponent implements OnInit {
  films: Film[];

  constructor(private filmService: FilmService) {
  }

  ngOnInit() {
    this.getFilms();
  }

  getFilms(): void {
    this.filmService.getFilms().subscribe(films => this.films = films);
  }


}
