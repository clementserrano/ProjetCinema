import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FilmListComponent } from './film-list/film-list.component';
import { FilmItemComponent } from './film-item/film-item.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    FilmListComponent,
    FilmItemComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
