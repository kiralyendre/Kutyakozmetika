import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuccessfullReservationPageComponent } from './successfull-reservation-page.component';

describe('SuccessfullReservationPageComponent', () => {
  let component: SuccessfullReservationPageComponent;
  let fixture: ComponentFixture<SuccessfullReservationPageComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SuccessfullReservationPageComponent]
    });
    fixture = TestBed.createComponent(SuccessfullReservationPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
