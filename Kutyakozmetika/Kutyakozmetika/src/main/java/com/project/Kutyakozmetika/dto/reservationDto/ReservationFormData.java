package com.project.Kutyakozmetika.dto.reservationDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationFormData {
    private List<ReservationServiceTypeOption> reservationServiceTypeOptions;
}
