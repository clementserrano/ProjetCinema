import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {RouteReuseStrategy} from '@angular/router';

import {IonicModule, IonicRouteStrategy} from '@ionic/angular';
import {SplashScreen} from '@ionic-native/splash-screen/ngx';
import {StatusBar} from '@ionic-native/status-bar/ngx';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import {FilmListComponent} from './film-list/film-list.component';
import {FilmItemComponent} from './film-item/film-item.component';
import {HttpClientModule} from '@angular/common/http';
import {ModalRealisateurComponent} from './modal-realisateur/modal-realisateur.component';
import {FormsModule} from '@angular/forms';

@NgModule({
    declarations: [AppComponent, FilmListComponent, FilmItemComponent, ModalRealisateurComponent],
    entryComponents: [ModalRealisateurComponent],
    imports: [BrowserModule, IonicModule.forRoot(), AppRoutingModule, HttpClientModule, FormsModule],
    providers: [
        StatusBar,
        SplashScreen,
        {provide: RouteReuseStrategy, useClass: IonicRouteStrategy}
    ],
    bootstrap: [AppComponent]
})
export class AppModule {
}
