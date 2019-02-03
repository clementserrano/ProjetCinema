import { Component, OnInit } from '@angular/core';
import { FilmService } from '../service/film.service';
import {ActivatedRoute} from '@angular/router';
import {MatDialog, MatTableDataSource} from '@angular/material';
import {Film} from '../model/film';
import {RealisateurService} from '../service/realisateur.service';
import {Realisateur} from '../model/realisateur';
import {Categorie} from '../model/categorie';
import {CategorieService} from '../service/categorie.service';
import {DialogAddRealisateurComponent} from '../dialog-add-realisateur/dialog-add-realisateur.component';
import {DialogInfoRealisateurComponent} from '../dialog-info-realisateur/dialog-info-realisateur.component';
import {Personnage} from '../model/personnage';

@Component({
  selector: 'app-film-item',
  templateUrl: './film-item.component.html',
  styleUrls: ['./film-item.component.css']
})
export class FilmItemComponent implements OnInit {
  displayedColumns: string[] = ['Personnage', 'Acteur'];
  dataSourcePersonnages: Personnage[];
  film: Film;
  realisateur: Realisateur;
  public noFilm;
  // films = [{id: 'test1', titre: 'test1titre'}, {id: 'test2', titre: 'test2titre'}];

  constructor(private filmService: FilmService, private realisateurService: RealisateurService,
              private route: ActivatedRoute, public dialog: MatDialog) { }

  ngOnInit() {
    this.noFilm = this.route.snapshot.paramMap.get('noFilm');
    this.getFilm();
  }

  getFilm(): void {
    this.filmService.getFilm(this.noFilm).subscribe(film => {
      this.film = film;
      this.getRealisateur(film.realisateur.noRea);
      this.dataSourcePersonnages = film.personnages;
    });
  }

  getRealisateur(norea): void {
    this.realisateurService.getRealisateur(norea).subscribe(realisateur => {
      this.realisateur = realisateur;
    });
  }

  convertMinsToHrsMins(minutes): string {
    const h = Math.floor(minutes / 60);
    const m = minutes % 60;
    return h + 'h' + m;
  }

  openDialogRealisateurInfos(): void {
    const dialogRef = this.dialog.open(DialogInfoRealisateurComponent, {
      width: '400px',
      data: {dataKey: this.realisateur}
    });
/*
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
    */
  }
}
