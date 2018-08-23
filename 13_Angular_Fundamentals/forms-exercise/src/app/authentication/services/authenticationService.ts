import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { LoginModel } from '../models/login';
import { RegisterModel } from '../models/register';

@Injectable({
    providedIn: 'root'
})
export class AuthenticationService {
    private appKey : string = 'kid_BJ0q11jIX';
    private appSecret : string = '071345c3bdb44e7aa3b00eb2f1a07f1f';
    private registerUrl : string = `https://baas.kinvey.com/user/${this.appKey}`;
    private loginUrl : string = `https://baas.kinvey.com/user/${this.appKey}/login`;
    private logoutUrl : string = `https://baas.kinvey.com/user/${this.appKey}/_logout`;

    constructor(private http : HttpClient) {  }
    
    private crateAuthHeader(type : string) : HttpHeaders {
        if (type && type.toLowerCase() == 'kinvey') {
            return new HttpHeaders({
                'Authorization': `Kinvey ${sessionStorage.getItem('authtoken')}`,
                'Content-Type': 'application/json'
            });
        } else {
            return new HttpHeaders({
                'Authorization': `Basic ${btoa(this.appKey+':'+this.appSecret)}`,
                'Content-Type': 'application/json'
            });
        }
    }
    
    isLogged() : boolean {
        return sessionStorage.getItem('authtoken') != undefined;
    }
    
    login(loginModel : LoginModel) : Observable<Object> {

        return this.http.post<Object>(this.loginUrl, JSON.stringify(loginModel), { 'headers': this.crateAuthHeader('') })
    }
    
    register(registerModel : RegisterModel) : Observable<Object> {
        return this.http.post<Object>(this.registerUrl, JSON.stringify(registerModel), { 'headers': this.crateAuthHeader('') })
    }
    
    logout() : Observable<Object> {
        return this.http.post<Object>(this.logoutUrl, {}, { 'headers': this.crateAuthHeader('kinvey') })
    }
    
}
