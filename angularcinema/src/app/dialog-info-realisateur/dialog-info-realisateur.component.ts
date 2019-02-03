import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Realisateur} from '../model/realisateur';

@Component({
  selector: 'app-dialog-info-realisateur',
  templateUrl: './dialog-info-realisateur.component.html',
  styleUrls: ['./dialog-info-realisateur.component.css']
})
export class DialogInfoRealisateurComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DialogInfoRealisateurComponent>,
              @Inject(MAT_DIALOG_DATA) public data: any) { }

  ngOnInit() {
  }

}
