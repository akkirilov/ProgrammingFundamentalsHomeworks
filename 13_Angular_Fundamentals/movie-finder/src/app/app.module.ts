import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule } from '@angular/router';
import { MovieModule } from './modules/movie/movie.module';
import { AppRoutes } from './app.routes';

import { AppComponent } from './app.component';
import { NavigationComponent } from './navigation/navigation.component';

import { MoviesService } from './services/movies.service';

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    MovieModule,
    RouterModule,
    AppRoutes
  ],
  providers: [MoviesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
