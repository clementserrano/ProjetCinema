import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Personnage} from '../model/personnage';
import {ConfigService} from '../config.service';

@Injectable({
  providedIn: 'root'
})
export class PersonnageService {

  url: string;

  constructor(private http: HttpClient, private config: ConfigService) {
    this.url = 'http://' + this.config.adresseIp + ':8080/projetcinema/personnage';
  }

  getPersonnages(): Observable<Personnage[]> {
    return this.http.get<Personnage[]>(this.url);
  }
}
