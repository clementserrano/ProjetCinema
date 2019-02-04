import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {FilmListComponent} from './film-list/film-list.component';
import {FilmItemComponent} from './film-item/film-item.component';

const routes: Routes = [
    {path: '', redirectTo: 'films', pathMatch: 'full'},
    {path: 'films', component: FilmListComponent},
    {path: 'films/:noFilm', component: FilmItemComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule {
}
