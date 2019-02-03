import {Component, OnInit, ViewChild} from '@angular/core';
import {FilmService} from '../service/film.service';
import {Film} from '../model/film';
import {MatSort, MatTableDataSource} from '@angular/material';
import {CategorieService} from '../service/categorie.service';

@Component({
  selector: 'app-film-list',
  templateUrl: './film-list.component.html',
  styleUrls: ['./film-list.component.css'],
  providers: [FilmService]
})
export class FilmListComponent implements OnInit {
  films: Film[];
  categories: any[];
  displayedColumns: string[] = ['noFilm', 'titre', 'duree', 'dateSortie', 'realisateur', 'categorie'];
  dataSource;

  @ViewChild(MatSort) sort: MatSort;

  constructor(private filmService: FilmService, private categorieService: CategorieService) {
  }

  ngOnInit() {
    this.getFilms();
    this.getCategories();
  }

  getFilms(): void {
    this.filmService.getFilms().subscribe(films => {
      this.films = films;
      this.updateDataSource(this.films);
    });
  }

  getCategories(): void {
    this.categorieService.getCategories().subscribe(categories => {
      this.categories = categories;
      this.categories.forEach(function (c) {
        c.selected = true;
      });
    });
  }

  changeCat(): void {
    const newFilms: Film[] = [];
    const selectedCategories = this.categories.filter(function (c) {
      return c.selected === true;
    });

    this.films.forEach(function (f) {
      if (selectedCategories.find(function (c) {
        return c.codeCat === f.categorie.codeCat;
      })) {
        newFilms.push(f);
      }
    });

    this.updateDataSource(newFilms);
  }

  updateDataSource(films: Film[]) {
    this.dataSource = new MatTableDataSource(films);
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
  }
}
