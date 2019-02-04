import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Film} from '../model/film';
import {ConfigService} from '../config.service';

@Injectable({
    providedIn: 'root'
})
export class FilmService {

    url: string;

    constructor(private http: HttpClient, private config: ConfigService) {
        this.url = 'http://' + this.config.adresseIp + ':8080/projetcinema/film';
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
