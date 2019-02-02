import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from '@angular/material';
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
              private acteurService: ActeurService, public dialog: MatDialog) {
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
        this.acteurs.push(result);
      }
    });
  }

}
