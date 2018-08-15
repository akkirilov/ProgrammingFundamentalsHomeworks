import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import { MoviesComponent } from './components/movies/movies.component';
import { MovieComponent } from './components/movie/movie.component';
import { DetailsComponent } from './components/details/details.component';
import { SearchComponent } from './components/search/search.component';

@NgModule({
  imports: [
     CommonModule,
     RouterModule,
     FormsModule
  ],
  declarations: [
     MoviesComponent,
     MovieComponent,
     DetailsComponent,
     SearchComponent
  ],
  exports: [
     MoviesComponent, 
     MovieComponent
  ]
})
export class MovieModule { }
