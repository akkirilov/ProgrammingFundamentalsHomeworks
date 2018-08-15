import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

import { MoviesComponent } from './modules/movie/components/movies/movies.component';
import { DetailsComponent } from './modules/movie/components/details/details.component';

const routes : Routes = [
                   {path: '', component: MoviesComponent},
                   {path: 'details/:id', component: DetailsComponent}
               ];
@NgModule({
        imports: [RouterModule.forRoot(routes)]
})
export class AppRoutes {
    
}