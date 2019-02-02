import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Realisateur} from '../model/realisateur';

@Component({
  selector: 'app-dialog-add-realisateur',
  templateUrl: './dialog-add-realisateur.component.html',
  styleUrls: ['./dialog-add-realisateur.component.css']
})
export class DialogAddRealisateurComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DialogAddRealisateurComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Realisateur) {
  }

  ngOnInit() {
  }

}
