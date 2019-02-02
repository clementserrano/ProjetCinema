import {Component, OnInit, ViewChild} from '@angular/core';
import {FilmService} from '../service/film.service';
import {Film} from '../model/film';
import {Categorie} from '../model/categorie';
import {Realisateur} from '../model/realisateur';
import {Personnage} from '../model/personnage';
import {RealisateurService} from '../service/realisateur.service';
import {PersonnageService} from '../service/personnage.service';
import {CategorieService} from '../service/categorie.service';
import {MatDialog, MatSnackBar, MatSort, MatTableDataSource} from '@angular/material';
import {DialogAddPersonnageComponent} from '../dialog-add-personnage/dialog-add-personnage.component';
import {DialogAddCategorieComponent} from '../dialog-add-categorie/dialog-add-categorie.component';
import {DialogAddRealisateurComponent} from '../dialog-add-realisateur/dialog-add-realisateur.component';

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

  dataSource;
  @ViewChild(MatSort) sort: MatSort;
  displayedColumns: string[] = ['acteur', 'role'];

  constructor(private filmService: FilmService, private realisateurService: RealisateurService,
              private categorieService: CategorieService, private personnageService: PersonnageService,
              public dialog: MatDialog, private snackBar: MatSnackBar) {
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

  openDialogRealisateur(): void {
    const dialogRef = this.dialog.open(DialogAddRealisateurComponent, {
      width: '400px',
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.realisateurService.addRealisateur(result).subscribe(res => {
          if (res !== undefined) {
            this.realisateurs.push(result);
            this.snackBar.open('Réalisateur ajouté avec succès !', 'OK', {
              duration: 4000,
            });
          }
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
          if (res !== undefined) {
            this.categories.push(result);
            this.snackBar.open('Catégorie ajoutée avec succès !', 'OK', {
              duration: 4000,
            });
          }
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
        this.personnages.push(result);
        this.dataSource = new MatTableDataSource(this.personnages);
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
    });
  }
}
