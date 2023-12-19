import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ReservationService} from "../../../services/reservation.service";
import {ServiceTypeOptionModel} from "../../../models/reservation/service-type-option.model";

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


  ngOnInit(): void {
    this.reservationService.getInitialFormData().subscribe({
        next: data => {
          this.serviceTypeOptions = data;
          console.log(data)
          this.createCheckboxControls(this.serviceTypeOptions, this.reservationForm.controls["serviceTypes"] as FormArray);
        }
      },
    )
  }

  saveReservation() {
    let data = this.reservationForm.value
    console.log(data);
    data.serviceTypes =this.createServiceTypeArrayToSend();
    this.reservationService.saveReservation(data).subscribe(
      () => {
        this.router.navigate(['/successful-reservation']);
      },
    );
  }
  private createCheckboxControls(options: Array<any>, controlName: FormArray) {
    options.forEach(() => {
      const control = new FormControl(false);
      (controlName).push(control);
    });
  }
  private createServiceTypeArrayToSend(): string[] {
    return this.reservationForm.value.serviceTypes.map((type: string, index: number) =>
      type ? this.serviceTypeOptions[index].name : null)
      .filter((type: string) => type != null);
  }
}
