import {Component, OnInit} from '@angular/core';
import {FilmService} from '../service/film.service';
import {Film} from '../model/film';
import {Categorie} from '../model/categorie';
import {Realisateur} from '../model/realisateur';
import {Personnage} from '../model/personnage';
import {RealisateurService} from '../service/realisateur.service';
import {PersonnageService} from '../service/personnage.service';
import {CategorieService} from '../service/categorie.service';

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

  constructor(private filmService: FilmService, private realisateurService: RealisateurService,
              private categorieService: CategorieService, private personnageService: PersonnageService) {
  }

  ngOnInit() {
    this.getRealisateurs();
    this.getCategories();
  }

  getRealisateurs(): void {
    this.realisateurService.getRealisateurs().subscribe(realisateurs => {
      this.realisateurs = realisateurs;
    });
  }

  getCategories(): void {
    this.categorieService.getCategories().subscribe(categories => {
      this.categories = categories;
    });
  }

  /*
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
   */
}
