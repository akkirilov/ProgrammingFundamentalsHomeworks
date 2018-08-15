import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Movies } from '../models/movies';
import { Movie } from '../models/movie';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
    private apiKey = 'bfec65831a949b378e903faa0d164bab';
    
    private path : string = 'https://api.themoviedb.org/3/';
    private find : string = 'movie/';
    private search : string = 'search/movie?query=';
    private popular : string = 'discover/movie?sort_by=popularity.desc';
    private theaters : string = 'discover/movie?primary_release_date.gte=2014-09-15&primary_release_date.lte=2014-10-22';
    private kids : string = 'discover/movie?certification_country=US&certification.lte=G&sort_by=popularity.desc';
    private dramas : string = 'discover/movie?with_genres=18&primary_release_year=2014';
    private authentication : string = 'api_key=';
    
    constructor(private http : HttpClient) {  }
    
    getPopular() : Observable<Movies> {
        return this.http.get<Movies>(`${this.path}${this.popular}&${this.authentication}${this.apiKey}`);
    }
    
    getTheaters() : Observable<Movies> {
        return this.http.get<Movies>(`${this.path}${this.theaters}&${this.authentication}${this.apiKey}`);
    }
    
    getKids() : Observable<Movies> {
        return this.http.get<Movies>(`${this.path}${this.kids}&${this.authentication}${this.apiKey}`);
    }
    
    getDramas() : Observable<Movies> {
        return this.http.get<Movies>(`${this.path}${this.dramas}&${this.authentication}${this.apiKey}`);
    }
    
    getMovie(id) : Observable<Movie> {
        return this.http.get<Movie>(`${this.path}${this.find}${id}?${this.authentication}${this.apiKey}`);
    }
    
    findByTitle(title) : Observable<Movies> {
        return this.http.get<Movies>(`${this.path}${this.search}${title}&${this.authentication}${this.apiKey}`);
    }
    
}
