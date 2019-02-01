import { Component, OnInit } from '@angular/core';
import { FilmService } from '../service/film.service';
import {ActivatedRoute} from '@angular/router';

@Component({
  selector: 'app-film-item',
  templateUrl: './film-item.component.html',
  styleUrls: ['./film-item.component.css']
})
export class FilmItemComponent implements OnInit {
  public noFilm;
  constructor(private filmService: FilmService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.noFilm = this.route.snapshot.paramMap.get('noFilm');
  }

}
