import { Component, OnInit } from '@angular/core';
import { MoviesService } from '../../../../services/movies.service';

import { Movies } from '../../../../models/movies';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  searchResults : Movies;
  constructor(private moviesService : MoviesService) { }

  ngOnInit() {
  }

  search(query) {
      this.moviesService
          .findByTitle(query.search)
          .subscribe(data => {this.searchResults = data;});
  }
  
}
