import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ModuleWithProviders } from '@angular/core';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './authentication/login/login.component';
import { RegisterComponent } from './authentication/register/register.component'; 
import { AuthGuard } from './auth.guard'; 

const routes : Routes = [
                   {path: '', component: HomeComponent, canActivate: [AuthGuard]},
                   {path: 'login', component: LoginComponent},
                   {path: 'register', component: RegisterComponent}
               ];
@NgModule({
        imports: [RouterModule.forRoot(routes)]
})
export class AppRoutes {
    
}