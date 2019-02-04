import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import {RealisateurService} from '../service/realisateur.service';
import {FilmService} from '../service/film.service';
import {Film} from '../model/film';
import {ModalController} from '@ionic/angular';
import {ModalRealisateurComponent} from '../modal-realisateur/modal-realisateur.component';

@Component({
    selector: 'app-film-item',
    templateUrl: './film-item.component.html',
    styleUrls: ['./film-item.component.scss']
})
export class FilmItemComponent implements OnInit {

    film: Film;
    noFilm: any;

    constructor(private filmService: FilmService, private realisateurService: RealisateurService,
                private route: ActivatedRoute, public modalController: ModalController) {
    }

    ngOnInit() {
        this.noFilm = this.route.snapshot.paramMap.get('noFilm');
        this.getFilm();
    }

    getFilm(): void {
        this.filmService.getFilm(this.noFilm).subscribe(film => {
            this.film = film;
        });
    }


    convertMinsToHrsMins(minutes): string {
        const h = Math.floor(minutes / 60);
        const m = minutes % 60;
        return h + 'h' + m;
    }

    async openModalRealisateurInfos() {
        const modal = await this.modalController.create({
            component: ModalRealisateurComponent,
            componentProps: {noRea: this.film.realisateur.noRea}
        });
        return await modal.present();
    }
}
