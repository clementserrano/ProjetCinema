import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {FilmListComponent} from './film-list/film-list.component';
import {FilmAddUpdateComponent} from './film-add-update/film-add-update.component';

const routes: Routes = [
  {path: '', redirectTo: '/films', pathMatch: 'full'},
  {path: 'films', component: FilmListComponent},
  {path: 'addFilm', component: FilmAddUpdateComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
