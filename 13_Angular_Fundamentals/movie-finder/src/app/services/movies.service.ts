import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { Movies } from '../models/movies';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {
    private apiKey = 'bfec65831a949b378e903faa0d164bab';
    
    private url : string = '';
    private path : string = 'https://api.themoviedb.org/3/';
    private popular : string = 'discover/movie?sort_by=popularity.desc';
    private theaters : string = 'discover/movie?primary_release_date.gte=2014-09-15&primary_release_date.lte=2014-10-22';
    private authentication : string = '&api_key=';
    
    constructor(private http : HttpClient) {  }
    
    getPopular() : Observable<Movies> {
        return this.http.get<Movies>(`${this.path}${this.popular}${this.authentication}${this.apiKey}`);
    }
    
    getTheaters() : Observable<Movies> {
        return this.http.get<Movies>(`${this.path}${this.theaters}${this.authentication}${this.apiKey}`);
    }
    
}
