import {Injectable} from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class ConfigService {

    adresseIp: string;

    constructor() {
        this.adresseIp = '192.168.43.108';
    }
}
