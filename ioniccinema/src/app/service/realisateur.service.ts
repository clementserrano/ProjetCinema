import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Realisateur} from '../model/realisateur';
import {ConfigService} from '../config.service';

@Injectable({
  providedIn: 'root'
})
export class RealisateurService {

  url: string;

  constructor(private http: HttpClient, private config: ConfigService) {
    this.url = 'http://' + this.config.adresseIp + ':8080/projetcinema/realisateur';
  }

  getRealisateurs(): Observable<Realisateur[]> {
    return this.http.get<Realisateur[]>(this.url);
  }

  getRealisateur(id: number): Observable<Realisateur> {
    return this.http.get<Realisateur>(this.url + '/' + id);
  }

  addRealisateur(realisateur: Realisateur): Observable<any> {
    return this.http.post(this.url, realisateur);
  }
}
