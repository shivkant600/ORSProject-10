import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule, HttpClient, HTTP_INTERCEPTORS } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpServiceService } from './http-service.service';
import { EndpointServiceService } from './endpoint-service.service';
import { AuthServiceService } from './auth-service.service';
import { ServiceLocatorService } from './service-locator.service';

import { LoginComponent } from './login/login.component';
import { SignupComponent } from './login/signup.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavbarComponent } from './navbar/navbar.component';
import { FormsModule } from '@angular/forms';

import { UserComponent } from './user/user.component';
import { UserlistComponent } from './user/userlist.component';
import { RoleComponent } from './role/role.component';
import { CollegeComponent } from './college/college.component';

@NgModule({
  declarations: [
    AppComponent,
  
    LoginComponent,
    SignupComponent,
    DashboardComponent,
    NavbarComponent,
    UserComponent,
    UserlistComponent,
    RoleComponent,
    CollegeComponent
  ],
  imports: [
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [
     HttpServiceService,
    EndpointServiceService,
    AuthServiceService,
    ServiceLocatorService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
