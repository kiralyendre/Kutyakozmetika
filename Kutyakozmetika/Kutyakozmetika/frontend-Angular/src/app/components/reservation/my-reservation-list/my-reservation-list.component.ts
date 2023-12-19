import {Component, OnInit} from '@angular/core';
import {ReservationListItemModel} from "../../../models/reservation/reservation-list-item.model";
import {ReservationService} from "../../../services/reservation.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-my-reservation-list',
  templateUrl: './my-reservation-list.component.html',
  styleUrls: ['./my-reservation-list.component.css']
})
export class MyReservationListComponent implements OnInit {
  myReservations!: ReservationListItemModel[]


  constructor(private reservationService: ReservationService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.reservationService.getMyReservation().subscribe({
      next: data => this.myReservations = data,
      error: err => console.warn(err)
    })
  }


}
