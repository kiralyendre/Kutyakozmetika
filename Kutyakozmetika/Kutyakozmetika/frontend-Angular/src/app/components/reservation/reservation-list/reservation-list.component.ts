import {Component, OnInit} from '@angular/core';
import {ReservationListItemModel} from "../../../models/reservation/reservation-list-item.model";
import {ReservationService} from "../../../services/reservation.service";

@Component({
  selector: 'app-reservation-list',
  templateUrl: './reservation-list.component.html',
  styleUrls: ['./reservation-list.component.css']
})
export class ReservationListComponent implements OnInit {
  reservations!: ReservationListItemModel[]

  constructor(private reservationService:ReservationService) {
  }

  ngOnInit(): void {
    this.reservationService.getAllReservations().subscribe({
      next: data => this.reservations = data,
      error: err => console.warn(err)
    })
  }

}
