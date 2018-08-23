import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

import { AuthenticationService } from '../authentication/services/authenticationService';

@Component({
  selector: 'app-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.css']
})
export class NavigationComponent implements OnInit {
  
  constructor(public authService : AuthenticationService, 
          private router: Router) { }

  ngOnInit() {  }
  
  logout() {
      if (!this.authService.isLogged()) {
          this.router.navigate(['/login']);
      } else {
          this.authService
              .logout()
              .subscribe(data => {
                  console.log(data);
                  sessionStorage.clear();
              },
              error => {
                  console.log(error);
              })
      }
  }

}
