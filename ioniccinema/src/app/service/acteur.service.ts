import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Acteur} from '../model/acteur';
import {ConfigService} from '../config.service';

@Injectable({
  providedIn: 'root'
})
export class ActeurService {

  url: string;

  constructor(private http: HttpClient, private config: ConfigService) {
    this.url = 'http://' + this.config.adresseIp + ':8080/projetcinema/acteur';
  }

  getActeurs(): Observable<Acteur[]> {
    return this.http.get<Acteur[]>(this.url);
  }

  getActeur(id: number): Observable<Acteur> {
    return this.http.get<Acteur>(this.url + '/' + id);
  }

  addActeur(acteur: Acteur): Observable<any> {
    return this.http.post(this.url, acteur);
  }
}
