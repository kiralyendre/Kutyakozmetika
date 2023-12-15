import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ReservationCreateCommandModel} from "../models/reservation/reservation-create-command.model";

const BASE_URL = 'http://localhost:8080/api/reservations'

@Injectable({
  providedIn: 'root'
})
export class ReservationService {

  constructor(private http: HttpClient) {

  }

  saveReservation(data: ReservationCreateCommandModel) {
    return this.http.post(BASE_URL, data,{
          headers: this.createAuthorizationHeader()
        });
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
