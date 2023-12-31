import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ReservationCreateCommandModel} from "../models/reservation/reservation-create-command.model";
import {Observable} from "rxjs";
import {FormInitDataModel} from "../models/reservation/form-init-data.model";
import {ServiceTypeOptionModel} from "../models/reservation/service-type-option.model";
import {ReservationListItemModel} from "../models/reservation/reservation-list-item.model";

const BASE_URL = 'http://localhost:8080/api/reservations'

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) {

  }

  saveReservation(data: ReservationCreateCommandModel) {
    const jwtToken = localStorage.getItem('jwt');
    const headers = jwtToken ? new HttpHeaders().set('Authorization', 'Bearer ' + jwtToken) : null;
    return this.http.post(BASE_URL, data, {headers});
  }

  getInitialFormData(): Observable<ServiceTypeOptionModel[]> {
    return this.http.get<ServiceTypeOptionModel[]>(BASE_URL + '/serviceTypes', {
      headers: this.createAuthorizationHeader()
    });
  }

  getMyReservation(): Observable<ReservationListItemModel[]> {
    return this.http.get<ReservationListItemModel[]>(BASE_URL + '/myReservation', {
      headers: this.createAuthorizationHeader()
    })
  }

  getAllReservations(): Observable<ReservationListItemModel[]> {
    return this.http.get<ReservationListItemModel[]>(BASE_URL , {
      headers: this.createAuthorizationHeader()
    })
  }

  private createAuthorizationHeader() {
    const jwtToken = localStorage.getItem('jwt');
    if (jwtToken) {
      return new HttpHeaders().set(
        'Authorization', 'Bearer ' + jwtToken
      )
    } else {
      console.log("JWT token not found in the Local Storage");
    }
    return null;
  }
}
