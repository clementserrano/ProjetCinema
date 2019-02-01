import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Realisateur} from '../model/realisateur';

@Injectable({
  providedIn: 'root'
})
export class RealisateurService {
  url = 'http://localhost:8080/projetcinema/realisateur';

  constructor(private http: HttpClient) {
  }

  getRealisateurs(): Observable<Realisateur[]> {
    return this.http.get<Realisateur[]>(this.url);
  }

  getRealisateur(id: number): Observable<Realisateur> {
    return this.http.get<Realisateur>(this.url + '/' + id);
  }
}
