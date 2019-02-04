import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Categorie} from '../model/categorie';
import {ConfigService} from '../config.service';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {

  url: string;

  constructor(private http: HttpClient, private config: ConfigService) {
    this.url = 'http://' + this.config.adresseIp + ':8080/projetcinema/categorie';
  }

  getCategories(): Observable<Categorie[]> {
    return this.http.get<Categorie[]>(this.url);
  }

  getCategorie(code: String): Observable<Categorie> {
    return this.http.get<Categorie>(this.url + '/' + code);
  }

  addCategorie(categorie: Categorie): Observable<any> {
    return this.http.post(this.url, categorie);
  }
}
