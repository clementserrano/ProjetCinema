import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Categorie} from '../model/categorie';

@Injectable({
  providedIn: 'root'
})
export class CategorieService {
  url = 'http://localhost:8080/projetcinema/categorie';

  constructor(private http: HttpClient) {
  }

  getCategories(): Observable<Categorie[]> {
    return this.http.get<Categorie[]>(this.url);
  }

  getCategorie(code: string): Observable<Categorie> {
    return this.http.get<Categorie>(this.url + '/' + code);
  }

  addCategorie(categorie: Categorie): Observable<Object> {
    return this.http.post(this.url, categorie);
  }
}
