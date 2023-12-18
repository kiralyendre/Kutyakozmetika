import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ReservationService} from "../../../services/reservation.service";
import {ServiceTypeOptionModel} from "../../../models/reservation/service-type-option.model";
import {FormInitDataModel} from "../../../models/reservation/form-init-data.model";
import {error} from "@angular/compiler-cli/src/transformers/util";


@Component({
  selector: 'app-reservation-form',
  templateUrl: './reservation-form.component.html',
  styleUrls: ['./reservation-form.component.css']
})
export class ReservationFormComponent implements OnInit {
  reservationForm!: FormGroup;
  serviceTypeOptions: ServiceTypeOptionModel[] = [];


  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private reservationService: ReservationService
  ) {
    this.reservationForm = this.formBuilder.group({
      animalName: ['', Validators.required],
      startTime: ['', Validators.required],
      serviceTypes: this.formBuilder.array([])
    })
  }

  // ngOnInit(): void {
  //   this.reservationService.getInitialFormData().subscribe({
  //     next: data =>{
  //       this.serviceTypeOptions = data.services;
  //       console.log(data);
  //       this.createCheckboxControls(this.serviceTypeOptions, this.reservationForm.controls["serviceTypes"] as FormArray)
  //     },
  //     error: err => console.error(err),
  //   })
  // }
  ngOnInit(): void {
    this.reservationService.getInitialFormData().subscribe({
      next: async (data) => {
        try {
          if (data && data.services) {
            this.serviceTypeOptions = data.services;
            console.log(this.serviceTypeOptions);
          } else {
            throw new Error('Data or data.services is undefined.');
          }
        } catch (error) {
          console.error('Error handling:', error);
        }
      },
      error: (error) => {
        console.error('Error fetching initial form data:', error);
      }
    });
  }

  saveReservation() {
    let data = this.reservationForm.value
    this.reservationService.saveReservation(data).subscribe(
      () => {
        this.router.navigate(['/successful-reservation']);
      },
    );
  }

  // private createCheckboxControls(options: ServiceTypeOptionModel[], formArray: FormArray) {
  //   options.forEach(option => {
  //     const control = this.formBuilder.control(false);
  //     formArray.push(control);
  //   });
  // }

  private createCheckboxControls() {
    const serviceTypesFormArray = this.reservationForm.get('serviceTypes') as FormArray;
    this.serviceTypeOptions.forEach(() => {
      const control = new FormControl(false);
      serviceTypesFormArray.push(control);
    });
  }
}
