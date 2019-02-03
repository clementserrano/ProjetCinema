import {Component, Input, OnInit, ViewChild} from '@angular/core';
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
    this.getFilms();
  }

  getFilms(): void {
    this.filmService.getFilms().subscribe(films => {
      this.films = films;
      this.dataSource = new MatTableDataSource(this.films);
      this.dataSource.sortingDataAccessor = (item, property) => {
        switch (property) {
          case 'realisateur':
            return item.realisateur.prenRea + ' ' + item.realisateur.nomRea;
          case 'categorie':
            return item.categorie.libelleCat;
          default:
            return item[property];
        }
      };
      this.dataSource.sort = this.sort;
    });
  }
}
