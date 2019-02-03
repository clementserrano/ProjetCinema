import {Component, OnInit, ViewChild} from '@angular/core';
import {FilmService} from '../service/film.service';
import {Film} from '../model/film';
import {Categorie} from '../model/categorie';
import {Realisateur} from '../model/realisateur';
import {RealisateurService} from '../service/realisateur.service';
import {PersonnageService} from '../service/personnage.service';
import {CategorieService} from '../service/categorie.service';
import {MatDialog, MatSnackBar, MatSort, MatTableDataSource} from '@angular/material';
import {DialogAddPersonnageComponent} from '../dialog-add-personnage/dialog-add-personnage.component';
import {DialogAddCategorieComponent} from '../dialog-add-categorie/dialog-add-categorie.component';
import {DialogAddRealisateurComponent} from '../dialog-add-realisateur/dialog-add-realisateur.component';
import {ActivatedRoute, Router} from '@angular/router';
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
  updateMode: boolean;

  dataSource;
  @ViewChild(MatSort) sort: MatSort;
  displayedColumns: string[] = ['acteur', 'role', 'delete'];

  constructor(private filmService: FilmService, private realisateurService: RealisateurService,
              private categorieService: CategorieService, private personnageService: PersonnageService,
              public dialog: MatDialog, private snackBar: MatSnackBar, private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit() {
    const id = this.route.snapshot.params['noFilm'];
    if (id === undefined) {
      this.film = new Film();
      this.film.personnages = [];
      this.updateMode = false;
    } else {
      this.filmService.getFilm(id).subscribe(film => {
        this.film = film;
        this.film.dateSortie = new Date(film.dateSortie);
        this.updateDataSource();
        this.updateMode = true;
      });
    }

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

  openDialogRealisateur(): void {
    const dialogRef = this.dialog.open(DialogAddRealisateurComponent, {
      width: '400px',
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.realisateurService.addRealisateur(result).subscribe(res => {
          this.realisateurs.push(res);
          this.snackBar.open('Réalisateur ajouté avec succès !', 'OK', {
            duration: 4000,
          });
        }, error => {
          this.printError(error);
        });
      }
    });
  }

  openDialogCategorie(): void {
    const dialogRef = this.dialog.open(DialogAddCategorieComponent, {
      width: '400px',
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.categorieService.addCategorie(result).subscribe(res => {
          this.categories.push(res);
          this.snackBar.open('Catégorie ajoutée avec succès !', 'OK', {
            duration: 4000,
          });
        }, error => {
          this.printError(error);
        });
      }
    });
  }

  openDialogPersonnage(): void {
    const dialogRef = this.dialog.open(DialogAddPersonnageComponent, {
      width: '400px',
      data: {personnageId: {}}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.film.personnages.push(result);
        this.updateDataSource();
      }
    });
  }

  saveFilm(): void {
    if (this.updateMode === false) {
      this.filmService.addFilm(this.film).subscribe(res => {
        this.snackBar.open('Film ajouté avec succès !', 'OK', {
          duration: 4000,
        });
        this.router.navigate(['/films']);
      }, error => {
        this.printError(error);
      });
    } else if (this.updateMode === true) {
      this.filmService.updateFilm(this.film).subscribe(res => {
        this.snackBar.open('Film mis à jour avec succès !', 'OK', {
          duration: 4000,
        });
        this.router.navigate(['/films']);
      }, error => {
        this.printError(error);
      });
    }
  }

  printError(error: any): void {
    const message = 'Erreur ' + error.error.status + ' : ' + error.error.error
      + ' => ' + error.error.message;
    console.error(error.error);
    this.snackBar.open(message, 'OK', {
      duration: 4000,
    });
  }

  isFilledForm(): boolean {
    if (this.film.titre === undefined || this.film.titre === ''
      || this.film.budget === undefined
      || this.film.montantRecette === undefined
      || this.film.duree === undefined
      || this.film.dateSortie === undefined
      || this.film.categorie === undefined
      || this.film.realisateur === undefined) {
      return true;
    }
    return false;
  }

  updateDataSource(): void {
    this.dataSource = new MatTableDataSource(this.film.personnages);
    this.dataSource.sortingDataAccessor = (item, property) => {
      switch (property) {
        case 'acteur':
          return item.acteur.prenAct + ' ' + item.acteur.nomAct;
        default:
          return item[property];
      }
    };
    this.dataSource.sort = this.sort;
  }

  compareCategories(c1: Categorie, c2: Categorie): boolean {
    if (c2 === undefined) {
      return false;
    }
    return c1.codeCat === c2.codeCat;
  }

  compareRealisateurs(r1: Realisateur, r2: Realisateur): boolean {
    if (r2 === undefined) {
      return false;
    }
    return r1.noRea === r2.noRea;
  }

  removePersonnage(personnage: Personnage): void {
    this.film.personnages.splice(this.film.personnages.indexOf(personnage), 1);
    this.updateDataSource();
  }
}
