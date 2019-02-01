import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';

import {FilmListComponent} from './film-list/film-list.component';

const routes: Routes = [
  { path: '', redirectTo: '/films', pathMatch: 'full' },
  { path: 'films', component: FilmListComponent }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
