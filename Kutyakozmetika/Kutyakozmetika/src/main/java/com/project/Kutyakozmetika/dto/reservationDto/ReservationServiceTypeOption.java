package com.project.Kutyakozmetika.dto.reservationDto;

import com.project.Kutyakozmetika.domain.ServiceType;
import lombok.Data;

@Data
public class ReservationServiceTypeOption {
    private String name;

    public ReservationServiceTypeOption(ServiceType serviceType) {
        this.name = serviceType.name();
    }
}
