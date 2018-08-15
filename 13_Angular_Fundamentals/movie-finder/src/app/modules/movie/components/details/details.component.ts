import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { Movie } from '../../../../models/movie';
import { MoviesService } from '../../../../services/movies.service';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html',
  styleUrls: ['./details.component.css']
})
export class DetailsComponent implements OnInit {

    movie : Movie;
    
    constructor(private route : ActivatedRoute, private moviesService : MoviesService ) { }

    ngOnInit() {
        this.route.params.subscribe(params => {
            let id = params['id'];
            this.moviesService
                .getMovie(id)
                .subscribe(movie => this.movie = movie);
        })
    }
}
