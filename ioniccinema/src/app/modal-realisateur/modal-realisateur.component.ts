import {Component, Input, OnInit} from '@angular/core';
import {RealisateurService} from '../service/realisateur.service';
import {Realisateur} from '../model/realisateur';

@Component({
    selector: 'app-modal-realisateur',
    templateUrl: './modal-realisateur.component.html',
    styleUrls: ['./modal-realisateur.component.scss']
})
export class ModalRealisateurComponent implements OnInit {

    @Input() noRea: number;
    realisateur: Realisateur;

    constructor(private realisateurService: RealisateurService) {
    }

    ngOnInit() {
        this.getRealisateur();
    }

    getRealisateur(): void {
        this.realisateurService.getRealisateur(this.noRea).subscribe(realisateur => {
            this.realisateur = realisateur;
        });
    }

}
