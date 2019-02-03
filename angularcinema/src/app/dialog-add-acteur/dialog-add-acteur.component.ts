import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Acteur} from '../model/acteur';

@Component({
  selector: 'app-dialog-add-acteur',
  templateUrl: './dialog-add-acteur.component.html',
  styleUrls: ['./dialog-add-acteur.component.css']
})
export class DialogAddActeurComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DialogAddActeurComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Acteur) {
  }

  ngOnInit() {
  }

  isFilledForm(): boolean {
    if (this.data.nomAct === undefined || this.data.nomAct === ''
      || this.data.prenAct === undefined || this.data.prenAct === ''
      || this.data.dateDeces === undefined
      || this.data.dateNaiss === undefined) {
      return true;
    }
    return false;
  }

}
