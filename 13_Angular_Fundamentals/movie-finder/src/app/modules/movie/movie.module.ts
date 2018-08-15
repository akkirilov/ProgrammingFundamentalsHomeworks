import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MoviesComponent } from './components/movies/movies.component';
import { MovieComponent } from './components/movie/movie.component';

@NgModule({
  imports: [
     CommonModule
  ],
  declarations: [
     MoviesComponent,
     MovieComponent
  ],
  exports: [
     MoviesComponent, 
     MovieComponent
  ]
})
export class MovieModule { }
