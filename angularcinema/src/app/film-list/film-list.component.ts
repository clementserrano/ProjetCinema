import {Component, OnInit} from '@angular/core';
import {FilmService} from '../service/film.service';
import {Film} from '../model/film';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-film-list',
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.css'],
  providers: [FilmService]
})
export class FilmListComponent implements OnInit {
  films: Film[];
  displayedColumns: string[] = ['no', 'titre', 'duree', 'dateSortie', 'realisateur', 'categorie'];
  dataSource;

  constructor(private filmService: FilmService) {
  }

  ngOnInit() {
    this.getFilms();
  }

  getFilms(): void {
    this.filmService.getFilms().subscribe(films => {
      this.films = films;
      this.dataSource = new MatTableDataSource(this.films);
    });
  }


}
