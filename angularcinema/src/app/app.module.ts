import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppComponent} from './app.component';
import {NavbarComponent} from './navbar/navbar.component';
import {FilmListComponent} from './film-list/film-list.component';
import {FilmItemComponent} from './film-item/film-item.component';

import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {CommonModule} from '@angular/common';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {FilmAddUpdateComponent} from './film-add-update/film-add-update.component';
import {MaterialModule} from './material.module';
import {DialogAddRealisateurComponent} from './dialog-add-realisateur/dialog-add-realisateur.component';
import {DialogAddCategorieComponent} from './dialog-add-categorie/dialog-add-categorie.component';
import {DialogAddPersonnageComponent} from './dialog-add-personnage/dialog-add-personnage.component';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { DialogAddActeurComponent } from './dialog-add-acteur/dialog-add-acteur.component';
import { DialogInfoRealisateurComponent } from './dialog-info-realisateur/dialog-info-realisateur.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FilmListComponent,
    FilmItemComponent,
    FilmAddUpdateComponent,
    DialogAddRealisateurComponent,
    DialogAddCategorieComponent,
    DialogAddPersonnageComponent,
    DialogAddActeurComponent,
    DialogInfoRealisateurComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    CommonModule,
    BrowserAnimationsModule,
    MaterialModule,
    FormsModule,
    ReactiveFormsModule
  ],
  entryComponents: [
    FilmAddUpdateComponent,
    DialogAddRealisateurComponent,
    DialogAddCategorieComponent,
    DialogAddPersonnageComponent,
    DialogAddActeurComponent,
    DialogInfoRealisateurComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
