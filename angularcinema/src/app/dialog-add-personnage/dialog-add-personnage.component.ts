import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef, MatSnackBar} from '@angular/material';
import {Personnage} from '../model/personnage';
import {Acteur} from '../model/acteur';
import {ActeurService} from '../service/acteur.service';
import {DialogAddActeurComponent} from '../dialog-add-acteur/dialog-add-acteur.component';

@Component({
  selector: 'app-dialog-add-personnage',
  templateUrl: './dialog-add-personnage.component.html',
  styleUrls: ['./dialog-add-personnage.component.css']
})
export class DialogAddPersonnageComponent implements OnInit {

  acteurs: Acteur[];

  constructor(public dialogRef: MatDialogRef<DialogAddPersonnageComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Personnage,
              private acteurService: ActeurService, public dialog: MatDialog,
              private snackBar: MatSnackBar) {
  }

  ngOnInit() {
    this.getActeurs();
  }

  getActeurs(): void {
    this.acteurService.getActeurs().subscribe(acteurs => {
      this.acteurs = acteurs;
    });
  }

  openDialogActeur(): void {
    const dialogRef = this.dialog.open(DialogAddActeurComponent, {
      width: '400px',
      data: {}
    });

    dialogRef.afterClosed().subscribe(result => {
      if (result !== undefined) {
        this.acteurService.addActeur(result).subscribe(res => {
          this.acteurs.push(res);
          this.snackBar.open('Acteur ajouté avec succès !', 'OK', {
            duration: 4000,
          });
        }, error => {
          this.printError(error);
        });
      }
    });
  }

  printError(error: any): void {
    const message = 'Erreur ' + error.error.status + ' : ' + error.error.error
      + ' => ' + error.error.message;
    console.error(error.error);
    this.snackBar.open(message, 'OK', {
      duration: 4000,
    });
  }

}
