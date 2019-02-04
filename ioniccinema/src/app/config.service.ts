import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class ConfigService {

    adresseIp: string;

    constructor() {
        this.adresseIp = 'localhost';
    }
}
