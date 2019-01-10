import {Component, OnInit, ViewChild} from '@angular/core';
import {FilmService} from '../service/film.service';
import {Film} from '../model/film';
import {MatSort, MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-film-list',
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.css'],
  providers: [FilmService]
})
export class FilmListComponent implements OnInit {
  films: Film[];
  displayedColumns: string[] = ['noFilm', 'titre', 'duree', 'dateSortie', 'realisateur', 'categorie'];
  dataSource;

  @ViewChild(MatSort) sort: MatSort;

  constructor(private filmService: FilmService) {
  }

  ngOnInit() {
    this.getFilms(function () {
      this.dataSource.sort = this.sort;
    });
  }

  getFilms(callback): void {
    this.filmService.getFilms().subscribe(films => {
      this.films = films;
      this.dataSource = new MatTableDataSource(this.films);
    });
  }


}
