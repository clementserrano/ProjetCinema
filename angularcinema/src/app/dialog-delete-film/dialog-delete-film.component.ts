import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {Film} from '../model/film';

@Component({
  selector: 'app-dialog-delete-film',
  templateUrl: './dialog-delete-film.component.html',
  styleUrls: ['./dialog-delete-film.component.css']
})
export class DialogDeleteFilmComponent implements OnInit {

  constructor(public dialogRef: MatDialogRef<DialogDeleteFilmComponent>,
              @Inject(MAT_DIALOG_DATA) public data: Film) {
  }

  ngOnInit() {
  }

  deleteFilm(reponse: boolean) {
    this.dialogRef.close(reponse);
  }

}
