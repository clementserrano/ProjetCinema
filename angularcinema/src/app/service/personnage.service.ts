import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Personnage} from '../model/personnage';

@Injectable({
  providedIn: 'root'
})
export class PersonnageService {
  url = 'http://localhost:8080/projetcinema/personnage';

  constructor(private http: HttpClient) {
  }

  getPersonnages(): Observable<Personnage[]> {
    return this.http.get<Personnage[]>(this.url);
  }
}
