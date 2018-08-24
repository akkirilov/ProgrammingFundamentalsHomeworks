import {
    HttpInterceptor,
    HttpRequest,
    HttpResponse,
    HttpEvent,
    HttpHandler
} from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

const appKey : string = 'kid_BJ0q11jIX';
const appSecret : string = '071345c3bdb44e7aa3b00eb2f1a07f1f';

const basicUrls = [
        appKey,
        'login'
    ];

@Injectable()
export class TokenInterceptor implements HttpInterceptor {

    intercept(request : HttpRequest<any>, next : HttpHandler) : Observable<HttpEvent<any>> {
        let isBasic;
        for (let u of basicUrls) {
            if (request.url.endsWith(u)) {
                isBasic = true;
            }
        }
        
        if (!isBasic && sessionStorage.getItem('authtoken')) {
            request = request.clone({
                setHeaders : {
                    'Authorization': `Kinvey ${sessionStorage.getItem('authtoken')}`,
                    'Content-Type': 'application/json' 
                }
            });
        } else {
            request = request.clone({
                setHeaders : {
                    'Authorization': `Basic ${btoa(appKey+':'+appSecret)}`,
                    'Content-Type': 'application/json'
                }
            });
        }
        
        return next.handle(request);
    }
}