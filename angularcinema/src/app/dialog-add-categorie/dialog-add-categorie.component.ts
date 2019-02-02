import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Categorie} from '../model/categorie';

@Component({
  selector: 'app-dialog-add-categorie',
  templateUrl: './dialog-add-categorie.component.html',
  styleUrls: ['./dialog-add-categorie.component.css']
})
export class DialogAddCategorieComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DialogAddCategorieComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Categorie) {
  }

  ngOnInit() {
  }

}
