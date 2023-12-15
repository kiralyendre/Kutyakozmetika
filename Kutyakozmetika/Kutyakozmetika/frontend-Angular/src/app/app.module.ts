import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import { SignupComponent } from './components/signup/signup.component';
import { LoginComponent } from './components/login/login.component';
import { HomeComponent } from './components/home/home.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import {LoadingBarModule} from "@ngx-loading-bar/core";
import {LoadingBarRouterModule} from "@ngx-loading-bar/router";
import {LoadingBarHttpClientModule} from "@ngx-loading-bar/http-client";

import { AnimalFormComponent } from './components/animal/animal-form/animal-form.component';
import { AnimalListComponent } from './components/animal/animal-list/animal-list.component';
import { MyAnimalComponent } from './components/animal/my-animal-list/my-animal.component';
import { ReservationFormComponent } from './components/reservation/reservation-form/reservation-form.component';
import { ReservationListComponent } from './components/reservation/reservation-list/reservation-list.component';
import { MyReservationListComponent } from './components/reservation/my-reservation-list/my-reservation-list.component';
import { SuccessfullReservationPageComponent } from './components/successfull-reservation-page/successfull-reservation-page.component';




@NgModule({
  declarations: [
    AppComponent,
    SignupComponent,
    LoginComponent,
    HomeComponent,
    NavbarComponent,
    AnimalFormComponent,
    AnimalListComponent,
    MyAnimalComponent,
    ReservationFormComponent,
    ReservationListComponent,
    MyReservationListComponent,
    SuccessfullReservationPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    LoadingBarModule,
    LoadingBarRouterModule,
    LoadingBarHttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
