import { Component, OnInit } from '@angular/core';
import { FormGroup, Validators, FormControl, ReactiveFormsModule } from '@angular/forms';
import { Observable } from 'rxjs';
import {Router} from "@angular/router";

import { AuthenticationService } from '../services/authenticationService';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
    errorMsg : string;

    loginForm = new FormGroup({
        username: new FormControl('', [Validators.required, Validators.pattern(/^[A-Z][A-Za-z0-9]+$/)]),
        password: new FormControl('', [Validators.required, Validators.pattern(/^[A-Za-z0-9]{4,16}$/)])
    });
    
    constructor(private authService : AuthenticationService,
            private router: Router) { }

  ngOnInit() {
  }
  
  clearError() {
     this.errorMsg = undefined; 
  }
  
  onSubmit() {
      if (this.authService.isLogged()) {
          this.router.navigate(['/']);
      } else {
          this.authService
              .login(this.loginForm.value)
              .subscribe(data => {
                  console.log(data);
                  if (data['_kmd'] && data['_kmd']['authtoken']) {
                      sessionStorage.setItem('authtoken', data['_kmd']['authtoken']);
                      sessionStorage.setItem('id', data['_id']);
                      sessionStorage.setItem('username', data['username']);
                      this.clearError();
                      this.router.navigate(['/']);
                  }
              },
              error => {
                  console.log(error);
                  this.loginForm.controls.password.setValue('');
                  this.errorMsg = error['error']['description'];
              })
          }
      }
}
