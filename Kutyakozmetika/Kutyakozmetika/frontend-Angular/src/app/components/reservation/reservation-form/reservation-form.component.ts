import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ReservationService} from "../../../services/reservation.service";
import {ServiceTypeOptionModel} from "../../../models/reservation/service-type-option.model";
import {FormInitDataModel} from "../../../models/reservation/form-init-data.model";


@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnInit {
  reservationForm!: FormGroup;
  serviceTypeOptions!: ServiceTypeOptionModel[];


  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private reservationService: ReservationService
  ) {
    this.reservationForm = this.formBuilder.group({
      animalName: ['', Validators.required],
      startTime: ['', Validators.required],
      serviceTypes: this.formBuilder.array([], Validators.required),
    })
  }

  ngOnInit(): void {
    this.reservationService.getInitialFormData().subscribe((formInitData: FormInitDataModel) => {
      this.serviceTypeOptions = formInitData.services;
      this.createCheckboxControls(this.serviceTypeOptions, this.reservationForm.controls["serviceTypes"] as FormArray);
    })
  }

  saveReservation() {
    let data = this.reservationForm.value
    this.reservationService.saveReservation(data).subscribe(
      () => {
        // this.orcForm.reset(); - if we decide to stay on the page
        this.router.navigate(['/successful-reservation']);
      },
    );
  }

  private createCheckboxControls(options: ServiceTypeOptionModel[], formArray: FormArray) {
    options.forEach(() => {
      const control = this.formBuilder.control(false);
      formArray.push(control);
    });
  }
}
