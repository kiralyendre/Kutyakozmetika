import {Component} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ReservationService} from "../../../services/reservation.service";
import {ReservationCreateCommandModel} from "../../../models/reservation/reservation-create-command.model";


@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent {
  reservationForm!: FormGroup;


  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private reservationService: ReservationService
  ) {
    this.reservationForm = this.formBuilder.group({
      animalName: ['', Validators.required],
      startTime: ['', Validators.required],
      serviceTypes: [''],
    })
  }

  saveReservation(){
    let data = this.reservationForm.value
    this.reservationService.saveReservation(data).subscribe(
      () => {
        // this.orcForm.reset(); - if we decide to stay on the page
        this.router.navigate(['/successful-reservation']);
      },
    );
  }
}
