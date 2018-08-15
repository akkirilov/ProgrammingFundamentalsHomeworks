import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { MovieModule } from './modules/movie/movie.module';

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
    MovieModule
  ],
  providers: [MoviesService],
  bootstrap: [AppComponent]
})
export class AppModule { }
