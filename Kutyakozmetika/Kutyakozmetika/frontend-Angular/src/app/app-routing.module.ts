import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {SignupComponent} from "./components/signup/signup.component";
import {LoginComponent} from "./components/login/login.component";
import {HomeComponent} from "./components/home/home.component";
import {AnimalFormComponent} from "./components/animal/animal-form/animal-form.component";
import {AnimalListComponent} from "./components/animal/animal-list/animal-list.component";
import {MyAnimalComponent} from "./components/animal/my-animal-list/my-animal.component";
import {ReservationFormComponent} from "./components/reservation/reservation-form/reservation-form.component";
import {ReservationListComponent} from "./components/reservation/reservation-list/reservation-list.component";
import {MyReservationListComponent} from "./components/reservation/my-reservation-list/my-reservation-list.component";
import {
  SuccessfullReservationPageComponent
} from "./components/successfull-reservation-page/successfull-reservation-page.component";

const routes: Routes = [
  {path: 'signup', component: SignupComponent},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},

  {path: 'animal-form', component: AnimalFormComponent},
  {path: 'animal-list', component: AnimalListComponent},
  {path: 'my-animal', component: MyAnimalComponent},

  {path: 'reservation-form', component: ReservationFormComponent},
  {path: 'reservation-list', component: ReservationListComponent},
  {path: 'my-reservation-list', component: MyReservationListComponent},

  {path: 'successful-reservation', component: SuccessfullReservationPageComponent},



];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
