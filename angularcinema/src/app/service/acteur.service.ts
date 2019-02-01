import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Acteur} from '../model/acteur';

@Injectable({
  providedIn: 'root'
})
export class ActeurService {
  url = 'http://localhost:8080/projetcinema/acteur';

  constructor(private http: HttpClient) {
  }

  getActeurs(): Observable<Acteur[]> {
    return this.http.get<Acteur[]>(this.url);
  }

  getActeur(id: number): Observable<Acteur> {
    return this.http.get<Acteur>(this.url + '/' + id);
  }
}
