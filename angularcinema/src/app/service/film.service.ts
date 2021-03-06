import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Film} from '../model/film';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  url = 'http://localhost:8080/projetcinema/film';

  constructor(private http: HttpClient) {
  }

  getFilms(): Observable<Film[]> {
    return this.http.get<Film[]>(this.url);
  }

  getFilm(id: number): Observable<Film> {
    return this.http.get<Film>(this.url + '/' + id);
  }

  addFilm(film: Film): Observable<any> {
    return this.http.post(this.url, film);
  }

  updateFilm(film: Film): Observable<any> {
    return this.http.put(this.url, film);
  }

  deleteFilm(idFilm: number): Observable<any> {
    return this.http.delete(this.url + '/' + idFilm);
  }
}
