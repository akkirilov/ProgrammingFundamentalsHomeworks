import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Form, FormGroup, Validators, FormControl, ReactiveFormsModule } from '@angular/forms';
import {Router} from "@angular/router";

import { AuthenticationService } from '../services/authenticationService';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  errorMsg : string;
  
  registerForm = new FormGroup({
      username: new FormControl('', [Validators.required, Validators.pattern(/^[A-Z][A-Za-z0-9]+$/)]),
      password: new FormControl('', [Validators.required, Validators.pattern(/^[A-Za-z0-9]{4,16}$/)]),
      confirmPassword: new FormControl('', [Validators.required, this.isMatchPassword()]),
      firstName: new FormControl('', [Validators.required, Validators.pattern(/^[A-Z][A-Za-z]+$/)]),
      lastName: new FormControl('', [Validators.required, Validators.pattern(/^[A-Z][A-Za-z]+$/)]),
      email: new FormControl('', [Validators.required, Validators.pattern(/^[a-z]+@[a-z]+\.[a-z]+$/)]),
      age: new FormControl('', [this.isNumber()])
  });
    
  constructor(private authService : AuthenticationService,
          private router: Router) { }

  ngOnInit() {
  }
  
  clearError() {
     this.errorMsg = undefined; 
  }
  
  isMatchPassword() {
      return (c: FormControl) => {
          if (!c.parent || c.value === c.parent.value.password) {
              return null;
          }
          return {invalid: true};
      }
  }
  
  isNumber() {
      return (c: FormControl) => {
          if (c.value == null) {
              c.setValue(0);
          }
          return null;
      }
  }
  
  onSubmit() {
      if (this.authService.isLogged()) {
          this.router.navigate(['/']);
      } else {
          delete(this.registerForm.value.confirmPassword);
          this.authService
              .register(this.registerForm.value)
              .subscribe(data => {
                  console.log(data)
                  this.clearError();
                  this.router.navigate(['/login']);
              },
              error => {
                  console.log(error);
                  this.errorMsg = error['error']['description'];
              })
          }
      }

}
