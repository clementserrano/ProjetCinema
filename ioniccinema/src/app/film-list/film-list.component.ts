import {Component, OnInit} from '@angular/core';
import {Film} from '../model/film';
import {FilmService} from '../service/film.service';
import {CategorieService} from '../service/categorie.service';
import {MenuController} from '@ionic/angular';

@Component({
    selector: 'app-film-list',
    templateUrl: './film-list.component.html',
    styleUrls: ['./film-list.component.scss']
})
export class FilmListComponent implements OnInit {

    films: Film[];
    allFilms: Film[];
    categories: any[];

    constructor(private filmService: FilmService, private categorieService: CategorieService,
                private menu: MenuController) {
    }

    ngOnInit() {
        this.getFilms();
        this.getCategories();
        this.menu.enable(true, 'categories');
    }

    getFilms(): void {
        this.filmService.getFilms().subscribe(films => {
            this.allFilms = films;
            this.films = films;
        });
    }

    getCategories(): void {
        this.categorieService.getCategories().subscribe(categories => {
            this.categories = categories;
            this.categories.forEach(function (c) {
                c.selected = true;
            });
        });
    }

    changeCat(): void {
        const newFilms: Film[] = [];
        const selectedCategories = this.categories.filter(function (c) {
            return c.selected === true;
        });

        this.allFilms.forEach(function (f) {
            if (selectedCategories.find(function (c) {
                return c.codeCat === f.categorie.codeCat;
            })) {
                newFilms.push(f);
            }
        });

        this.films = newFilms;
    }

}
